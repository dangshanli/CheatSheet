package intro;

/**
 * @author luzj
 * @description:
 * @date 2019/3/28
 */
public class RBTree {

    private static final int RED = 0;
    private static final int BLACK = 1;

    /**
     * 树节点
     */
    class Node {
        int color;//0-red 1-black
        String key;//本应该使用泛型，为了简化写死String
        Node left;//左子树
        Node right;//右子树
        Node parent;//父节点

        public Node() {
        }

        public Node(int color, String key, Node left, Node right, Node parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    final Node NIL = new Node(BLACK, "NIL", null, null, null);
    Node root;

    public RBTree() {

    }

    public RBTree(Node root) {
        this.root = root;
    }

    /**
     * 左旋
     *
     * @param x
     */
    private void leftRotate(Node x) {
        Node y = x.right;

        //把y的左子树移到x的右子树
        x.right = y.left;
        if (y.left != this.NIL)
            y.left.parent = x;

        //y替代x的位置，成为当前子树的根节点
        y.parent = x.parent;
        if (x.parent == this.NIL)
            this.root = y;//如果x是根节点
        else if (x == x.parent.left)//x是左子树情况
            x.parent.left = y;
        else //x是右子树情况
            x.parent.right = y;

        //x作为y的左子树，左旋必然x是做了左子树
        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋
     *
     * @param y
     */
    private void rightRotate(Node y) {
        Node x = y.left;

        //先把x的右子树挪到y的左子树上
        y.left = x.right;
        if (x.right != this.NIL)
            x.right.parent = y;

        //x替代y的位置
        x.parent = y.parent;
        if (y.parent == this.NIL)
            this.root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    void rbInsert(Node z) {
        Node y = this.NIL;
        //从根节点一路推到NIL为止
        Node x = this.root;
        while (x != this.NIL) {
            y = x;
            if (z.key.compareTo(x.key) < 0)//小于向左推
                x = x.left;
            else
                x = x.right;//大于向右推
        }
        //y为最后一次NIL的父节点
        z.parent = y;
        //空树
        if (y == this.NIL)
            this.root = z;
        else if (z.key.compareTo(y.key) < 0)
            y.left = z;
        else
            y.right = z;
        z.left = this.NIL;
        z.right = this.NIL;
        z.color = RED;
        fixupRbInsert(z);
    }

    /**
     * 修复树，使保持红黑树性质
     * 红黑树5条性质，1、3对于已经成型红黑树天然满足，关键在于2、4、5条
     * 插入新节点默认染红，保证黑高不变，即满足第五条，
     * 剩下的就看是否满足2、4条，因此循环条件为：z的父节点是否为红色（第四条）
     * 当z为根节点时，破坏第二条
     *
     * @param z
     */
    private void fixupRbInsert(Node z) {
        while (z.parent.color == RED) {//RED

            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                //case 1,叔节点为红色
                if (y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = BLACK;
                    z = z.parent.parent;
                } else if (z == z.parent.right) {
                    //case 2，z为右子树
                    z = z.parent;
                    leftRotate(z);
                    //case 3
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }

            } else {
                //z的父节点在右子树上,情况基本等同以上，知识left和right调换
                Node y = z.parent.parent.left;
                //case 1,叔节点为红色
                if (y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = BLACK;
                    z = z.parent.parent;
                } else if (z == z.parent.left) {
                    //case 2，z为右子树
                    z = z.parent;
                    rightRotate(z);
                    //case 3
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        this.root.color = BLACK;
    }


    public static void main(String[] args) {
        System.out.println("a".compareTo("b"));
    }

}
