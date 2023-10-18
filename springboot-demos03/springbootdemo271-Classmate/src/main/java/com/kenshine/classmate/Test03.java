package com.kenshine.classmate;

import com.fasterxml.classmate.*;
import com.fasterxml.classmate.members.RawMethod;
import com.fasterxml.classmate.members.ResolvedMethod;
import org.junit.Test;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 注解解析
 * @Date 2023-10-18 10:50
 * @modified By：
 * @version: 1.0$
 */
public class Test03 {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Marker { }

    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface MarkerA { }

    public class SomeClass {
        @Marker @MarkerA
        public void someMethod() { }
    }
    public class SomeSubclass extends SomeClass {
        @Override
        public void someMethod() { }
    }

    /**
     * 解析父类方法注解
     */
    @Test
    public void test01(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType someType = typeResolver.resolve(SomeClass.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        memberResolver.setMethodFilter(new Filter<RawMethod>() {
            @Override public boolean include(RawMethod element) {
                return "someMethod".equals(element.getName());
            }
        });
        AnnotationConfiguration annConfig = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.INCLUDE_BUT_DONT_INHERIT);
        ResolvedTypeWithMembers someTypeWithMembers = memberResolver.resolve(someType, annConfig, null);
        ResolvedMethod someMethod = someTypeWithMembers.getMemberMethods()[0];
        // 解析方法上的注解 marker markerA
        Marker marker = someMethod.get(Marker.class);  // marker != null
        MarkerA markerA = someMethod.get(MarkerA.class); // markerA != null

        System.out.println(marker);
        System.out.println(markerA);
    }

    /**
     * 解析SomeSubclass注释类型
     */
    @Test
    public void test02(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType someSubclassType = typeResolver.resolve(SomeSubclass.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        AnnotationConfiguration annConfig = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.INCLUDE_BUT_DONT_INHERIT);
        ResolvedTypeWithMembers someSubclassTypeWithMembers = memberResolver.resolve(someSubclassType, annConfig, null);
        ResolvedMethod someMethod = someSubclassTypeWithMembers.getMemberMethods()[0];
        Marker marker = someMethod.get(Marker.class);  // marker == null
        MarkerA markerA = someMethod.get(MarkerA.class); // markerA == null
        Override override = someMethod.get(Override.class); // override == null (RetentionPolicy = SOURCE)
        System.out.println(marker);
        System.out.println(markerA);
        System.out.println(override);
    }

    /**
     * 解析SomeSubclass 方法注释类型,包含@Inherited注解
     */
    @Test
    public void test03(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType someSubclassType = typeResolver.resolve(SomeSubclass.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        AnnotationConfiguration annConfig = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.INCLUDE_AND_INHERIT_IF_INHERITED);
        ResolvedTypeWithMembers someSubclassTypeWithMembers = memberResolver.resolve(someSubclassType, annConfig, null);
        ResolvedMethod someMethod = someSubclassTypeWithMembers.getMemberMethods()[0];
        Marker marker = someMethod.get(Marker.class);  // marker == null
        MarkerA markerA = someMethod.get(MarkerA.class); // markerA != null
        Override override = someMethod.get(Override.class); // override == null (RetentionPolicy = SOURCE)
        System.out.println(marker);
        System.out.println(markerA);
        System.out.println(override);
    }

    /**
     * 解析SomeSubclass 方法注释类型,包括父类注解
     */
    @Test
    public void test04(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType someSubclassType = typeResolver.resolve(SomeSubclass.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        AnnotationConfiguration annConfig = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.INCLUDE_AND_INHERIT);
        ResolvedTypeWithMembers someSubclassTypeWithMembers = memberResolver.resolve(someSubclassType, annConfig, null);
        ResolvedMethod someMethod = someSubclassTypeWithMembers.getMemberMethods()[0];
        Marker marker = someMethod.get(Marker.class);  // marker != null
        MarkerA markerA = someMethod.get(MarkerA.class); // markerA != null
        Override override = someMethod.get(Override.class); // override == null (RetentionPolicy = SOURCE)
        System.out.println(marker);
        System.out.println(markerA);
        System.out.println(override);
    }

    public class SomeOtherClass {
        public void someMethod() { }
    }

    /**
     * 解析不到属性、方法与注解
     *
     */
    @Test
    public void test05(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType someOtherClassType = typeResolver.resolve(SomeOtherClass.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        AnnotationConfiguration annConfig = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.INCLUDE_AND_INHERIT);
        ResolvedTypeWithMembers someOtherClassTypeWithMembers = memberResolver.resolve(someOtherClassType, annConfig, null);
        ResolvedMethod someMethod = someOtherClassTypeWithMembers.getMemberMethods()[0];
        Marker marker = someMethod.get(Marker.class);  // marker == null, of course
        MarkerA markerA = someMethod.get(MarkerA.class); // markerA == null, of course
        System.out.println(marker);
        System.out.println(markerA);
    }


    /**
     * 方法签名相同汇总
     */
    @Test
    public void test06(){
        TypeResolver typeResolver = new TypeResolver();
        ResolvedType someOtherClassType = typeResolver.resolve(SomeOtherClass.class);
        MemberResolver memberResolver = new MemberResolver(typeResolver);
        AnnotationConfiguration annConfig = new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.INCLUDE_AND_INHERIT);
        // mix-in 汇总
        AnnotationOverrides annOverrides = AnnotationOverrides.builder().add(SomeOtherClass.class, SomeClass.class).build();
        ResolvedTypeWithMembers someOtherTypeWithMembers = memberResolver.resolve(someOtherClassType, annConfig, annOverrides);
        ResolvedMethod someMethod = someOtherTypeWithMembers.getMemberMethods()[0];
        Marker marker = someMethod.get(Marker.class);  // marker != null
        MarkerA markerA = someMethod.get(MarkerA.class); // markerA != null

        System.out.println(marker);
        System.out.println(markerA);
    }







}
