package containers;

import java.util.PriorityQueue;

/**
 * @author luzj
 * @description:
 * @date 2019/5/26
 */
public class ToDoList extends PriorityQueue {

    public void add(String data, char primary, int secondary) {
        super.add(new ToDoItem(primary, secondary, data));
    }

    /**
     * 定义队列元素
     * 优先队列的元素一定要实现Comparable接口，否则队列无法计算优先级
     */
    static class ToDoItem implements Comparable<ToDoItem> {

        private char primary;//单字符
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        /**
         * 优先比较primary,次比较secondary
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary)
                return +1;
            if (primary == o.primary) {
                if (secondary > o.secondary)
                    return +1;
                else if (secondary == o.secondary)
                    return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary + ": " + item;
        }
    }

    public static void main(String[] args) {
        //按照优先度从低到高的次序输出
        ToDoList toDoList = new ToDoList();
        toDoList.add("静夜诗", 'C', 4);
        toDoList.add("床前明月光", 'A', 2);
        toDoList.add("疑似地上霜", 'B', 7);
        toDoList.add("举头望明月", 'C', 3);
        toDoList.add("天上白玉京", 'A', 1);
        toDoList.add("十二楼五城", 'B', 1);
        while (!toDoList.isEmpty()) {
            System.out.println(toDoList.poll());
        }
    }
}
