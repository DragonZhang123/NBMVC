package leetcode;

import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
     Object lock =new Object();
     boolean fooPrint =false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                lock.notifyAll();
                printFoo.run();
                fooPrint =true;
                lock.wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if (fooPrint){
                    lock.notifyAll();
                    printBar.run();
                    fooPrint =false;
                }
            }
            // printBar.run() outputs "bar". Do not change or remove this line.

        }
    }
}
