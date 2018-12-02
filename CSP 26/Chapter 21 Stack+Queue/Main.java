/**
 * Driver for StackQueue.java
 *
 * Written by Nathan Ross
 * Last modified 4-19-2018
 */

public class Main {
    /**
     * create a queue, then test that it works
     * @param args ignored
     */
    public static void main(String[] args) {
        StackQueue<String> queue = new StackQueue<>();

        //proof of concept
        enqueue(queue, "hello");
        enqueue(queue, "hi");
        enqueue(queue, "howdy");
        deque(queue);
        deque(queue);
        deque(queue);

        System.out.println();

        //over-deque-ing
        enqueue(queue, "item");
        deque(queue);
        deque(queue);

        System.out.println();

        //mixed enqueue and deque (so first stack and second stack both have items)
        enqueue(queue, "first");
        enqueue(queue, "second");
        deque(queue);
        enqueue(queue, "third");
        deque(queue);
        deque(queue);
    }

    /**
     * wrapper around .appendTail() so I can print what I enqueue
     * @param queue queue to enqueue
     * @param item item to add
     * @param <T> type of item to add
     */
    private static <T> void enqueue(StackQueue<T> queue, T item) {
        System.out.printf("enqueue %s%n", item);
        queue.appendTail(item);
    }

    /**
     * wrapper around .deleteHead() so I can print what I deque
     * also handles the case where no item was deque-d
     * @param queue queue to deque
     * @param <T> type of item to deque
     */
    private static <T> void deque(StackQueue<T> queue) {
        T item = queue.deleteHead();

        if (item != null) {
            System.out.printf("deque %s%n", item);
        } else {
            System.out.println("queue is empty.  cannot deque");
        }
    }
}
