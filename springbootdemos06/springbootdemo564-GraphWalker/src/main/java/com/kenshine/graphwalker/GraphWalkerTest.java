package com.kenshine.graphwalker;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.VertexCoverage;
import org.graphwalker.core.generator.PathGenerator;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.machine.SimpleMachine;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Model;
import org.graphwalker.core.model.Vertex;
import org.graphwalker.io.factory.json.JsonContext;
import org.graphwalker.modelchecker.ContextChecker;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname GraphWalkerTest
 * @Description GraphWalker 使用测试
 * @Date 2023-12-09 14:47
 * @modified By：
 * @version: 1.0$
 */
public class GraphWalkerTest {

    /**
     * 仅用core运行测试
     */
    @Test
    public void test01(){
        // 创建一个顶点
        Vertex start = new Vertex();
        // 创建一个模型
        Model model = new Model().addEdge(new Edge()
                .setSourceVertex(start)
                .setTargetVertex(new Vertex().setName("myTestMethod")));
        // 基于模型和路径生成器创建上下文 随机遍历
        PathGenerator pathGenerator = new RandomPath(new VertexCoverage(100));
        Context context = new TestContext(model, pathGenerator);
        // 将起始顶点设置为起点
        context.setNextElement(start);
        // 创建machine并执行测试
        Machine machine = new SimpleMachine(context);
        while (machine.hasNextStep()) {
            machine.getNextStep();
        }
    }

    /**
     * 模型校验
     */
    @Test
    public void test02(){
        Vertex v1 = new Vertex().setName("v1").setId("v1");
        Vertex v2 = new Vertex().setName("v2").setId("v2");
        Vertex v3 = new Vertex().setName("v3").setId("v3");
        Vertex v4 = new Vertex().setName("v4").setId("v4");

        Model model = new Model();
        model.addEdge(new Edge().setSourceVertex(v1).setTargetVertex(v2).setName("e1").setId("e1"));
        model.addEdge(new Edge().setSourceVertex(v2).setTargetVertex(v3).setName("e2").setId("e2"));
        model.addEdge(new Edge().setSourceVertex(v2).setTargetVertex(v4).setName("e3").setId("e3"));
        model.addEdge(new Edge().setTargetVertex(v1).setName("e0").setId("e0"));

        Context context = new JsonContext();
        context.setModel(model.build()).setPathGenerator(new RandomPath(new EdgeCoverage(100)));
        context.setNextElement(context.getModel().findElements("e0").get(0));

        List<String> issues = ContextChecker.hasIssues(context);
        System.out.println(issues);
    }

    public class TestContext extends ExecutionContext {
        public TestContext(Model model, PathGenerator pathGenerator) {
            super(model, pathGenerator);
        }
        public void myTestMethod() {
            // 模型执行期间会执行
            System.out.println("执行了myTestMethod方法");
        }
    }
}
