package week13;

public class MinHeap {

    private int[] Heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    //현재 pos에 있는 노드의 부모 위치를 return
    private int parent(int pos) {
        return pos / 2;
    }

    //현재 pos에 있는 노드의 자식 위치 return
    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int temp;
        temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    //노드가 리프가 아닌 노드이고 하위 노드보다 큰 경우
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { //rightchild가 크면
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos)); //작은 left랑 바꾸고
                } else { //leftchild가 크면
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos)); //작은 right랑 바꿈
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 0; i <= size / 2; i++) {
            System.out.print("PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD : " + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    //build
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }
    /*
    * heap에서는 루트노드만 삭제 가능
    * 최대 원소(MaxHeap의 Root)를 삭제 / 반환
    */
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(3);
        minHeap.insert(10);
        minHeap.insert(35);
        minHeap.insert(23);
        minHeap.insert(19);
        minHeap.insert(47);
        minHeap.insert(60);
        minHeap.insert(35);
        minHeap.insert(80);
        minHeap.insert(44);
        minHeap.print();
        System.out.println("The max val is " + minHeap.remove());
    }


}
