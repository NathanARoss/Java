/**
 * Driver for BinarySearchTree.java
 *
 * Written by Nathan Ross
 * Last modified 5-5-2018
 */

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(1);
        tree.add(0);
        tree.add(0);
        tree.add(7);

        System.out.println();
        tree.print();
        System.out.println();

        System.out.println("removing 10");
        tree.remove(10);
        tree.print();

        System.out.println("\nremoving 5");
        tree.remove(5);
        tree.print();

        System.out.println("\nremoving 0");
        tree.remove(0);
        tree.print();

        System.out.println("\nremoving 7");
        tree.remove(7);
        tree.print();

        System.out.println("\nremoving 1");
        tree.remove(1);
        tree.print();

        System.out.println("\nremoving 15");
        tree.remove(15);
        tree.print();

        System.out.println();
        System.out.println();

        int[] data = {0, 5, 10, 15, 20, 25, 30};
        BinarySearchTree tree2 = new BinarySearchTree(data);
        tree2.print();
    }
}
