public class Main {
    public static void main(String[] args) {
        Array<Integer> arr=new Array();
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
        System.out.println(arr);
       /* Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("kik",11));
        studentArray.addLast(new Student("w",22));
        studentArray.addLast(new Student("rr",42));
        System.out.println(studentArray);*/
    }
}
