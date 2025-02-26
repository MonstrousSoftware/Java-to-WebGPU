package com.monstrous.webgpu;

import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSurfaceDescriptorFromWaylandSurface extends WgpuJavaStruct {

    private final WGPUChainedStruct chain = inner(WGPUChainedStruct.createHeap());
    private final Pointer display = new Pointer();
    private final Pointer surface = new Pointer();

    private WGPUSurfaceDescriptorFromWaylandSurface(){}

    @Deprecated
    public WGPUSurfaceDescriptorFromWaylandSurface(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSurfaceDescriptorFromWaylandSurface createHeap(){
        return new WGPUSurfaceDescriptorFromWaylandSurface();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSurfaceDescriptorFromWaylandSurface createDirect(){
        var struct = new WGPUSurfaceDescriptorFromWaylandSurface();
        struct.useDirectMemory();
        return struct;
    }


    public WGPUChainedStruct getChain(){
        return chain;
    }

    public jnr.ffi.Pointer getDisplay(){
        return display.get();
    }

    public void setDisplay(jnr.ffi.Pointer x){
        this.display.set(x);
    }

    public jnr.ffi.Pointer getSurface(){
        return surface.get();
    }

    public void setSurface(jnr.ffi.Pointer x){
        this.surface.set(x);
    }

}