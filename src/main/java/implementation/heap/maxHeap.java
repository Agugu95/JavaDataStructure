package implementation.heap;

public class maxHeap {
    private int size;
    private int capacity;
    private int[] maxHeap;

    public maxHeap(int capacity) { // 최대 힙 크기
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
        maxHeap maxHeap = new maxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.printHeap();
        System.out.println("max= " + maxHeap.deletedMax());
        maxHeap.printHeap();
    }
}
