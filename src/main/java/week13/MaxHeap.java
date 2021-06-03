package week13;


public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    //현재 pos에 있는 노드의 부모 위치를 return
    private int parent(int pos) {
        return pos /2;
    }

    //현재 pos에 있는 노드의 자식 위치 return
    private int leftChild(int pos) {
        return (2 * pos);
    }
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if(pos >= (size/2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fps, int spos) {
        int temp;
        temp = Heap[spos];
        Heap[spos] = temp;
    }

    /*
    * 지정된 sub tree를 max heapify 하기 위한 재귀 함수
    * 왼쪽과 오른쪽 하위 트리는 heapify 되었다고 가정하고 루트만 수정
    */
    private void maxHeapify(int pos){
        if(isLeaf(pos))
            return; //리프노드면 리턴

        if(Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) { //자식이 더 크다면

            if(Heap[leftChild(pos)] > Heap[rightChild(pos)]) { //left child가 더 크다면
                swap(pos, leftChild(pos)); //큰 left랑 바꾸고
                maxHeapify(leftChild(pos)); //heapify
            }
            else { //right child가 더 크다면
                swap(pos, rightChild(pos)); //큰 right랑 바꾸고
                maxHeapify(rightChild(pos));
            }
        }
    }

    //삽입
    public void insert(int element) {
        Heap[++size] = element;
        //위로 이동하면서 고친다
        int current = size;
        while (Heap[current] > Heap[parent(current)]) { //현재노드가 부모보다 크다면
            swap(current, parent(current)); //바꾼다
            current = parent(current); //부모노드가 현재노드가 된다
        }
    }

    public void print() {
        for(int i = 0; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD : " + Heap[2 * i + 1]);
            System.out.println();
        }
    }
    /*
    * heap에서는 루트노드만 삭제 가능
    * 최대 원소(MaxHeap의 Root)를 삭제 / 반환
    */
    public int remove() {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] arg) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(35);
        maxHeap.insert(23);
        maxHeap.insert(19);
        maxHeap.insert(47);
        maxHeap.insert(60);
        maxHeap.insert(35);
        maxHeap.insert(80);
        maxHeap.insert(44);


        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }
}









