package leetcode;


/*
  leetcode 1114
*/
class Foo {
    //  只有获得该对象的锁才能进行下步操作
    Object obj = new Object();
    boolean firstEnd = false;
    boolean secondEnd = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (obj) {
            printFirst.run();
            firstEnd =true;
            obj.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (obj) {

            while (!firstEnd) {
                obj.wait();   //  放弃锁资源
            }

            printSecond.run();
            secondEnd=true;
            obj.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (obj) {

            while (!secondEnd) {
                obj.wait();   //  放弃锁资源
            }

            printThird.run();

            obj.notifyAll();
        }

    }

}