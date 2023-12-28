package com.kenshine.jmockit.mock;

/**
 * 原始方法
 * @author kenshine
 */
public class Fun {
	// 静态方法
    public static String staticFun(int x) {
        return "this is a static function " + x;
    }
	// 公有方法
    public String publicFun(int x) {
        return "this is a public function " + x;
    }
	// final方法
    public final String finalFun(int x) {
        return "this is a final function " + x;
    }
	// 私有方法
    private String privateFun(int x) {
        return "this is a private function " + x;
    }
	// 为了方便测试私有方法是否被Mock
    public String callPrivateFun(int x){
        return privateFun(x)+" is called";
    }
}