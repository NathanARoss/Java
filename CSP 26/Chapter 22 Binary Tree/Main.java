/**
 * Driver for BinaryTree class
 *
 * Written by Nathan Ross
 * Last modified 4-27-2018
 */

public class Main {
    public static void main(String[] args) {
        //create an example tree with example data
        BinaryTree exampleTree = new BinaryTree();

        //print it's contents using different algorithms
        exampleTree.printInOrder();
        exampleTree.printBreadthFirst();
    }
}