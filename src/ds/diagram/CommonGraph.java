package ds.diagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 通用图结构
 *
 * @author Wen
 * @date 2022/9/8 22:41
 */
public class CommonGraph<V> {
    //所有的点
    HashMap<V, Node<V>> nodes;
    //所有的边
    HashSet<Edge<V>> edges;

    public CommonGraph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    class Node<T> {
        //图中的点的值
        T t;
        //出度
        int in;
        //入度
        int out;
        //直接领居
        List<Node<T>> nextNodes;
        //从该点出去的边
        List<Edge<T>> toEdges;

        public Node(T t) {
            this.t = t;
            this.in = 0;
            this.out = 0;
            this.nextNodes = new ArrayList<>();
            this.toEdges = new ArrayList<>();
        }
    }

    class Edge<T> {
        //权重
        int weight;
        Node<T> from;
        Node<T> to;

        public Edge(int weight, Node<T> from, Node<T> to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
}
