package TreeAndMap;

/**
 * @program: Exercises
 * @description: 拥有next属性的结点
 * @author: 宋丽
 * @create: 2020-10-08 20:30
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
