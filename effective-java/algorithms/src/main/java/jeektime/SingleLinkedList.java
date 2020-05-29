package jeektime;

/**
 * @author luzj
 * @description: 对单向链表的常见操作
 * @date 2019/5/30
 */
public class SingleLinkedList {

    static class Node {
        Node next;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    /**
     * 思路：
     * 1 把前一个节点设为pre,当前节点为cur
     * 2 cur推进一次，cur即加入pre链表，作为pre链表的head
     * 3 直至cur为空为止
     *
     * @param head
     * @return
     */
    Node reverse(Node head) {
        Node cur = head, pre = null;

        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

//    链表中环的检测

    /**
     * 检测是否是环形链表
     *
     * @param head
     * @return
     */
    boolean checkCircle(Node head) {
        if (head == null)
            throw new IllegalArgumentException("list is empty");
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 两个有序的链表合并
     *
     * @param head1
     * @param head2
     * @return
     */
    Node mergeOrderList(Node head1, Node head2) {
        Node p = head1, q = head2;
        Node head = null;

        //确定首节点，单独处理
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else if (p.data >= q.data) {
            head = q;
            q = q.next;
        }

        Node h = head;

        //遍历节点
        while (p != null && q != null) {
            if (p.data < q.data) {
                head.next = p;
                p = p.next;
            } else {
                head.next = q;
                q = q.next;
            }
            head = head.next;
        }

        //连接剩下的尾部链表
        if (q != null) {
            head.next = q;
        } else {
            head.next = q;
        }
        return h;

    }


    /**
     * 删除链表倒数第 n 个结点
     * 思路：
     * 双指针：fast比slow先行k个节点
     *
     * @param head
     * @return
     */
    Node deleteLastKth(Node head, int k) {
        //find Kth Mode
        Node slow = head, fast = head;
        int count = 0;
        while (fast.next != null) {
            if (count == k)
                break;
            count++;
            fast = fast.next;
        }

        if (count < k)
            throw new IllegalArgumentException("list size less than k");

        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = slow.next;
        slow.next = null;
        return slow;
    }

    /**
     * 求链表的中间结点
     * 使用双指针发，快指针双倍移速
     *
     * @param head
     * @return
     */
    Node midNode(Node head) {
        if (head == null)
            return null;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node createNode(int val) {
        return new Node(null, val);
    }

    /**
     * 输出链表
     *
     * @param head
     */
    static void printList(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + "\t");
            p = p.next;
        }
        System.out.println();
    }

}
