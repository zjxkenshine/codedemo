package com.kenshine.webgraph;

import it.unimi.dsi.webgraph.*;
import it.unimi.dsi.webgraph.examples.ErdosRenyiGraph;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.NoSuchElementException;
import java.util.zip.GZIPInputStream;

import static org.junit.Assert.assertTrue;

/**
 * @Classname WebGraphTest
 * @Description WebGraph 使用示例
 * @Date 2024-03-06 11:25
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */
public class WebGraphTest {

    /**
     * ErdosRenyiGraph
     */
    @Test
    public void test01(){
        // 节点数量，弧度生成概率，随机种子，是否循环
        final ImmutableGraph graph = new ErdosRenyiGraph(10000, 1000000, 0, false);
        long arcs = 0;
        for(final NodeIterator nodeIterator = graph.nodeIterator(); nodeIterator.hasNext();) {
            final int curr = nodeIterator.nextInt();
            final int outdegree = nodeIterator.outdegree();
            arcs += outdegree;
            final int[] s = nodeIterator.successorArray();
            if (outdegree != 0) {
                assertTrue("Node " + curr, s[0] != curr);
            }
            for(int i = 1; i < outdegree; i++) {
                assertTrue(s[i] > s[i - 1]);
                assertTrue(s[i] !=  curr);
            }
        }
    }

    /**
     * BVGraph压缩存储
     */
    @Test
    public void test02() throws IOException {
        // 大图
        final ImmutableGraph graph = new BigGraph(100, 1, 4);
        final File basename = File.createTempFile(WebGraphTest.class.getSimpleName(), "test");
        // 压缩存储
        BVGraph.store(graph, basename.toString());
    }


    /**
     * EFGraph 压缩
     */
    @Test
    public void test03() throws IOException {
        final String basename = File.createTempFile(getClass().getSimpleName(), "test").toString();
        final ImmutableGraph g = new ArrayListMutableGraph(new ErdosRenyiGraph(1000, .01, 0, false)).immutableView();
        EFGraph.store(g, 1000, basename, 3, 1024, ByteOrder.nativeOrder(), null);
        // 加载图
        // final EFGraph efGraph = (EFGraph)ImmutableGraph.load(basename);
    }


    protected final static class BigGraph extends ImmutableSequentialGraph {
        private final int numNodes;
        private final int outdegree;
        private final int step;

        public BigGraph(final int numNodes, final int outdegree, final int step) {
            if (outdegree * step > numNodes) throw new IllegalArgumentException();
            this.numNodes = numNodes;
            this.outdegree = outdegree;
            this.step = step;
        }

        public BigGraph(final int outdegree, final int step) {
            this(outdegree * step, outdegree, step);
        }

        @Override
        public int numNodes() {
            return numNodes;
        }

        @Override
        public NodeIterator nodeIterator(final int from) {
            return new NodeIterator() {
                int next = 0;
                @Override
                public boolean hasNext() {
                    return next < numNodes();
                }

                @Override
                public int nextInt() {
                    if (! hasNext()) throw new NoSuchElementException();
                    return next++;
                }

                @Override
                public int outdegree() {
                    return next < 2 ? outdegree : 2;
                }

                @Override
                public LazyIntIterator successors() {
                    if (next >= 2) {
                        return LazyIntIterators.wrap(new int[] { next - 2, next - 1 });
                    } else {
                        return new AbstractLazyIntIterator() {
                            public int i = 0;
                            @Override
                            public int nextInt() {
                                if (i == outdegree) {
                                    return -1;
                                } else {
                                    return i++ * step;
                                }
                            }
                        };
                    }
                }
            };
        }
    }
}
