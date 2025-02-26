package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUProgrammableStageDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Pointer module = new Pointer();
    private final @CStrPointer Pointer entryPoint = new Pointer();
    private final size_t constantCount = new size_t();
    private final DynamicStructRef<WGPUConstantEntry> constants = new DynamicStructRef<>(WGPUConstantEntry.class);

    private WGPUProgrammableStageDescriptor(){}

    @Deprecated
    public WGPUProgrammableStageDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUProgrammableStageDescriptor createHeap(){
        return new WGPUProgrammableStageDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUProgrammableStageDescriptor createDirect(){
        var struct = new WGPUProgrammableStageDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStruct> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStruct... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public jnr.ffi.Pointer getModule(){
        return module.get();
    }

    public void setModule(jnr.ffi.Pointer x){
        this.module.set(x);
    }

    public java.lang.String getEntryPoint(){
        return RustCString.fromPointer(entryPoint.get());
    }

    public void setEntryPoint(java.lang.String x){
        this.entryPoint.set(RustCString.toPointer(x));
    }

    public long getConstantCount(){
        return constantCount.get();
    }

    public void setConstantCount(long x){
        this.constantCount.set(x);
    }

    public DynamicStructRef<WGPUConstantEntry> getConstants(){
        return constants;
    }

    public void setConstants(WGPUConstantEntry... x){
        if(x.length == 0 || x[0] == null){
            this.constants.set(JavaWebGPU.createNullPointer());
        } else {
            this.constants.set(x);
        }
    }

}