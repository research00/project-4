import java.util.ArrayList;
//Spring 2023
public class Heap211 {
    static public ArrayList <Integer> heap = new ArrayList<>();
    // proj. 4
    Heap211() {
        heap.add(0); // explain why we need add(0)
    }

    int parent(int index) {
        return . . .;
    }
    int leftChild(int index) {
        return . . .;
    }
    int rightChild(int index) {
        return . . .;
    }
    boolean hasParent(int index) {
        return . . .;
    }
    boolean hasLeftChild(int index) {
        return . . .;
    }
    boolean hasRightChild(int index) {
        return . . .;
    }
    void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b,temp);
    }

    int peekMin() {
        return . . .;
    }

    boolean isEmpty() {
        return heap.size() == 1;
    }
    void add(int value) {
// CP 16
/*
heap.. . .; // add as rightmost leaf
*/
        System.out.println(" heap: " +printHeap());
        System.out.println(" bubble-up: start");
// proj 4
/*
bubble-up here
*/
        System.out.println(" bubble-up: end");
        System.out.println(" new heap: " +printHeap());
    }
    int remove() {
        System.out.println(" heap: " +printHeap());
// CP 16
/*
int min = . . .; // peek min value by calling peekMin()
heap.set(.. , ...); // move the last node to the first. tip: use one of the
ArrayList methods
System.out.println(" Removed: " + min);
heap.remove(. . .); // delete the last node from the heap. The heap is
reduced.
*/
        System.out.println(" heap: " +printHeap());
        System.out.println(" bubble-down: start");
// proj 4
/*
bubble-down here
*/
        System.out.println(" bubble-down: end");
        System.out.println(" new heap: " +printHeap());
        return min;
    }
    //use this method as is
    public String printHeap(){
        StringBuilder result = new StringBuilder("[");
        if (heap.size()>1) {
            result.append(heap.get(1));
        }
        for (int i = 2; i < heap.size(); i++){
            result.append(", ").append(heap.get(i));
        }
        return result + "]";
    }
}
