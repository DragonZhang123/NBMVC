package datastructure;



public class LinkedListStack<E> implements Stack<E> {
    private Linkedlist<E> list;

    public LinkedListStack(Linkedlist<E> list) {
        this.list = new Linkedlist<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {

        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack : top ");
        stringBuilder.append(list);

        return stringBuilder.toString();
    }
}
