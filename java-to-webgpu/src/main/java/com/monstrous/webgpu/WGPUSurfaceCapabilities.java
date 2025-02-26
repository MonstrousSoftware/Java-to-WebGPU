package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSurfaceCapabilities extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStructOut> nextInChain = new DynamicStructRef<>(WGPUChainedStructOut.class);
    private final Unsigned32 usages = new Unsigned32();
    private final size_t formatCount = new size_t();
    private final Pointer formats = new Pointer();
    private final size_t presentModeCount = new size_t();
    private final Pointer presentModes = new Pointer();
    private final size_t alphaModeCount = new size_t();
    private final Pointer alphaModes = new Pointer();

    private WGPUSurfaceCapabilities(){}

    @Deprecated
    public WGPUSurfaceCapabilities(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSurfaceCapabilities createHeap(){
        return new WGPUSurfaceCapabilities();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSurfaceCapabilities createDirect(){
        var struct = new WGPUSurfaceCapabilities();
        struct.useDirectMemory();
        return struct;
    }


    public DynamicStructRef<WGPUChainedStructOut> getNextInChain(){
        return nextInChain;
    }

    public void setNextInChain(WGPUChainedStructOut... x){
        if(x.length == 0 || x[0] == null){
            this.nextInChain.set(JavaWebGPU.createNullPointer());
        } else {
            this.nextInChain.set(x);
        }
    }

    public long getUsages(){
        return usages.get();
    }

    public void setUsages(long x){
        this.usages.set(x);
    }

    public long getFormatCount(){
        return formatCount.get();
    }

    public void setFormatCount(long x){
        this.formatCount.set(x);
    }

    public jnr.ffi.Pointer getFormats(){
        return formats.get();
    }

    public void setFormats(jnr.ffi.Pointer x){
        this.formats.set(x);
    }

    public long getPresentModeCount(){
        return presentModeCount.get();
    }

    public void setPresentModeCount(long x){
        this.presentModeCount.set(x);
    }

    public jnr.ffi.Pointer getPresentModes(){
        return presentModes.get();
    }

    public void setPresentModes(jnr.ffi.Pointer x){
        this.presentModes.set(x);
    }

    public long getAlphaModeCount(){
        return alphaModeCount.get();
    }

    public void setAlphaModeCount(long x){
        this.alphaModeCount.set(x);
    }

    public jnr.ffi.Pointer getAlphaModes(){
        return alphaModes.get();
    }

    public void setAlphaModes(jnr.ffi.Pointer x){
        this.alphaModes.set(x);
    }

}