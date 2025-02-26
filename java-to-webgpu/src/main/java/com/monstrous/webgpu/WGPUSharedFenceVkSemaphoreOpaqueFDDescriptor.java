package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Unsigned32 handle = new Unsigned32();

    private WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor(){}

    @Deprecated
    public WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor createHeap(){
        return new WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor createDirect(){
        var struct = new WGPUSharedFenceVkSemaphoreOpaqueFDDescriptor();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getHandle(){
        return handle.get();
    }

    public void setHandle(long x){
        this.handle.set(x);
    }

}