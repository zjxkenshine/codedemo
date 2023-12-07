package com.kenshine.vecmath;

import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.vecmath.*;
import java.awt.*;

/**
 * @author by kenshine
 * @Classname VecmathTest
 * @Description vecmath使用测试
 * @Date 2023-12-07 16:29
 * @modified By：
 * @version: 1.0$
 */
public class VecmathTest {

    /**
     * AxisAngle4d 四个参数 x,y,z,angle
     * 轴角四元数，以0-xyz为轴及angle为旋转角度构建旋转对象
     * AxisAngle4f float
     */
    @Test
    public void test01(){
        AxisAngle4d axisAngle4d = new AxisAngle4d(1,1,1,30.00);
        System.out.println(axisAngle4d);
    }

    /**
     * Color3b: rgb颜色表示 b为byte
     * Color3f：参数为float
     */
    @Test
    public void test02(){
        Color3b color3b = new Color3b();
        // 白色
        color3b.set(new Color(255, 255, 255));
        System.out.println(color3b);
    }

    /**
     * Color4b 四元颜色表示 红绿蓝和alpha值
     * alpha值：透明度，介于0和1之间的浮点数
     */
    @Test
    public void test03(){
        Color4f color4f = new Color4f();
        // 白色
        color4f.set(new Color(255, 255, 255));
        color4f.setW(0.5f);
        System.out.println(color4f);
    }

    /**
     * GMatrix：二维矩阵类
     * GVector：一维向量类
     */
    @Test
    public void test04(){
        // 2*2的矩阵
        GMatrix gMatrix=new GMatrix(2,2);
        // 所有元素初始化为0,长度为2
        GVector gVector = new GVector(2);
        gVector.setElement(0,20);
        gVector.setElement(1,10);
        gMatrix.setRow(0,gVector);

        System.out.println(gMatrix);
    }

    /**
     * Matrix3d一个双精度浮点3 × 3矩阵。主要是为了支持3D旋转
     */
    @Test
    public void test05(){
        Matrix3d m = new Matrix3d();
        // 设置为identity
        m.setIdentity();
        System.out.println(m);
    }

    /**
     * Matrix4d：4*4矩阵，前三列表示物体在三维空间中的方向，第四列表示物体在三维空间中的位置。
     */
    @Test
    public void test06(){
        Matrix4d m = new Matrix4d();
        // 设置为identity
        m.setIdentity();
        System.out.println(m);
    }

    /**
     * Point2d 表示有两个元素的点
     */
    @Test
    public void test07(){
        Point2d a = new Point2d();
        a.set(1,2);
        Point2d b = new Point2d();
        a.set(2,1);
        System.out.println(a.distance(b));
    }

    /**
     * Point3d 三维空间中的点
     */
    @Test
    public void test08(){
        Point3d a = new Point3d();
        a.set(0,0,0);
        Point3d b = new Point3d();
        b.set(1,1,1);
        System.out.println(a.distance(b));
    }


    /**
     * Point4d 4D向量
     */
    @Test
    public void test09(){
        Point4d a = new Point4d();
        a.set(0,0,0,1);
        Point4d b = new Point4d();
        b.set(1,1,1,0);
        System.out.println(a.distance(b));
    }

    /**
     * Vector2d 2d向量
     * Vector3d
     * Vector4d
     */
    @Test
    public void test10(){
        Vector2d v = new Vector2d();
        v.set(1,3);
        // 标准化
        v.normalize();
        System.out.println(v);
    }

}
