package com.kenshine.symbolsolver.learn.observer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.observer.AstObserver;
import com.github.javaparser.ast.observer.AstObserverAdapter;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.PrimitiveType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname Observer使用测试 AST变动监控
 * @Description AST
 * @Date 2024-01-13 12:24
 * @modified By：
 * @version: 1.0$
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 解析代码
        String code = "class A { int f; void foo(int p) { return 'z'; }}";
        CompilationUnit cu = StaticJavaParser.parse(code);
        // 设置自定义AstObserver
        List<String> changes = new ArrayList<>();
        AstObserver observer = new AstObserverAdapter() {
            @Override
            public void propertyChange(Node observedNode, ObservableProperty property, Object oldValue, Object newValue) {
                changes.add(String.format("%s.%s changed from %s to %s", observedNode.getClass().getSimpleName(), property.name().toLowerCase(), oldValue, newValue));
            }
        };
        /**
         * 可以使用不同模式
         * JUST_THIS_NODE 仅此节点上发生的更改进行通知
         * THIS_NODE_AND_EXISTING_DESCENDANTS 通知此节点及其在注册观察者时存在的所有子节点上发生的更改 之后添加的节点不会通知
         * SELF_PROPAGATING 通知此节点及其所有子节点上发生的更改，之后添加的会自动注册观察
         *
         */
        cu.getClassByName("A").get().register(observer, Node.ObserverRegistrationMode.JUST_THIS_NODE);
        // 执行改变
        // 类名
        cu.getClassByName("A").get().setName("MyCoolClass");
        // 变量名
        cu.getClassByName("MyCoolClass").get().getFieldByName("f").get().setAllTypes(new PrimitiveType(PrimitiveType.Primitive.BOOLEAN));
        cu.getClassByName("MyCoolClass").get().getMethodsByName("foo").get(0).getParameterByName("p").get().setName("myParam");
        // 添加一个新字段并立即进行更改
        cu.getClassByName("MyCoolClass").get().addField("int", "bar").getVariables().get(0).setInitializer("0");
        // JUST_THIS_NODE 模式注册观测者
        assertEquals(Arrays.asList("ClassOrInterfaceDeclaration.name changed from A to MyCoolClass"), changes);
        // THIS_NODE_AND_EXISTING_DESCENDANTS 模式注册策观察者
        assertEquals(Arrays.asList("ClassOrInterfaceDeclaration.name changed from A to MyCoolClass",
                "FieldDeclaration.element_type changed from int to boolean",
                "VariableDeclaratorId.name changed from p to myParam"), changes);
        // SELF_PROPAGATING模式注册观察者
        assertEquals(Arrays.asList("ClassOrInterfaceDeclaration.name changed from A to MyCoolClass",
                "FieldDeclaration.element_type changed from int to boolean",
                "VariableDeclaratorId.name changed from p to myParam",
                "FieldDeclaration.modifiers changed from [] to []",
                "FieldDeclaration.element_type changed from empty to int",
                "VariableDeclaratorId.array_bracket_pairs_after_id changed from com.github.javaparser.ast.NodeList@1 to com.github.javaparser.ast.NodeList@1",
                "VariableDeclarator.init changed from null to 0"), changes);
    }
}
