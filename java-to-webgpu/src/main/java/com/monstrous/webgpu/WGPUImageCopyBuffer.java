package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUImageCopyBuffer extends WgpuJavaStruct {

    private final WGPUTextureDataLayout layout = inner(WGPUTextureDataLayout.createHeap());
    private final Pointer buffer = new Pointer();

    private WGPUImageCopyBuffer(){}

    @Deprecated
    public WGPUImageCopyBuffer(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUImageCopyBuffer createHeap(){
        return new WGPUImageCopyBuffer();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUImageCopyBuffer createDirect(){
        var struct = new WGPUImageCopyBuffer();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUTextureDataLayout getLayout(){
        return layout;
    }

    public jnr.ffi.Pointer getBuffer(){
        return buffer.get();
    }

    public void setBuffer(jnr.ffi.Pointer x){
        this.buffer.set(x);
    }

}