package com.kenshine.javolution.struct;

import javolution.io.Struct;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 17:35
 * @description：
 * @modified By：
 * @version: $
 *  Struct 相当于C/C++ struct ； 此类赋予 Java 类和 C/C++ 结构之间的互操作性
 *
 * 使用该类可以帮助：
 * Java 应用程序和本机库之间的内存共享。
 * 直接编码/解码流的结构由遗留 C/C++ 代码定义。
 * Java 对象的序列化/反序列化（完全控制，例如没有类头）
 * Java 对象到物理地址的映射（使用 JNI）。
 *
 * Struct直接使用了NIO, 使用方式类似
 */
public class Student extends Struct {
    public final UTF8String           name   = new UTF8String(64);
    public final Date                 birth  = inner(new Date());
    public final Float32[]            grades = array(new Float32[10]);
    public final Reference32<Student> next   =  new Reference32<Student>();

}
