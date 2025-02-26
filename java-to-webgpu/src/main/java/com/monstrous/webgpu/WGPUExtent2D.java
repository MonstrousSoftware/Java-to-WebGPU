package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUExtent2D extends WgpuJavaStruct {

    private final Unsigned32 width = new Unsigned32();
    private final Unsigned32 height = new Unsigned32();

    private WGPUExtent2D(){}

    @Deprecated
    public WGPUExtent2D(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUExtent2D createHeap(){
        return new WGPUExtent2D();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUExtent2D createDirect(){
        var struct = new WGPUExtent2D();
        struct.useDirectMemory();
        return struct;
    }


    public long getWidth(){
        return width.get();
    }

    public void setWidth(long x){
        this.width.set(x);
    }

    public long getHeight(){
        return height.get();
    }

    public void setHeight(long x){
        this.height.set(x);
    }

}