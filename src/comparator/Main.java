package comparator;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(11);
        myList.add(3);
        myList.add(20);

        Set<Integer> set = new HashSet<>(myList);

        MyComparator comp = new MyComparator();

        Set<Integer> sortedSet = set.stream().sorted(comp).collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("hi");
    }
}
