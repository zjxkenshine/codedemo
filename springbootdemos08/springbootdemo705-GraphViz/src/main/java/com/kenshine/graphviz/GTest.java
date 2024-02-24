package com.kenshine.graphviz;

import java.io.File;

/**
 * 使用测试
 * @author kenshine
 */
public class GTest {
    public static void main(String[] args){
        GTest gtest = new GTest();
        String[] nodes = {"A","B","C","D","E","F","G"};
        String[] preline = {"B -> A","D -> B","E -> D","C -> E","G -> C","F -> G"};
        gtest.start(nodes, preline);
    }
    private void start(String[] nodes,String[] preline){
       Graphviz gv = new Graphviz();
       //定义每个节点的style
       String nodesty = "[shape = polygon, sides = 6, peripheries = 2, color = lightblue, style = filled]";
       //String linesty = "[dir=\"none\"]";
       // 开始
       gv.addln(gv.start_graph());
       gv.addln("edge[fontname=\"DFKai-SB\" fontsize=15 fontcolor=\"black\" color=\"brown\" style=\"filled\"]");
       gv.addln("size =\"8,8\";");
       //设置节点的style
       for(int i=0;i<nodes.length;i++){
           gv.addln(nodes[i]+" "+nodesty);
       }
       for(int i=0;i<preline.length;i++){
           gv.addln(preline[i]+" "+" [dir=\"none\"]");
       }
       // 结束
       gv.addln(gv.end_graph());
       //节点之间的连接关系输出到控制台
       System.out.println(gv.getDotSource());
       //输出什么格式的图片(gif,dot,fig,pdf,ps,svg,png,plain)
       String type = "png";
       //输出到文件夹以及命名
       File out = new File("springbootdemo705-GraphViz\\test." + type);
       gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), out );
   }
}