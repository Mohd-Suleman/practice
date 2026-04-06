package miscellaneous;

import java.util.LinkedList;
import java.util.List;

public class LinkedListOperation {
    public static void main(String arg[]) {
        List<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);

        list.add(1, "New");
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
        list.remove("B");
        System.out.println(list);

    }





}
