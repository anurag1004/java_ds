package com.company;
class MinHeap{
    private int[] heap;
    private int heap_size; //current heap size
    private int capacity; //max heap size
    public MinHeap(int capacity){
        this.heap = new int[capacity];
        this.heap_size = 0;
        this.capacity = capacity;
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return (2*index+1);
    }
    private int right(int index){
        return (2*index+2);
    }
    public int getMin(){
        return heap[0];
    }
    // this method will delete key at index i
    public void deleteKey(int i){
        if(i<heap_size){
            decreaseKey(i,Integer.MIN_VALUE);
            extractMin();
        }else{
            System.out.println("\nNo such index exist!!!");
        }

    }
    public void display(){
        if(heap_size<=0){
            // no elements in the heap
            System.out.println("Heap is empty!!!\n");
            return;
        }
        System.out.printf("\n[ ");
        for(int i=0;i<heap_size;i++){
            System.out.printf("%d ",heap[i]);
        }
        System.out.printf("]\n");
    }
    private void decreaseKey(int index,int val){
        heap[index] = val;
        // now calling heapifyUp method(to maintain min heap property) and
        // also on doing so this minimum value comes to index 0
        // we'll call then extractMin which will remove
        // and return the top element of heap(in this case the minimum one)
        heapifyUp(index);
        // now the element which has to be delete is replaced by INT.MINIMUM, and came ta the top
        // no we've to just remove it by calling extractMin()
    }
    private int extractMin(){
        if(heap_size <= 0){
            // no elements in the heap
            System.out.println("Heap is empty!!!\n");
            return Integer.MAX_VALUE;
        }
        int root = heap[0];
        heap[0] = heap[heap_size-1]; //replace it with last element
        heap_size--;
        minHeapify(0);
        return root;
    }
    //this method will heapify the tree from top to bottom
    private void heapifyUp(int i){
        while(i>0 && heap[parent(i)]>heap[i]){
            swap(i,parent(i));
            i = parent(i);
        }
    }

    // this method will heapify the tree from top to bottom
    // This method assumes that the subtrees are already heapified
    private void minHeapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest = i; // smallest index
        if( l<heap_size && heap[l]<heap[i])
            smallest = l;
        if( r<heap_size && heap[r]<heap[smallest])
            smallest = r;
        if(smallest != i){
            swap(smallest,i);
            minHeapify(smallest);
        }
    }
    public void insert(int key){
        if(this.heap_size == capacity){
            // heap is full
            System.out.println("Heap is full!!\n");
            return;
        }
        // add key to last index
        heap[heap_size] = key;
        int current = heap_size;
        heap_size++;

        //Heapify up
        // from bottom to top, since last element is at position "heap_size-1"
        heapifyUp(current);
    }
    private void swap(int fpos,int spos){
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }
}
public class Main {

    public static void main(String[] args) {
        MinHeap minheap = new MinHeap(9);
        minheap.insert(5);
        minheap.display();
        minheap.insert(6);
        minheap.display();
        minheap.insert(7);
        minheap.display();
        minheap.insert(1);
        minheap.display();
        minheap.insert(2);
        minheap.display();
        minheap.insert(4);
        minheap.display();
        minheap.insert(3);
        minheap.display();
        minheap.insert(9);
        minheap.display();
        minheap.insert(8);
        minheap.display();
//        minheap.insert(1);
//        minheap.display();
        /*
        *            1
        *           //\\
        *         2     3
        *       //\\   //\\
        *      6   5  7   4
        *     //\\
        *    9    8
        * [ 1 2 4 3 9 8 6 7 5]
        */
//        minheap.display();
        System.out.println(minheap.getMin());

        //delete all one by one
        minheap.deleteKey(1);
        /*
         *            1
         *           //\\
         *         5     3
         *       //\\   //\\
         *      6   8  7   4
         *     //
         *    9
         * [ 1 2 4 3 9 8 6 7 5]
         */
        minheap.display();

        // Time Complexity
        // insert() O(logn)
        // deletekey() O(logn)
        // extractMin() O(logn)
        // getMin() O(1)
        // decreaseKey() O(logn)
        minheap.deleteKey(1);
        minheap.deleteKey(1);
        minheap.deleteKey(1);
        minheap.deleteKey(1);
        minheap.deleteKey(1);
        minheap.deleteKey(1);
        minheap.deleteKey(1);
        minheap.display(); // [1]

        minheap.deleteKey(1);
        minheap.display();
    }
}
