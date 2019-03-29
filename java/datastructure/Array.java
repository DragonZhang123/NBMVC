package datastructure;

import javax.xml.ws.WebFault;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     *
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
     }

    /**
     *
     */
    public Array(){
        this(10);
     }

    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向后添加元素
     * @param e
     */
    public void addLast(E e){
        /*if (size ==data.length){
            throw new IllegalArgumentException("addlast failed. The array is full!");
        }
        data[size]=e;
        size++;//*/
        add(size,e);
    }

    /**
     * 向前添加元素
     * @param e
     */
    public void addFirst(E e){
       add(0,e);
    }

    /**
     * 在index位置添加e
     *
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if(index < 0 ||index > size){
            throw new IllegalArgumentException("add  failed. The array is full!");
        }
        if (size ==data.length){
            //扩容
            resize(2 * data.length);

        }
        for (int i = size-1;i >= index;i--){
            data[i + 1]=data[i];
        }
        data[index]=e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData =(E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data = newData;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 ||index >= size){
            throw new IllegalArgumentException("Get failed. The index is illegal!");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改元素
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 ||index >= size){
            throw new IllegalArgumentException("Set failed. The index is illegal!");
        }
        data[index] =e;
    }
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 ||index >= size){
            throw new IllegalArgumentException("remove failed. The index is illegal!");
        }
        E ret =data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        //
        data[size]=null;
        //Eager 缩容，会有复杂度震荡
        /*if (size == data.length / 2){
            resize(data.length / 2);
        }*/
        //Lazy 缩容
        if (size == data.length / 4 &&data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e（只删除一个 无返回）
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index !=-1){
            remove(index);
        }
    }


    @Override
    public String toString() {
        StringBuilder rs = new StringBuilder();
        rs.append(String.format("datastructure.Array:size %d ,capacity = %d \n",size,data.length));
        rs.append("[");
        for (int i = 0; i < size; i++) {
            rs.append(data[i]);
            if (i!=size-1){
                rs.append(", ");
            }
        }
        rs.append("]");
        return rs.toString();
    }
}
