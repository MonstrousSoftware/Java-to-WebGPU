package com.monstrous.webgpu;

import com.monstrous.utils.JavaWebGPU;
import com.monstrous.utils.CStrPointer;
import com.monstrous.utils.WgpuJavaStruct;
import com.monstrous.utils.RustCString;
import jnr.ffi.Runtime;

/** NOTE: THIS FILE WAS PRE-GENERATED BY JNR_GEN! */
public class WGPUSamplerDescriptor extends WgpuJavaStruct {

    private final DynamicStructRef<WGPUChainedStruct> nextInChain = new DynamicStructRef<>(WGPUChainedStruct.class);
    private final @CStrPointer Pointer label = new Pointer();
    private final Enum<WGPUAddressMode> addressModeU = new Enum<>(WGPUAddressMode.class);
    private final Enum<WGPUAddressMode> addressModeV = new Enum<>(WGPUAddressMode.class);
    private final Enum<WGPUAddressMode> addressModeW = new Enum<>(WGPUAddressMode.class);
    private final Enum<WGPUFilterMode> magFilter = new Enum<>(WGPUFilterMode.class);
    private final Enum<WGPUFilterMode> minFilter = new Enum<>(WGPUFilterMode.class);
    private final Enum<WGPUMipmapFilterMode> mipmapFilter = new Enum<>(WGPUMipmapFilterMode.class);
    private final Float lodMinClamp = new Float();
    private final Float lodMaxClamp = new Float();
    private final Enum<WGPUCompareFunction> compare = new Enum<>(WGPUCompareFunction.class);
    private final Unsigned16 maxAnisotropy = new Unsigned16();

    private WGPUSamplerDescriptor(){}

    @Deprecated
    public WGPUSamplerDescriptor(Runtime runtime){
        super(runtime);
    }

	/**
	* Creates this struct on the java heap.
	* In general, this should <b>not</b> be used because these structs
	* cannot be directly passed into native code. 
	*/
    public static WGPUSamplerDescriptor createHeap(){
        return new WGPUSamplerDescriptor();
    }

	/**
	* Creates this struct in direct memory.
	* This is how most structs should be created (unless, they
	* are members of a nothing struct)
	* 
	* @see WgpuJavaStruct#useDirectMemory
	*/
    public static WGPUSamplerDescriptor createDirect(){
        var struct = new WGPUSamplerDescriptor();
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

    public WGPUAddressMode getAddressModeU(){
        return addressModeU.get();
    }

    public void setAddressModeU(WGPUAddressMode x){
        this.addressModeU.set(x);
    }

    public WGPUAddressMode getAddressModeV(){
        return addressModeV.get();
    }

    public void setAddressModeV(WGPUAddressMode x){
        this.addressModeV.set(x);
    }

    public WGPUAddressMode getAddressModeW(){
        return addressModeW.get();
    }

    public void setAddressModeW(WGPUAddressMode x){
        this.addressModeW.set(x);
    }

    public WGPUFilterMode getMagFilter(){
        return magFilter.get();
    }

    public void setMagFilter(WGPUFilterMode x){
        this.magFilter.set(x);
    }

    public WGPUFilterMode getMinFilter(){
        return minFilter.get();
    }

    public void setMinFilter(WGPUFilterMode x){
        this.minFilter.set(x);
    }

    public WGPUMipmapFilterMode getMipmapFilter(){
        return mipmapFilter.get();
    }

    public void setMipmapFilter(WGPUMipmapFilterMode x){
        this.mipmapFilter.set(x);
    }

    public float getLodMinClamp(){
        return lodMinClamp.get();
    }

    public void setLodMinClamp(float x){
        this.lodMinClamp.set(x);
    }

    public float getLodMaxClamp(){
        return lodMaxClamp.get();
    }

    public void setLodMaxClamp(float x){
        this.lodMaxClamp.set(x);
    }

    public WGPUCompareFunction getCompare(){
        return compare.get();
    }

    public void setCompare(WGPUCompareFunction x){
        this.compare.set(x);
    }

    public int getMaxAnisotropy(){
        return maxAnisotropy.get();
    }

    public void setMaxAnisotropy(int x){
        this.maxAnisotropy.set(x);
    }

}