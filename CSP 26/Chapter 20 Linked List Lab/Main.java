/**
 * Driver for DoublyCircularlyLinkedList.
 *
 * Written by Nathan Ross
 * Written 4-15-2018
 */

public class Main {
    public static void main(String[] args) {
        DoublyCircularlyLinkedList<String> list = new DoublyCircularlyLinkedList<>();

        printStatus(list);

        System.out.printf("%nAdding \"Nathan\"%n");
        list.add("Nathan");

        printStatus(list);

        System.out.printf("%nAdding \"Alisson\"%n");
        System.out.printf("Adding \"Henry\"%n");
        System.out.printf("Adding \"Kevin\"%n");
        list.add("Alisson");
        list.add("Henry");
        list.add("Kevin");

        printStatus(list);

        System.out.printf("%nAdding \"Steve\" at position 1%n");
        list.add("Steve", 1);

        printStatus(list);

        System.out.printf("%nAdding \"Lucas\" at position 0%n");
        list.add("Lucas", 0);

        printStatus(list);

        System.out.printf("%nAdding \"George\" at end of list%n");
        list.add("George", list.size());

        printStatus(list);

        System.out.printf("%nAdding \"Reeves\"%n");
        list.add("Reeves");

        printStatus(list);

        System.out.printf("%nRemoving element at position 2%n");
        list.remove(2);

        printStatus(list);

        System.out.printf("%nRemoving \"Henry\"%n");
        list.remove("Henry");

        printStatus(list);
    }

    private static void printStatus(DoublyCircularlyLinkedList list) {
        System.out.printf("list toString(): %s%n", list.toString());
        System.out.printf("list isEmpty(): %s%n", list.isEmpty());
        System.out.printf("list size(): %d%n", list.size());
    }
}
