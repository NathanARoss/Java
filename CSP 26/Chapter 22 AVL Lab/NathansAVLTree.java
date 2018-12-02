/**
 * Extension of AVLTree to add functionality.
 * This class implements listing all values of a given height,
 * getting the height of a node with the given value,
 * and getting the values of ancestor of the node with the given value
 *
 * Written by Nathan Ross
 * Last Modified 5-12-2018
 */

import java.util.ArrayList;

public class NathansAVLTree extends AVLTree {
    public void clear() {
        root = null;
    }

    public ArrayList<Integer> getValuesAtHeight(int requestedHeight) {
        if (requestedHeight < 0)
            return null;

        ArrayList<Integer> list = new ArrayList<>();
        getValuesAtHeight(root, -1, requestedHeight, list);
        return list;
    }

    private void getValuesAtHeight(Node root, int height, int requestedHeight, ArrayList<Integer> list) {
        if (root != null) {
            ++height;

            if (height == requestedHeight) {
                list.add(root.value);
            } else {
                getValuesAtHeight(root.left, height, requestedHeight, list);
                getValuesAtHeight(root.right, height, requestedHeight, list);
            }
        }
    }

    public int getLevelOfValue(int value) {
        Node p = root;
        int height = -1;

        while (p != null) {
            ++height;

            if (value < p.value) {
                p = p.left;
            } else if (value > p.value) {
                p = p.right;
            } else {
                return height;
            }
        }

        return -1;
    }

    public ArrayList<Integer> getPathTo(int value) {
        Node p = root;
        ArrayList<Integer> list = new ArrayList<>();

        while (p != null) {
            list.add(p.value);

            if (value < p.value) {
                p = p.left;
            } else if (value > p.value) {
                p = p.right;
            } else {
                return list;
            }
        }

        return null;
    }
}
