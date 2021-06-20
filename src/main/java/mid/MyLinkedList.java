package mid;

import org.w3c.dom.Node;

public class MyLinkedList {

    Node first;
    int numOfNode;

    public MyLinkedList() {
        first = null;
        numOfNode = 0;
    }

    public String get(int index) {
        if(!vaildIndex(index)){
            return null;
        }
        Node temp = first;
        for(int i = 0; i < index; i++) {
            temp = temp.link;
        }
        return temp.data;
    }

    private boolean vaildIndex(int index) {
        return index < numOfNode && index >= 0;
    }

    public void set(int index, String data) {
        if(!vaildIndex(index)){
            return;
        }
        Node temp = first;
        for(int i = 0; i < index; i++) {
            temp = temp.link;
        }
        temp.data = data;
    }

    public void addFirst(String data) {
        Node newNode = new Node(data,first);
        first = newNode;
        numOfNode++;
    }

    public void addLast(String data) {
        if(numOfNode==0){
            addFirst(data);
        }else {
            Node temp = first;
            while(temp.link!=null){
                temp = temp.link;
            }
            temp.link = new Node(data, null);
            numOfNode++;
        }
    }

    public void add(int index, String data){
        if(index==0)
            addFirst(data);
        else if(index==numOfNode)
            addLast(data);
        else {
            if(!vaildIndex(index))
                return;
            Node temp = first;
            int i = 0;
            while(i<index-1) {
                temp = temp.link;
                i++;
            }
            temp.link = new Node(data, temp.link);
            numOfNode++;
        }
    }

    public String removeFirst() {
        if(first!=null){
            String ret = first.data;
            first = first.link;
            numOfNode--;
            return ret;
        }
        else
            return null;
    }

    public String removeLast() {
        if(first!=null){
           Node temp = first;
           Node tempNext = temp.link;
           while (tempNext!=null){
               temp = tempNext;
               tempNext = tempNext.link;
           }
           temp.link = null;
           numOfNode--;
           return tempNext.data;
        }
        else
            return null;
    }

    public String remove(int index) {
        if(!vaildIndex(index))
            return null;
        if(index==0)
            return removeFirst();
        else if(index==numOfNode-1)
            return removeLast();
        else {
            Node temp = first;
            Node tempNext = temp.link;
            int i = 1;
            while(i<index) {
                temp = tempNext;
                tempNext = tempNext.link;
                i++;
            }
            temp.link = tempNext.link;
            numOfNode--;
            return tempNext.data;
        }
    }

    public int remove(String data) {
        Node temp = first;
        if(temp.data.compareTo(data)==0){
            first = temp.link;
            numOfNode--;
            return 0;
        }
        Node tempNext = temp.link;
        int i = 1;
        while (tempNext!=null){
            if(tempNext.data.compareTo(data)==0){
                temp.link = tempNext.link;
                numOfNode--;
                return i;
            }
            else {
                i++;
                temp = tempNext;
                tempNext=tempNext.link;
            }
        }
        return -1;
    }

    private int indexOf(String data) {
        Node temp = first;
        for(int i = 0; i<numOfNode; i++){
            if(temp.data.compareTo(data)==0)
                return i;
            temp = temp.link;
        }
        return -1;
    }

    private int indexOf(MyLinkedList list, String data) {
        // 탐색 대상이 되는 노드를 temp로 지정
        Node temp = first;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교
        while(temp.data != data) {
            temp = temp.link;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴
            if (temp == null) {
                return -1;
            }
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴
        return index;
    }

    private int sizeOf() {
        return numOfNode;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for(int i = 0; i<list.sizeOf(); i++) {
            System.out.println(list.indexOf(list, list.get(i)));
        }
       // System.out.println(list.indexOf(list,new MyClass(3,"chor")));
    }


    private class Node {
        String data;
        Node link;
        private Node(String input, Node next){
            data = input;
            link = next;
        }
    }

}
