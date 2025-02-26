package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUBindGroupDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final @CStrPointer Pointer label = new Pointer();
    private final Pointer layout = new Pointer();
    private final size_t entryCount = new size_t();
    private final DynamicStructRef<WGPUBindGroupEntry> entries = new DynamicStructRef<>(WGPUBindGroupEntry.class);

    private WGPUBindGroupDescriptor(){}

    @Deprecated
    public WGPUBindGroupDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUBindGroupDescriptor createHeap(){
        return new WGPUBindGroupDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUBindGroupDescriptor createDirect(){
        var struct = new WGPUBindGroupDescriptor();
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

    public java.lang.String getLabel(){
        return RustCString.fromPointer(label.get());
    }

    public void setLabel(java.lang.String x){
        this.label.set(RustCString.toPointer(x));
    }

    public jnr.ffi.Pointer getLayout(){
        return layout.get();
    }

    public void setLayout(jnr.ffi.Pointer x){
        this.layout.set(x);
    }

    public long getEntryCount(){
        return entryCount.get();
    }

    public void setEntryCount(long x){
        this.entryCount.set(x);
    }

    public DynamicStructRef<WGPUBindGroupEntry> getEntries(){
        return entries;
    }

    public void setEntries(WGPUBindGroupEntry... x){
        if(x.length == 0 || x[0] == null){
            this.entries.set(JavaWebGPU.createNullPointer());
        } else {
            this.entries.set(x);
        }
    }

}