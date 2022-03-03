package chapter2.Test02_Set;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/2 19:57
 * @description：并查集结构
 * @modified By：
 * @version: $
 */
public class Test02_UnionFind {
    // 元素集合
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        // V-Element<V>结构map
        public HashMap<V, Element<V>> elementMap;
        // Key代表当前元素的父节点
        public HashMap<Element<V>, Element<V>> fatherMap;
        // Key：某个集合代表元素(顶部元素)
        // Value：该集合的大小
        // 非代表元素不做记录
        public HashMap<Element<V>, Integer> rankMap;

        // 初始化并查集
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                // 包装样本
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        // 找到头(代表节点)
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            // 将链变为扁平的
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        // 查找a和b是否在同一个集合
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        // 合并a和b所在的集合
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    rankMap.remove(small);
                }
            }
        }

    }
}
