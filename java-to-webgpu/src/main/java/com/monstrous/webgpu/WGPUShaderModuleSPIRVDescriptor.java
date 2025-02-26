package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUShaderModuleSPIRVDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Unsigned32 codeSize = new Unsigned32();
    private final Pointer code = new Pointer();

    private WGPUShaderModuleSPIRVDescriptor(){}

    @Deprecated
    public WGPUShaderModuleSPIRVDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUShaderModuleSPIRVDescriptor createHeap(){
        return new WGPUShaderModuleSPIRVDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUShaderModuleSPIRVDescriptor createDirect(){
        var struct = new WGPUShaderModuleSPIRVDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getCodeSize(){
        return codeSize.get();
    }

    public void setCodeSize(long x){
        this.codeSize.set(x);
    }

    public jnr.ffi.Pointer getCode(){
        return code.get();
    }

    public void setCode(jnr.ffi.Pointer x){
        this.code.set(x);
    }

}