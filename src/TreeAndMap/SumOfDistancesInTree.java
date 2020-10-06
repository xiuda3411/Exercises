package TreeAndMap;

import java.util.*;

/**
 * @program: Exercises
 * @description: 树中距离之和
 * @author: 宋丽
 * @create: 2020-10-06 14:38
 **/
public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] result = new int[N];//最终结果存放处
        ArrayList<Node> nodeList = new ArrayList<Node>(N);
        for (int i = 0; i < N; i++) {
            nodeList.add(new Node(i));
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            Node nodeA = nodeList.get(a);
            Node nodeB = nodeList.get(b);
            nodeA.link(nodeB);
        }
        Node root = nodeList.get(0);
        root.traverse();//建立以0节点为根节点的一棵树
        root.initiate();//计算0节点的各种距离 递归先算子树距离
        root.totalDistance = root.subDistance;
        root.calculateDistance(N);//换根 用状态转移公式 dfs遍历
        //存储结果：
        for (int i = 0; i < N; i++) {
            result[i] = nodeList.get(i).totalDistance;
        }
        return result;
    }

    class Node {
        int val;
        Node parent;//父节点
        List<Node> nodes;//邻接节点
        int size;//以nodes为根的树有多少节点（包括本身）
        boolean visited;
        int subDistance;
        int totalDistance;
        public Node(int val) {
            this.val = val;
            this.parent = null;
            this.nodes = new ArrayList<Node>();
            this.size = 1;
            this.visited = false;
            this.subDistance = 0; //以该节点为子树包含的距离
            this.totalDistance = 0; //该节点的最终结果
            // 对于0节点 两个距离最后计算完了会相等
            // 对于0以外的节点 totalDistance都是通过其他节点的totalDistance进行状态转换得来的
            // 0以外的节点，totalDistance和subDistance不同
        }

        // 将本节点与anotherNode节点连接起来
        // 连接是双向的 即同时建立两条无向边
        public void link(Node anotherNode) {
            this.nodes.add(anotherNode);
            anotherNode.nodes.add(this);
        }

        // 从node开始 dfs遍历
        // 一边遍历一边移除根节点 防止遍历的时候返回去
        public void traverse() {
            for (Node node: nodes) {
                node.parent = this; //邻接节点的父节点指向当前节点 表示是从当前节点来的
                node.nodes.remove(this);// 一边遍历一边移除根节点 防止遍历的时候返回去
                node.traverse(); //dfs递归
            }
        }

        // 遍历统计子树的信息
        public void initiate() {
            for (Node node: nodes) {
                node.initiate();
                this.size += node.size; //更新节点数=已有节点数+子树节点数
                this.subDistance += node.subDistance;//更新距离=已有距离+子树距离
                this.subDistance += node.size;//更新距离=已有距离+子树节点数
                // 因为每一个子树节点连接到当前节点还要再多一条线
            }
        }

        // 状态转移 对邻接节点换根 dfs遍历
        public void calculateDistance(int N) {
            // 遍历时并不会遍历到本节点的根节点 这个问题已经在traverse()里面解决了
            for (Node node: nodes) {
                // 状态转移方程 计算node节点的最终结果
                node.totalDistance = this.totalDistance + N - node.size * 2;
                // dfs遍历node的邻接节点
                node.calculateDistance(N);
            }
        }
    }
}
