package datastructure;

public class Linkedlist<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e = e;
            this.next = null;
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public Linkedlist(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * 获取链表中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加元素e
     * @param e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        /*head =new Node(e,head);
        size ++;*/
        add(0,e);
    }
    //在链表的index（0-base）位置添加元素e
    public void add(int index,E e){
        if(index < 0|| index > size){
            throw new IllegalArgumentException("Add fail.Illegal index.");
        }
       /* if(index==0){
            addFirst(e);
        }else {*/
            Node prev = dummyHead;
            for (int i = 0; i <index ; i++) {
                prev=prev.next;
            }
            /*Node node = new Node(e);
            node.next =prev.next;
            prev.next =node;*/
            prev.next =new Node(e,prev.next);

            size ++;

    }
    public void addLast(E e){
        add(size,e);
    }
    public E get(int index){
        if(index < 0|| index > size){
            throw new IllegalArgumentException("Get fail.Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
        }
        return cur.e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改 第index 的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0|| index > size){
            throw new IllegalArgumentException("Set fail.Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
      /*  for(Node cur = dummyHead.next ; cur != null ; cur = cur.next) {
            res.append(cur + "->");
        }*/
        res.append("NULL");
        return res.toString();
    }
}
