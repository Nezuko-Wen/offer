package ds.picture;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 * @author Wen
 * @date 2022/9/7 23:27
 */
public class UnionFind {
    //集合结构体
    static class Node<T> {
        T t;

        public Node(T t) {
            this.t = t;
        }
    }

    static class UnionFindSet<V> {

        //自身代表点指向集合
        private HashMap<V, Node<V>> nodeHashMap;
        //每个结构体上层指向存储
        private HashMap<Node<V>, Node<V>> parentMap;
        //代表结构体的总节点数
        private HashMap<Node<V>, Integer> sizeMap;


        public UnionFindSet(List<V> iterator) {
            int size = iterator.size();
            nodeHashMap = new HashMap<>(size);
            parentMap = new HashMap<>(size);
            sizeMap = new HashMap<>(size);
            for (V v : iterator) {
                Node<V> node = new Node<>(v);
                nodeHashMap.put(v, node);
                parentMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        //找代表节点
        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> stack = new Stack<>();
            while (parentMap.get(cur) != cur) {
                stack.push(cur);
                cur = parentMap.get(cur);
            }
            //将从cur出发的链压平，所经过的节点的代表节点都是cur的代表节点
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), cur);
            }
            return cur;
        }

        //是否拥有同一个代表结点
        public boolean isSameSet(V a, V b) {
            if (nodeHashMap.get(a) == null || nodeHashMap.get(b) == null) {
                return false;
            }
            return findFather(nodeHashMap.get(a)) == findFather(nodeHashMap.get(b));
        }

        //将小集合合并到大集合
        public void union(V a, V b) {
            if (nodeHashMap.get(a) == null || nodeHashMap.get(b) == null) {
                return;
            }
            Node<V> aHead = findFather(nodeHashMap.get(a));
            Node<V> bHead = findFather(nodeHashMap.get(b));
            if (aHead != bHead) {
                Node<V> bigHead = sizeMap.get(aHead) > sizeMap.get(bHead) ? aHead : bHead;
                Node<V> smallHead = bigHead == aHead ? bHead : aHead;
                parentMap.put(smallHead, bigHead);
                sizeMap.put(bigHead, sizeMap.get(bigHead) + sizeMap.get(smallHead));
                sizeMap.remove(smallHead);
            }
        }
    }


}
