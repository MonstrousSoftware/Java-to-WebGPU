
package jnrgen;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class StructItem implements Item {

    public static final String doNotUsePrefix = "_NO_USE_";
    public static final String createDirectJavadoc = "\t/**" +
            "\n\t* Creates this struct in direct memory." +
            "\n\t* This is how most structs should be created (unless, they" +
            "\n\t* are members of a nothing struct)" +
            "\n\t* " +
            "\n\t* @see WgpuJavaStruct#useDirectMemory" +
            "\n\t*/\n";
    public static final String createHeapJavaDoc = "\t/**" +
            "\n\t* Creates this struct on the java heap." +
            "\n\t* In general, this should <b>not</b> be used because these structs" +
            "\n\t* cannot be directly passed into native code. " +
            "\n\t*/\n";

    private final String name;
    private final List<StructField> fields;


    public StructItem(String name, List<StructField> fields) {
        this.name = OutputHandler.toExportName(name); //.replace("WGPU", "Wgpu"));
        this.fields = fields;
    }

    @Override
    public void preSave(OutputHandler outputHandler) {
        outputHandler.registerType(name, this); //.replace("Wgpu", "WGPU"), this);
        outputHandler.runHooks(this);
    }

    @Override
    public void save(OutputHandler outputHandler) throws IOException {
        if (OutputHandler.isExcluded(name)) {
            return;
        }

        BufferedWriter writer = outputHandler.startFile(name + ".java",
                "com.monstrous.utils.JavaWebGPU",
                "com.monstrous.utils.CStrPointer",
                "com.monstrous.utils.WgpuJavaStruct",
                "com.monstrous.utils.RustCString",
                "jnr.ffi.Runtime",
                "jnr.ffi.Struct",
                "org.jetbrains.annotations.Nullable");

        writer.write("public class ");
        writer.write(name);
        writer.write(" extends WgpuJavaStruct {\n\n");

        for (StructField field : fields) {
            field.convertTypes(outputHandler);
            field.writeDeclaration(writer);
        }

        writeConstructors(writer);

        for (StructField field : fields) {
            if (!field.name.startsWith(doNotUsePrefix)) {
                field.writeGetter(writer, outputHandler);
                field.writeSetter(writer, name, outputHandler);
            }
        }

        writer.write("}");

        writer.flush();
        writer.close();
    }

    private void writeConstructors(BufferedWriter writer) throws IOException {
        writer.write("\n");

        writer.write("    private ");
        writer.write(name);
        writer.write("(){}\n\n");

        // it is actually still needed by the class loader
        writer.write("    @Deprecated\n    public ");
        writer.write(name);
        writer.write("(Runtime runtime){\n        super(runtime);\n    }\n\n");

        writer.write(createHeapJavaDoc);
        writer.write("    public static ");
        writer.write(name);
        writer.write(" createHeap(){\n        return new ");
        writer.write(name);
        writer.write("();\n    }\n\n");

        writer.write(createDirectJavadoc);
        writer.write("    public static ");
        writer.write(name);
        writer.write(" createDirect(){\n        ");
        writer.write(name);
        writer.write(" struct = new ");
        writer.write(name);
        writer.write("();\n        struct.useDirectMemory();\n        return struct;\n    }\n\n");

        writer.write("\n");
    }

    @Override
    public String getJavaTypeName() {
        return name;
    }

    @Override
    public String toString() {
        return "Struct(" + getJavaTypeName() + ")";
    }

    static public class StructField {
        private String name;
        private String type;
        private boolean nullable;
        private String createType;

//        public StructField(String type, String name) {
//            this(type, name, true);
//        }

        public StructField(String type, String name, boolean nullable) {
            this.name = name; //convertCase ? toCamelCase(name) : name;
            this.type = type;
            this.nullable = nullable;
        }

        public void convertTypes(OutputHandler handler) {
            if (type.equals("const char") || (type.equals("char") && name.startsWith("*"))) {
                type = "@CStrPointer Struct.Pointer";
                createType = "new Struct.Pointer();";
                name = name.replace("*", "");
            } else if (name.startsWith("*")) {
                name = name.substring(1);
                if (handler.containsType(type)) {
                    Item item = handler.resolveType(this.type);
                    if(item instanceof EnumItem){
                        type = "Struct.Pointer";
                    } else {
                        String type = item.getJavaTypeName();

                        this.type = "DynamicStructRef<" + type + ">";
                        this.createType = "new DynamicStructRef<>(" + type + ".class);";
                    }
                } else {
                    type = "Struct.Pointer";
                }
            } else if (type.equals("uintptr_t") || type.equals("uint64_t") || type.equals("unsigned long long")) {
                type = "Struct.Unsigned64";
            } else if (type.equals("uint32_t")) {
                type = "Struct.Unsigned32";
            } else if (type.equals("uint16_t")) {
                type = "Struct.Unsigned16";
            } else if (type.equals("int32_t")) {
                type = "Struct.Signed32";
            } else if (type.equals("uint8_t")) {
                type = "Struct.Unsigned8";
            } else if (type.equals("size_t")) {
                type = "Struct.size_t";
            } else if (type.equals("int")) {        // defined in webgpu spec?
                type = "Struct.Unsigned32";
            } else if (type.equals("bool")) {
                type = "Struct.WBOOL";          // 32 bit boolean
            } else if (type.equals("float")) {
                type = "Struct.Float";
            } else if (type.equals("double")) {
                type = "Struct.Double";
            } else if (type.equals("void*")) {
                type = "Struct.Pointer";
            } else if (handler.containsType(type)) {
                resolveType(handler.resolveType(type));
            } else if (handler.containsPointer(type)) { // opaque pointer
                type = "Struct.Pointer";
            } else if (handler.containsAlias(type)) {
                type = handler.getAlias(type);
                convertTypes(handler);
            }
            else if(handler.containsCallback(type)) {
                type = "Struct.Pointer";
            } else {
                throw new RuntimeException("unknown type: " + this.type);
            }
        }

        private void resolveType(Item item) {
            if (item instanceof EnumItem) {
                boolean contiguous = ((EnumItem) item).contiguous;
                if(contiguous) {
                    type = "Struct.Enum<" + item.getJavaTypeName() + ">";
                    createType = "new Struct.Enum<>(" + item.getJavaTypeName() + ".class);";
                }
                else {
                    type = "Struct.Unsigned32";
                    createType = "new Struct.Unsigned32();";                }
            } else if (item instanceof StructItem || item instanceof MockStructItem) {
                type = item.getJavaTypeName();
                createType = "inner(" + item.getJavaTypeName() + ".createHeap());";
            }
        }

        private void writeDeclaration(BufferedWriter writer) throws IOException {
            writer.write("    private final ");
            if(nullable)
                writer.write("@Nullable ");
            writer.write(type);
            writer.write(" ");
            writer.write(name);
            writer.write(" = ");

            if (createType == null) {
                writer.write("new ");
                writer.write(type);
                writer.write("();");
            } else {
                writer.write(createType);
            }

            writer.write("\n");
        }

        private String toCamelCase(String name) {
            StringBuilder output = new StringBuilder();

            boolean wasUnderscore = false;
            for (char c : name.toCharArray()) {
                if (c == '_') {
                    wasUnderscore = true;
                } else if (wasUnderscore) {
                    wasUnderscore = false;
                    output.append(Character.toUpperCase(c));
                } else {
                    output.append(Character.toLowerCase(c));
                }
            }

            return output.toString();
        }

        public void writeGetter(BufferedWriter writer, OutputHandler handler) throws IOException {
            if (type.startsWith("@CStrPointer")) {
                writeStringGetter(writer);
                return;
            }

            writer.write("    public ");
            writer.write(getGetterSetterType(type, handler, true));
            writer.write(" ");
            writer.write("get");
            writer.write(name.substring(0, 1).toUpperCase());
            writer.write(name.substring(1));
            writer.write("(){\n        return ");
            writer.write(name);

            if (type.startsWith("Struct.")) {
                writer.write(".get()");
            }

            writer.write(";\n    }\n\n");
        }

        public void writeSetter(BufferedWriter writer, String className, OutputHandler handler) throws IOException {
            if (type.startsWith("@CStrPointer")) {
                writeStringSetter(writer, className);
                return;
            } else if (type.startsWith("DynamicStructRef")) {
                writeStructRefSetter(writer, className, handler);
                return;
            } else if (!type.startsWith("Struct.")) {
                //Must be an inner struct
                return;
            }

            writer.write("    public ");
            writer.write(className);
            writer.write(" set");
            writer.write(name.substring(0, 1).toUpperCase());
            writer.write(name.substring(1));
            writer.write("(");
            writer.write(getGetterSetterType(type, handler, false));
            writer.write(" val){\n        this.");
            writer.write(name);
            writer.write(".set(val); return this;\n    }\n\n");
        }

        private void writeStructRefSetter(BufferedWriter writer, String className, OutputHandler handler) throws IOException {
            writer.write("    public ");
            writer.write(className);
            writer.write(" set");
            writer.write(name.substring(0, 1).toUpperCase());
            writer.write(name.substring(1));
            writer.write("(");
            writer.write(getGetterSetterType(type, handler, false));
            writer.write(" x){\n        if(x.length == 0 || x[0] == null){\n");
            writer.write("            this.");
            writer.write(name);
            writer.write(".set(JavaWebGPU.createNullPointer());\n        } else {\n            this.");
            writer.write(name);
            writer.write(".set(x);\n        }\n        return this;\n    }\n\n");
        }

        private void writeStringSetter(BufferedWriter writer, String className) throws IOException {
            writer.write("    public ");
            writer.write(className);
            writer.write(" set");
            writer.write(name.substring(0, 1).toUpperCase());
            writer.write(name.substring(1));
            writer.write("(java.lang.String str){\n        this.");
            writer.write(name);
            writer.write(".set(RustCString.toPointer(str)); return this;\n    }\n\n");
        }

        private void writeStringGetter(BufferedWriter writer) throws IOException {
            writer.write("    public java.lang.String ");
            writer.write("get");
            writer.write(name.substring(0, 1).toUpperCase());
            writer.write(name.substring(1));
            writer.write("(){\n        return RustCString.fromPointer(" + name + ".get());\n    }\n\n");
        }

        private String getGetterSetterType(String type, OutputHandler handler, boolean isGetter) {
            if (type.equals("Struct.Unsigned64") || type.equals("Struct.Signed64") ) {
                return "@jnr.ffi.types.u_int64_t long";      // may cause truncation
            } else if ( type.equals("Struct.Unsigned32")) {
                return "long";  // because java int is signed
            }else if (type.equals("Struct.size_t")) {
                return "long";
            } else if (type.equals("Struct.Unsigned16")) {
                return "int";
            } else if (type.equals("Struct.Signed32")) {
                return "int";
            } else if (type.equals("Struct.Unsigned8")) {
                return "short";
            } else if (type.equals("Struct.Boolean")) {
                return "boolean";
            } else if (type.equals("Struct.WBOOL")) {
                return "boolean";
            } else if (type.equals("Struct.Float")) {
                return "float";
            } else if (type.equals("Struct.Double")) {
                return "double";
            } else if (handler.containsType(type.replace("Wgpu", "WGPU"))) {
                return type;
            } else if (type.startsWith("Struct.Enum")) {
                return type.split("<|>")[1];
            } else if (type.equals("Struct.Pointer")) {
                return "jnr.ffi.Pointer";
            } else if (type.startsWith("DynamicStructRef")) {
                String javaType = type.split("<|>")[1];

                return isGetter ? type : javaType + "...";
            }
//            else if(handler.containsCallback(type)) {
//                return type;
//            }

            throw new RuntimeException("Unable to create getter/setter type for " + type);
        }
    }

    public List<StructField> getFields() {
        return fields;
    }
}
