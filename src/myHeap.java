// Viktor Matthew Schultz
// Student ID: 202853271
// 6/12/2023
// this program implements a testing environment for a min heap data structure
import java.util.Random;

public class myHeap {
    final static int HOW_MANY_TESTs = 20;
    final static int MAX_NODE_VALUE = 50;
    public static void main(String[] args) {
        System.out.println("\nProject 4. MinHeap (Spring 2023)\n");
        // create an instance of Random class
        Random rand = new Random();

        // create an instance of Heap211 class
        Heap211 heap = new Heap211();

        for (int test = 1; test <= HOW_MANY_TESTs; test++) {

            //generate a random number to decide the action is 'add' or 'remove'
            int action = rand.nextInt(2);

            // if the action is 'add'
            if (action == 0) {
                // generate a node number using random number (eg 0~50)
                int node = rand.nextInt(MAX_NODE_VALUE + 1);
                System.out.println("Action " + test + ": Add " + node);
                // add node to the heap by calling 'add method' in Heap211
                heap.add(node);
                System.out.println();
            }

            // if the action is 'remove'
            if(action == 1) {
                if (heap.isEmpty()) { //if the heap is empty, skip this action, do not count this action
                    test = test - 1;
                } else {
                    System.out.println("Action " + test + ": Remove min");
                    // remove node to the heap by calling 'remove method' in Heap211 class.
                    heap.remove();
                    System.out.println();
                }
            }
        } // end for
    }
}