package list;

public class Test {
    public static void main(String[] args) {
        LinkedListTest list = new LinkedListTest();
        list.add("Saadat");
        list.add("Denf");
        list.add("Axel");

        System.out.println(list.size());
        list.remove(2);
        System.out.println(list.size());
    }
}
