import java.util.ArrayList;
//Spring 2023
public class Heap211 {
    static public ArrayList <Integer> heap = new ArrayList<>();
    // proj. 4
    Heap211() {
        heap.add(0); // explain why we need add(0)
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
//            if(heap.get(parent(index)) < heap.get(index)) {
                swap(parent(index), index);
                index = parent(index);
//            }
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

/*
bubble-down here
*/
        int index = 1;
//        while(index != heap.size()-1 &&( heap.get(index) > heap.get(leftChild(index)) || heap.get(index) > heap.get(rightChild(index)))) {
//
//            if (hasLeftChild(index) && hasRightChild(index)) {
//
//            }
//
//            if (hasLeftChild(index) && heap.get(leftChild(index)) < heap.get(index)) {
//                swap(index, leftChild(index));
//                index = leftChild(index);
//            }
//            if (hasLeftChild(index) && heap.get(rightChild(index)) < heap.get(index)) {
//                swap(index, rightChild(index));
//                index = rightChild(index);
//            }
//        }

        while (hasLeftChild(index) || hasRightChild(index)) {
            if (hasLeftChild(index) && hasRightChild(index)) {
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
            if (hasLeftChild(index) && !hasRightChild(index)) {
                if (heap.get(leftChild(index)) < heap.get(index)) {
                    swap(index, leftChild(index));
                    index = leftChild(index);
                }
            }
        }

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
