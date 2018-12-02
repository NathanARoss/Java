/**
 * implementation of a queue using two stacks
 * Deque-ing takes items from the second stack until it is empty,
 * then the contents of the first stack are dumped into the second one.
 *
 * As long as all the items from the second stack are remove before trying to
 * add more items to it, the items are always popped from the second stack in the
 * order they were pushed into the first stack.
 *
 * Written by Nathan Ross
 * Last modified 4-19-2018
 */

import java.util.Stack;

public class StackQueue <T> {
    private Stack<T> enqueueStack, dequeStack;

    public StackQueue() {
        enqueueStack = new Stack<>();
        dequeStack = new Stack<>();
    }

    public void appendTail(T item) {
        enqueueStack.push(item);
    }

    public T deleteHead() {
        if (dequeStack.empty()) {
            while (!enqueueStack.empty()) {
                dequeStack.push(enqueueStack.pop());
            }
        }

        //if the enqueueStack was also empty, this could happen
        if (dequeStack.isEmpty())
            return null;

        return dequeStack.pop();
    }
}
