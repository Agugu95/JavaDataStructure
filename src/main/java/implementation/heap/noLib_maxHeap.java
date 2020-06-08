package implementation.heap;

public class noLib_maxHeap {
    private int size;
    private int capacity;
    private int[] maxHeap;

    public noLib_maxHeap(int capacity) { // 최대 힙 크기
        this.capacity = capacity;
        this.size = 0; // 힙 크기
        maxHeap = new int[this.capacity - 1];
        maxHeap[0] = Integer.MAX_VALUE; // 0번은 비움
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    private void swap(int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (maxHeap[pos] < maxHeap[leftChild(pos)]
                || maxHeap[pos] < maxHeap[rightChild(pos)]) {
            if (maxHeap[leftChild(pos)] > maxHeap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));

            }
        }
    }
    
    public void insert(int input) {
        maxHeap[++size] = input;
        int current = size;
        while (maxHeap[current] > maxHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void printHeap() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println("parent= " + maxHeap[i] + " left= " + maxHeap[2 * i]
                    + " right = " + maxHeap[2 * i + 1]);
        }
    }

    public int deletedMax() {
        int delete = maxHeap[1];
        maxHeap[1] = maxHeap[size--];
        maxHeapify(1);
        return delete;
    }
    
    public int getMax() {
       return maxHeap[1];
    }

    public static void main(String[] args) {
        noLib_maxHeap noLib_maxHeap = new noLib_maxHeap(15);
        noLib_maxHeap.insert(5);
        noLib_maxHeap.insert(347);
        noLib_maxHeap.insert(212);
        noLib_maxHeap.insert(10);
        noLib_maxHeap.insert(23);
        noLib_maxHeap.insert(65);
        noLib_maxHeap.insert(400);
        noLib_maxHeap.insert(30);
        noLib_maxHeap.printHeap(); // 400 - 30 - 347 - 23 - 10 - 65 - 212 - 5
        System.out.println("delete max= " + noLib_maxHeap.deletedMax());
        noLib_maxHeap.printHeap();
    }
}
