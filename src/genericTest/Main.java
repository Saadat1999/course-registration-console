package genericTest;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        myList.add("Hello");
        myList.add("Bye");

        myList.run("a");
        test(myList);

        System.out.println(myList.get(2));
    }

    public static void test(ArrayList list) {
        list.add(1);
    }


//    public static  <T> T a(T obj) {
//        return obj;
//    }
}
