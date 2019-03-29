package datastructure;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

   @Override
   public void enqueue(E e){

       if((tail + 1) % data.length == front) {
           resize(getCapacity() * 2);
       }

       data[tail] = e;
       tail = (tail + 1) % data.length;
       size ++;
   }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] =null;
        front = (front + 1)%data.length;
        size--;

        if (size ==getCapacity()/4  && getCapacity()/2 !=0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }


    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from an empty queue.");
        }
        return data[front];
    }


    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front)% data.length];
        }
        data = newData;
        front = 0;
        tail =size;
    }
    @Override
    public String toString() {
        StringBuilder rs = new StringBuilder();
        rs.append(String.format("datastructure.Queue:size %d ,capacity = %d \n",size,getCapacity()));
        rs.append("front [");
        for (int i = front; i !=tail; i=(i+1)%data.length) {
            rs.append(data[i]);
            if ((i+1)%data.length!=tail){
                rs.append(", ");
            }
        }
        rs.append("] tail");
        return rs.toString();
    }
    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
