// Viktor Matthew Schultz
// Student ID: 202853271
// 6/12/2023
// this program implements a min heap data structure

import java.util.ArrayList;
public class Heap211 {
    static public ArrayList <Integer> heap = new ArrayList<>();

    // due to indexing structure, if we start adding elements we need from index 0, if there occurs a situation when
    // we need to check if the node has a parent, and the node in question is the root node, it will reference
    // its own index as its parent's index

    Heap211() {
        heap.add(0);
    }


    int parent(int index) {
        return index/2;
    }
    int leftChild(int index) {
        return index*2;
    }
    int rightChild(int index) {
        return index*2 + 1;
    }
    boolean hasParent(int index) {
        return index > 0;
    }
    boolean hasLeftChild(int index) {
        return index*2 < heap.size();
    }
    boolean hasRightChild(int index) {
        return index*2 + 1 < heap.size();
    }
    void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b,temp);
    }

    int peekMin() {
        return heap.get(1);
    }

    boolean isEmpty() {
        return heap.size() == 1;
    }
    void add(int value) {
        int index = heap.size();
        heap.add(value);
        System.out.println(" heap: " + printHeap());
        System.out.println(" bubble-up: start");

        while(hasParent(index) && index != 1 && heap.get(parent(index)) > heap.get(index)) {
            swap(parent(index), index);
            index = parent(index);
        }

        System.out.println(" bubble-up: end");
        System.out.println(" new heap: " + printHeap());
    }
    int remove() {
        System.out.println(" heap: " +printHeap());

        int min = peekMin(); // peek min value by calling peekMin()
        heap.set(1 , heap.get(heap.size()-1)); // move the last node to the first. tip: use one of the ArrayList methods
        System.out.println(" Removed: " + min);
        heap.remove(heap.size()-1); // delete the last node from the heap. The heap is reduced.

        System.out.println(" heap: " +printHeap());
        System.out.println(" bubble-down: start");

        int index = 1;
        // bubbling down while the examined node has children
        while (hasLeftChild(index) || hasRightChild(index)) {

            // first evaluate the case when a node has 2 children
            if (hasLeftChild(index) && hasRightChild(index)) {

                // 3 possible cases:
                // 1. leftChild < node < rightChild => swap leftChild and node
                // 2. rightChild < node < leftChild => swap rightChild and node
                // 3. rightChild < node and leftChild < node ==> 2 more sub-cases:

                // 3.1 leftChild < node => swap leftChild and node
                // 3.2 rightChild < node => swap rightChild and node
                if (heap.get(leftChild(index)) < heap.get(index) && heap.get(rightChild(index)) > heap.get(index)) {
                    swap(index, leftChild(index));
                    index = leftChild(index);
                } else if (heap.get(leftChild(index)) > heap.get(index) && heap.get(rightChild(index)) < heap.get(index)) {
                    swap(index, rightChild(index));
                    index = rightChild(index);
                } else if (heap.get(leftChild(index)) < heap.get(index) && heap.get(rightChild(index)) < heap.get(index)) {

                    if (heap.get(leftChild(index)) < heap.get(rightChild(index))) {
                        swap(index, leftChild(index));
                        index = leftChild(index);
                    } else {
                        swap(index, rightChild(index));
                        index = rightChild(index);
                    }
                }

            }

            // at the end there may be a scenario when the last node we check only has a leftChild
            // this is the last node we need to check due to the structure of the min heap, when all
            // nodes are added left to right top to bottom
            if (hasLeftChild(index) && !hasRightChild(index)) {
                if (heap.get(leftChild(index)) < heap.get(index)) {
                    swap(index, leftChild(index));
                }
                break;
            }
        } // end while
        System.out.println(" bubble-down: end");
        System.out.println(" new heap: " +printHeap());
        return min;
    }

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
