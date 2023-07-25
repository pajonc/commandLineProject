package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    /*
    i - table index
    current node --> i
    child node one --> 2i + 1
    child node two --> 2i + 2
    parent node -->  floor ((i-1)/2)    - floor will round down division
     */

    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    // O(nlog(n)) time | O(1) space - when sift Up used to build heap
    // O(n) time | O(1) space - when sift Down used to build heap
    public List<Integer> buildHeap(List<Integer> array) {
        int firstParentIdx = ( array.size() -1 ) / 2 ;
        for(int currentIdx = firstParentIdx; currentIdx >=0; currentIdx--) {
            siftDown(currentIdx, array.size()-1, array);
        }
        return array;
    }

    // O(log(n)) time | O(1) space
    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int childOneIdx = 2 * currentIdx + 1;
        while (childOneIdx <= endIdx) {
            int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                idxToSwap = childTwoIdx;
            } else {
                idxToSwap = childOneIdx;
            }
            if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIdx = 2 * currentIdx + 1;
            } else {
                return;
            }
        }
    }


    // O(log(n)) time | O(1) space
    public void siftUp(int currentIdx, List<Integer> heap) {
        int parentIdx = (currentIdx -1) / 2;
        while( heap.get(currentIdx) < heap.get(parentIdx) && currentIdx > 0) {
            swap(currentIdx, parentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        swap(0, heap.size() - 1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }

    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }

    private void swap(int i, int j, List<Integer> heap) {
        int temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }


}
