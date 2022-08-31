package ds.queue;

/**
 * 环形队列
 * @author Wen
 * @date 2022/8/7 17:07
 */
public class CircularQueue {
    private final int[] table;
    private int size = 0; //元素个数
    private int front = 0; //队头
    private int rear = 0; //队尾
    private final int limit;

    private static final int DEFAULT_LIMIT = 10;

    public CircularQueue() {
        this.limit = DEFAULT_LIMIT;
        table = new int[limit];
    }

    public CircularQueue(int limit) {
        this.limit = limit;
        table = new int[limit];
    }

    public void put(int val) {
        if (size == limit) {
            throw new RuntimeException("当前队列已满");
        }
        size ++;
        table[rear] = val;
        rear = rear == limit - 1 ? 0 : rear + 1;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("当前队列为空");
        }
        size --;
        int ret = table[front];
        front = front == limit - 1 ? 0 : front + 1;
        return ret;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        for (int i = 0; i < 10; i ++) {
            cq.put(i);
        }
        for (int i = 0; i < 5; i ++) {
            System.out.println(cq.pop());
        }

        for (int i = 0; i < 3; i ++) {
            cq.put(i);
        }

        for (int i = 0; i < 5; i ++) {
            System.out.println(cq.pop());
        }

        for (int i = 0; i < 5; i ++) {
            System.out.println(cq.pop());
        }
        System.out.println();
    }
}
