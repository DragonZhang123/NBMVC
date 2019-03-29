package datastructure;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder rs = new StringBuilder();
        rs.append(String.format("datastructure.Queue:"));
        rs.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            rs.append(array.get(i));
            if (i!=array.getSize()-1){
                rs.append(", ");
            }
        }
        rs.append("] tail ");
        return rs.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
