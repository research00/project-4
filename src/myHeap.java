
import java.util.Random;
// Spring 2023
public class myHeap {
    final static int HOW_MANY_TESTs = 20;
    public static void main(String[] args) {
        System.out.println("Project 4. MinHeap (Spring 2023)");
// create an instance of Random class
        Random rand = new Random();
// create an instance of Heap211 class
        Heap211 heap = new Heap211();
        for (int test = 1; test <= HOW_MANY_TESTs; test++) {
//generate a random number to decide the action is 'add' or 'remove'
        int action = rand.nextInt(2);
        if (action == 0) {
// generate a node number using random number (eg 0~49)
        int node = rand.nextInt(50);
        System.out.println("Action " + test + ": Add " + node);
// add node to the heap by calling 'add method' in Heap211
        heap.add(node);
        }
// if the action is 'remove' {
        if(action == 1) {
            if (heap.isEmpty()) { //if the heap is empty, skip this action, do not count this action
                test = test - 1;
            } else {
                System.out.println("Action " + test + ": Remove min");
// remove node to the heap by calling 'remove method' in Heap211 class.
                int min = heap.remove();
            }
        }
        }
    }
}