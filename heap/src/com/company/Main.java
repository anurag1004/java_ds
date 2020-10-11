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
    private void HeapifyUp(int i){
        while(i>0 && heap[parent(i)]>heap[i]){
            swap(i,parent(i));
            i = parent(i);
        }
    }
    public int getMin(){
        return heap[0];
    }
    public void deleteKey(int key){

    }
    private void decreaseKey(int index,int val){

    }
    private void extractMin(){

    }
    private void minHeapify(){

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
        HeapifyUp(current);
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
        minheap.insert(6);
        minheap.insert(7);
        minheap.insert(1);
        minheap.insert(2);
        minheap.insert(-1);
        minheap.insert(80);
        minheap.insert(-9);
        minheap.insert(3);
        System.out.println(minheap.getMin());
    }
}
