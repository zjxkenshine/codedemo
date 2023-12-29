package com.kenshine.libphonenumber.util;

public class PhoneModel {
   
    /** 省份名称 */  
    private String provinceName;  
   
    /** 城市名称 */  
    private String cityName;  
   
    /** 运营商：移动/电信/联通 */  
    private String carrier;  
   
    /** 
     * 省份名称 
     *  
     * @return 获取provinceName属性值 
     */  
    public String getProvinceName() {  
        return provinceName;  
    }  
   
    /** 
     * 省份名称 
     *  
     * @param provinceName 
     *            设置 provinceName 属性值为参数值 provinceName 
     */  
    public void setProvinceName(String provinceName) {  
        this.provinceName = provinceName;  
    }  
   
    /** 
     * 城市名称 
     *  
     * @return 获取cityName属性值 
     */  
    public String getCityName() {  
        return cityName;  
    }  
   
    /** 
     * 城市名称 
     *  
     * @param cityName 
     *            设置 cityName 属性值为参数值 cityName 
     */  
    public void setCityName(String cityName) {  
        this.cityName = cityName;  
    }  
   
    /** 
     * 运营商：移动/电信/联通 
     *  
     * @return 获取carrier属性值 
     */  
    public String getCarrier() {  
        return carrier;  
    }  
   
    /** 
     * 运营商：移动/电信/联通 
     *  
     * @param carrier 
     *            设置 carrier 属性值为参数值 carrier 
     */  
    public void setCarrier(String carrier) {  
        this.carrier = carrier;  
    }  
   
}