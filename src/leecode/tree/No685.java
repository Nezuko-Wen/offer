package leecode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 冗余连接，并查集
 */
public class No685 {
    public static void main(String[] args) {

    }

    //压缩列表
    public static int find(int root, int[] parent){
        return parent[root] == root ? root : (parent[root] = find(parent[root], parent));
    }
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        /**
         * 当非环时，入度为2的节点会有多余边，找出这个入度为2的节点
         * 有2个父节点，需要进行判断，哪个是多余边
         * 如果这2个父节点的父节点能和该节点与root节点组成三角形，则是多余边
         * 环的情况单独考虑，此时入度都为1，删除最有一条边
         */
        List<Integer> pointRootNode = new ArrayList<>(2);
        //节点入度计数
        int[] numInt = new int[edges.length + 1];
        //并查集
        int[] parent = new int[edges.length + 1];
        //并查集初始化
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        //入度为2的节点
        int root = -1;
        for (int[] point:edges){
            numInt[point[1]] ++;
            if (numInt[point[1]] == 2){
                root = point[1];
                break;
            }
        }
        //环的情况
        if (root == -1){
            for (int[] point:edges){
                int a = find(point[0], parent);
                int b = find(point[1], parent);
                if (a != b){
                    //并查集压缩
                    parent[b] = a;
                }else {
                    //找到构成环的最后一边
                    return point;
                }
            }
        }
        //非环
        for (int[] point:edges){
            if (point[1] != root){
                //并查集的压缩合并
                parent[point[1]] = find(point[0], parent);
            }
            else {
                pointRootNode.add(point[0]);
            }
        }
        //对2个父节点进行判断
        if (find(pointRootNode.get(0), parent) == find(root, parent)) {
            return new int[]{pointRootNode.get(0), root};
        }
        return new int[]{pointRootNode.get(1), root};
    }
}
