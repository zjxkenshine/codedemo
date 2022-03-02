package chapter2.Test01_Hash;

import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2022/3/2 10:34
 * @description： 随机pool
 * @modified By：
 * @version: $
 */
public class Test02_RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        // 将某个key加入到该结构，做到不重复加入
        public void insert(K key) {
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

        // 删除 用最后一个值填补移除的元素
        public void delete(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = this.keyIndexMap.get(key);
                // 最后一个元素
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        // 随机获取一个元素
        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * this.size); // 0 ~ size -1
            return this.indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }
}
