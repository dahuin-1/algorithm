package week13;

import java.util.ArrayList;

public class HeapTree {
    Node heap; //root
    Node last;

    public HeapTree() {
        heap = null;
        last = null;
    }

    public void heapSort(char[] input) {
        buildHeap(input);
        sortOut();
    }

    private void sortOut() {

    }

    private Character deleteHeap() {

        return 0;
    }

    private void heapifyDownward(int i) {
        int k = 2 * i;
    }


    private void buildHeap(char[] input) {
        System.out.println("<<Heap implemented in LinkedTree>>");

        for (int i = 0; i < input.length; i++) {
            insertHeap(input[i]);
        }
    }

    private void insertHeap(char c) {
        if(heap==null) {
            heap = new Node(c, null, null, null);
            last = heap;
            return;
        }


        /*Node pNext = getParentOfNext(last);
        last = new Node(c, null, null, pNext);
        if(pNext.left == null) {
           pNext.left = last;
        }else{
            pNext.right = last;
        }
        heapifyUpward(last.parent);*/
        System.out.println(heap.toString());
    }

    private void heapifyUpward(Node node) {
       if(node==null||node.left==null)
           return;
       Node larger = node.left;
       if(node.right!=null && node.right.key>node.left.key)
          larger = node.right;

       if(larger.key > node.key) {
           swap(larger, node);
           heapifyUpward(node.parent);
       }
    }

    private void swap(Node a, Node b) {
        char temp = a.key;
        a.key = b.key;
        b.key = temp;
    }

    public static void main(String[] args) {
        char[] data = {'M', 'Y', 'U', 'N', 'G', 'I', 'S', 'W'};
        HeapTree h = new HeapTree();
        h.heapSort(data);
    }

    class Node {
        char key;
        Node left, right, parent;

        public Node(char c, Node l, Node r, Node p) {
            key = c;
            left = l;
            right = r;
            parent = p;
        }

        public String toString() {
            return " " + key;
        }
    }


}
