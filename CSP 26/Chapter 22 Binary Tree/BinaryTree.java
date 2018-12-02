/**
 * This is an example binary tree to test 'in order' and 'breath first' search algorithms
 * This is not a real collection class
 *
 * Written by Nathan Ross
 * Last modified 4-17-2018
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    /**
     * initialize the tree to an example state.  This is not a collection class.
     */
    public BinaryTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }

    /**
     * print the tree's contents beginning with the left-most bottom-most node.
     * All left lodes take priority over right nodes.
     * Deeper left nodes take priority over shallower left nodes.
     * Parent's take priority over their right children.
     */
    public void printInOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        //push the entire left branch to the stack until we reach a leaf
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        //slowly back up, accessing the right branches of each node from the lowest node first
        while (stack.size() > 0) {
            current = stack.pop();
            System.out.print(current.value + " ");

            //push all the right branch's left nodes to the stack
            if (current.right != null) {
                current = current.right;

                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }

        System.out.println();
    }

    /**
     * print the contents of the tree beginning with the shallowest nodes
     * from left to right.
     */
    public void printBreadthFirst() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.value + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        System.out.println();
    }
}
