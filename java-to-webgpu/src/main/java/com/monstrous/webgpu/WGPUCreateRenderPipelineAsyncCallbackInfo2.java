package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.WgpuJavaStruct;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUCreateRenderPipelineAsyncCallbackInfo2 extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final Enum<WGPUCallbackMode> mode = new Enum<>(WGPUCallbackMode.class);
    private final Pointer callback = new Pointer();
    private final Pointer userdata1 = new Pointer();
    private final Pointer userdata2 = new Pointer();

    private WGPUCreateRenderPipelineAsyncCallbackInfo2(){}

    @Deprecated
    public WGPUCreateRenderPipelineAsyncCallbackInfo2(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUCreateRenderPipelineAsyncCallbackInfo2 createHeap(){
        return new WGPUCreateRenderPipelineAsyncCallbackInfo2();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUCreateRenderPipelineAsyncCallbackInfo2 createDirect(){
        var struct = new WGPUCreateRenderPipelineAsyncCallbackInfo2();
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

    public WGPUCallbackMode getMode(){
        return mode.get();
    }

    public void setMode(WGPUCallbackMode x){
        this.mode.set(x);
    }

    public jnr.ffi.Pointer getCallback(){
        return callback.get();
    }

    public void setCallback(jnr.ffi.Pointer x){
        this.callback.set(x);
    }

    public jnr.ffi.Pointer getUserdata1(){
        return userdata1.get();
    }

    public void setUserdata1(jnr.ffi.Pointer x){
        this.userdata1.set(x);
    }

    public jnr.ffi.Pointer getUserdata2(){
        return userdata2.get();
    }

    public void setUserdata2(jnr.ffi.Pointer x){
        this.userdata2.set(x);
    }

}