package com.chrzanop.coding.algoexpert.heaps;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArrays3 {

    // O(nlog(k) + k) time | O(n+k) space - where n is the total number for array elements
    // and k is the number of arrays
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> sortedList = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            items.add(new Item(i, arrays.get(i).get(0), 0));
        }
        MinHeap minHeap = new MinHeap(items);
        while (!minHeap.isEmpty()) {
            Item smallestItem = minHeap.remove();
            sortedList.add(smallestItem.num);
            if (smallestItem.elementIdx == arrays.get(smallestItem.arrayIdx).size() - 1) continue;
            minHeap.insert(
                    new Item(smallestItem.arrayIdx,
                            arrays.get(smallestItem.arrayIdx).get(smallestItem.elementIdx + 1),
                            smallestItem.elementIdx + 1));
        }
        return sortedList;
    }

    static class MinHeap {

        List<Item> heap = new ArrayList<Item>();

        public MinHeap(List<Item> array) {
            heap = buildHeap(array);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public List<Item> buildHeap(List<Item> array) {
            int firstParentIdx = (array.size() -1) / 2 ;
            for(int currentIdx = firstParentIdx; currentIdx >=0; currentIdx--) {
                siftDown(currentIdx, array.size()-1, array);
            }
            return array;
        }

        // O(log(n)) time | O(1) space
        public void siftDown(int currentIdx, int endIdx, List<Item> heap) {
            int childOneIdx = currentIdx * 2 + 1;
            while(childOneIdx <= endIdx) {
                int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int idxToSwap;
                if(childTwoIdx != -1 && heap.get(childTwoIdx).num < heap.get(childOneIdx).num) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if(heap.get(idxToSwap).num < heap.get(currentIdx).num) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }


        // O(log(n)) time | O(1) space
        public void siftUp(int currentIdx, List<Item> heap) {
            int parentIdx = (currentIdx -1) / 2;
            while( heap.get(currentIdx).num < heap.get(parentIdx).num && currentIdx > 0) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }

        }

        public Item peek() {
            return heap.get(0);
        }

        public Item remove() {
            swap(0, heap.size()-1, heap);
            Item valueToRemove = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(0, heap.size()-1, heap);
            return valueToRemove;
        }

        public void insert(Item value) {
            heap.add(value);
            siftUp(heap.size()-1, heap);
        }

        private void swap(int i, int j, List<Item> heap) {
            Item temp = heap.get(j);
            heap.set(j,heap.get(i));
            heap.set(i,temp);
        }



    }

    static class Item {
        public int arrayIdx;
        public int num;
        public int elementIdx;

        public Item(int arrayIdx, int num, int elementIdx) {
            this.arrayIdx = arrayIdx;
            this.num = num;
            this.elementIdx = elementIdx;
        }
    }


}
