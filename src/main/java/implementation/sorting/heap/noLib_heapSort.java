package implementation.sorting.heap;

import java.util.Random;

public class noLib_heapSort {
    int[] maxHeap;
    int size;

    public noLib_heapSort(int capacity) {
        maxHeap = new int[capacity];
        maxHeap[0] = Integer.MAX_VALUE;
    }

    public void printHeap() {
        for (int i = 1; i <= maxHeap.length - 1; i++) {
            System.out.print(maxHeap[i] + " ");
        }
    }

    public int parent(int size) {
        return size / 2;
    }

    public void swap(int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    public void addToSort(int data) {
        maxHeap[++size] = data;
        int current = size;
        while (maxHeap[current] > maxHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int pollToHeap() {
        int max = maxHeap[1];
        maxHeap[1] = maxHeap[size--];
        int current = size;
        while (maxHeap[current] > maxHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        noLib_heapSort h = new noLib_heapSort(10);
        for (int i = 1; i < h.maxHeap.length; i++) {
            int tmp = rand.nextInt(20);
            if (tmp == h.maxHeap[i]){
                --i;
            } else {
                h.addToSort(tmp);
            }
        }
        h.printHeap();
        System.out.println();
        System.out.println(h.pollToHeap());
        h.printHeap();
    }
}
