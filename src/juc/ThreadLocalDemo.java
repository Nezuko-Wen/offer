package juc;

/**
 * Test
 */
public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("A");
                print();
                System.out.println("after remove localVal:" + threadLocal.get());
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("B");
                print();
                System.out.println("after remove localVal:" + threadLocal.get());
            }
        }, "B").start();
    }

    protected static void print() {
        System.out.println(Thread.currentThread().getName() + "localVal:" + threadLocal.get());
        threadLocal.remove();
    }

}