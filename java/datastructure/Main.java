package datastructure;

public class Main {
    public static void main(String[] args) {
       /* //array
        datastructure.Array<Integer> arr=new datastructure.Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(4);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);*/
       /* datastructure.Array<datastructure.Student> studentArray = new datastructure.Array<>();
        studentArray.addLast(new datastructure.Student("kik",11));
        studentArray.addLast(new datastructure.Student("w",22));
        studentArray.addLast(new datastructure.Student("rr",42));
        System.out.println(studentArray);*/

       //stack
       /* datastructure.ArrayStack<Integer> stack=new datastructure.ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());*/
        Linkedlist<Object> linkedlist = new Linkedlist<>();
        for (int i = 0; i < 5 ; i++) {
            linkedlist.addFirst(i);
            System.out.println(linkedlist);
        }
        linkedlist.add(2,666);
        System.out.println(linkedlist);
    }
}
