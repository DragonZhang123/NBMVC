package lock;

/**
 * 在Java中是有常量池缓存的功能的，就是说如果我先声明了一个String str1 = “a”;
 * 再声明一个一样的字符串的时候，取值是从原地址去取的，也就是说是同一个对象。这也就导致了在锁字符串对象的时候，可以会取得意料之外的结果（
 * 字符串一样会取得相同锁）
 *
 * @author zhang
 *
 */
public class StringLock {

    /*
     * 在java 常量池有缓存功能
     */
    public void testStringStaticPool() {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b);// true
    }

    public void method() {
        String lockString = "字符串常量";
        // String newStringLock = new String("LOCK_STR");
        synchronized (lockString) {
            // synchronized (newStringLock) {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "   start");
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "   end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new StringLock().testStringStaticPool();
        StringLock stringLock = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            stringLock.method();
        } , "t2");

        // 因为t1和t2都锁住同一个固定字符串，那么t1持有锁之后，t2永远不会执行
        // 修改测试方法
        // 这里将线程t1和线程t2传进来的参数用new方式创建对象。这样就可以保证不是同一个对象。
        t1.start();
        t2.start();
    }
}
