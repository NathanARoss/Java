/**
 This class implements a binary search tree using non-recursive methods

 Written by Nathan Ross
 Last modified 5-5-2018
 */

public class BinarySearchTree
{
    private Node root;

    public BinarySearchTree() {}

    /**
     * creates a balanced binary search free from the contents of a sorted array
     * @param sorted array containing sorted values
     */
    public BinarySearchTree(int[] sorted) {
        addArray(sorted, 0, sorted.length - 1);
    }

    /**
     * recursively adds the center element of each sub-array
     * breaks its sub-array in two and calls itself with each half
     * @param sorted array of sorted values to add
     * @param start first element in array
     * @param end last element in array (not size)
     */
    private void addArray(int[] sorted, int start, int end) {
        if (start > end)
            return;

        int mid = (start + end) >>> 1;
        add(sorted[mid]);
        addArray(sorted, start, mid - 1);
        addArray(sorted, mid + 1, end);
    }

    /**
     * adds a node with the value of x to the tree if a node with that value does not already exist
     * @param x the value of the node to add
     * @return whether the addition was successful
     */
    public boolean add(int x)
    {
        if (root == null) {
            root = new Node(x);
            System.out.printf("setting %d as root node%n", x);
            return true;
        }

        Node p = root;
        while (true) {
            if (x < p.value) {
                if (p.left == null) {
                    p.left = new Node(x);
                    System.out.printf("inserting %d to the left of node %d%n", x, p.value);
                    return true;
                }

                p = p.left;
            }
            else if (x > p.value) {
                if (p.right == null) {
                    p.right = new Node(x);
                    System.out.printf("inserting %d to the right of node %d%n", x, p.value);
                    return true;
                }

                p = p.right;
            }
            else {
                System.out.printf("%d is already in tree%n", x);
                return false;
            }
        }
    }

    /**
     * remove the node with the given value from the tree (non-recursively)
     * @param x value of node to remove
     * @return whether a node with that value was in the tree
     */
    public boolean remove(int x)
    {
        Node parent = null;
        Node p = root;

        while (p != null) {
            if (x < p.value) {
                parent = p;
                p = p.left;
            }
            else if (x > p.value) {
                parent = p;
                p = p.right;
            }
            else
                break;
        }

        //node not found
        if (p == null)
            return false;

        //no children
        if (p.left == null && p.right == null) {
            if (parent == null)
                root = null;
            else {
                if (p == parent.left)
                    parent.left = null;
                else
                    parent.right = null;
            }
        }

        //one child
        if (p.left == null || p.right == null) {
            Node child;
            if (p.left != null)
                child = p.left;
            else
                child = p.right;

            if (parent == null) {
                root = child;
            }
            else {
                if (p == parent.left)
                    parent.left = child;
                else
                    parent.right = child;
            }
        }

        //two children
        else {
            Node replacementParent = p;
            Node replacement = p.left;

            while (replacement.right != null) {
                replacementParent = replacement;
                replacement = replacement.right;
            }

            p.value = replacement.value;

            if (replacementParent == p)
                p.left = replacement.left;
            else
                replacementParent.right = replacement.left;
        }

        return true;
    }


    /**
     * prints the contents of the tree in order
     */
    public void print() {
        if (root == null) {
            return;
        }

        print(root);
    }

    private void print(Node p) {
        if (p.left != null)
            print(p.left);

        System.out.println(p.value);

        if (p.right != null)
            print(p.right);
    }
}
