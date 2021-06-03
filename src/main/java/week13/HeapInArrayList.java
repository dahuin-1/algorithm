package week13;


import java.util.ArrayList;

public class HeapInArrayList {

    private ArrayList<Character> heap = new ArrayList<>();

    public HeapInArrayList() {
        heap.add(null);
    }

    public void heapSort(char[] input) {
        buildHeap(input);
        sortOut();
    }

    private void sortOut() {
        System.out.println("<Max.heap>");
        while (heap.size() > 1) {
            System.out.println(deleteHeap() + "  " + heap.toString());
        }
    }

    private Character deleteHeap() {
        if (heap.size() <= 1) {
            return null;
        }
        char retVal = heap.remove(1);
        if (heap.size() > 2) {
            heap.add(1, heap.remove(heap.size() - 1));
            heapifyDownward(1);
        }
        return retVal;
    }

    private void heapifyDownward(int i) {
        int k = 2 * i;
        if (k >= heap.size() || i < 1)
            return;
        if (k + 1 < heap.size() && (heap.get(k + 1) > heap.get(k)))
            k++;
        if (heap.get(k) > heap.get(i)) {
            swap(heap, k, i);
            heapifyDownward(k); //child
        }
    }


    private void buildHeap(char[] input) {
        System.out.println("<<Heap implemented in arraylist>>");
        for (int i = 0; i < input.length; i++) {
            insertHeap(input[i]);
        }
    }

    private void insertHeap(char c) {
        int k = heap.size();
        heap.add(k, c);

        System.out.print(c + " ");
        //부모와 바꿀지 체크
        int parentIndex = k / 2;
        heapifyUpward(parentIndex);
        System.out.println(heap.toString());
    }

    private void heapifyUpward(int parentIndex) {
        int k = 2 * parentIndex; //leftchild
        if (k >= heap.size() || parentIndex < 1)
            return; //여기서 걸러지지 않았다는 것은 최소한 하나의 트렌지션이 있다
        if (k + 1 < heap.size() && (heap.get(k + 1) > heap.get(k)))
            k++;
        if (heap.get(k) > heap.get(parentIndex)) {
            swap(heap, k, parentIndex);
            heapifyUpward(parentIndex / 2);
        }
    }

    private void swap(ArrayList<Character> heap2, int k, int i) {
        char temp = heap.get(k);
        heap.set(k, heap.get(i));
        heap.set(i, temp);
    }

    public static void main(String[] args) {
        char[] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
        HeapInArrayList h = new HeapInArrayList();
        h.heapSort(data);
    }

}
