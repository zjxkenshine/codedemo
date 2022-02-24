package chapter1.Test05_TrieAndGreedy;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/24 9:14
 * @description：前缀树02
 * @modified By：
 * @version: $
 */
public class Test02_TireTree02 {
    public static class TrieNode {
        private int end;//有多少东西以他结尾
        private int path;//有多少东西达到过它
        private TrieNode[] nexts;//我们用检查某条路上的结点是不是空，来标记这条路存在不存在。

        //也可以做成这种map形式的，字符和结点对应的形式。
        private HashMap<Character, TrieNode> map;

        public TrieNode() {
            end = 0;
            path = 0;
            nexts = new TrieNode[26];//路每一个结点都有26条路，我们强行规定这里只存26个小写英文字母。
        }

        public static class Trie {
            //头结点
            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            // 加入一个字符串
            public void insert(String word) {
                int index = 0;
                TrieNode node = root;
                // 转换成字符数组
                char[] charArray = word.toCharArray();
                // 从左往右遍历字符串
                for(int i = 0; i < charArray.length; i++){
                    //用于计算char数组里面的元素是什么
                    index = charArray[i] - 'a';
                    //当前node有没有走向当前字母的路，
                    if (node.nexts[index] == null) {
                        //如果没有建出来
                        node.nexts[index] = new TrieNode();
                    }
                    // 移动到下级节点
                    node = node.nexts[index];
                    node.path++;
                }
                node.end++;
            }

            public void delete(String word) {
                if (search(word) == 0) {
                    return;
                }
                char[] charArray = word.toCharArray();
                int index = 0;
                TrieNode node = root;
                for (int i = 0; i < charArray.length; i++) {
                    index = charArray[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }

            //插入字符串的次数
            public int search(String word) {
                if (word == null) {
                    return 0;
                }
                TrieNode node = root;
                char[] charArray = word.toCharArray();
                int index = 0;
                for (int i = 0; i < charArray.length; i++) {
                    index = charArray[i] - 'a';
                    if (node.nexts[index] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                }
                return node.end;
            }
        }
    }
}
