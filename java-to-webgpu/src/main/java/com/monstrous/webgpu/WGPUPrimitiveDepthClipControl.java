package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUPrimitiveDepthClipControl extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Unsigned32 unclippedDepth = new Unsigned32();

    private WGPUPrimitiveDepthClipControl(){}

    @Deprecated
    public WGPUPrimitiveDepthClipControl(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUPrimitiveDepthClipControl createHeap(){
        return new WGPUPrimitiveDepthClipControl();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUPrimitiveDepthClipControl createDirect(){
        var struct = new WGPUPrimitiveDepthClipControl();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public long getUnclippedDepth(){
        return unclippedDepth.get();
    }

    public void setUnclippedDepth(long x){
        this.unclippedDepth.set(x);
    }

}