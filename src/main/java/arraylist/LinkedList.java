package arraylist;

import org.w3c.dom.Node;

import javax.xml.crypto.Data;

public class LinkedList {
    //첫번째 노드를 가리키는 필드
    private Node head;
    //마지막 노드를 가리키는 필드
    private Node tail;
    private int size = 0;

    private class Node {
        //데이터가 저장될 필드
        //다음 노드를 가리키는 필드
        private Node next;
        private Object data;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }


    public void addFirst(Object input) {
        //노드를 생성
        Node newNode = new Node(input);
        //첫번째 노드는 뭐다? 왕관이다
        newNode.next = head;
        head = newNode;
        size++;
        //생성된 노드의 옆이 비었다면 왕관이 꼬리임
        if (newNode.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
        if (size == 0) {
            addFirst(input);
        }
        Node newNode = new Node(input);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
        if (k == 0) {
            addFirst(input);
        }
        Node newNode = new Node(input);
        Node temp1 = node(k - 1);
        Node temp2 = temp1.next;
        temp1.next = newNode;
        newNode.next = temp2;
        size++;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        String str = "[";
        Node temp = head;
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
        // 다음 노드가 없을 때까지 반복문을 실행합니다.
        // 다음 노드가 없지 않은한 - 다음 노드가 없으면 while문 벗어남
    }

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;
        Object removed = temp.data;
        temp = null;
        size--;
        return removed;
    }

    public Object remove(int k) {
        if (k == 0) {
            removeFirst();
        }
        Node temp = node(k - 1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        Object removed = todoDeleted.data;
        if (todoDeleted == tail) {
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return removed;
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        Node temp = node(k);

        return temp.data;
    }

    public int indexOf(Object data) {
        //특정한 값을 가진 엘리먼트의 인덱스 값을 알아내는 방법을 알아봅시다.
        // 값이 있다면 그 값이 발견되는 첫번째 인덱스 값을 리턴하고 값이 없다면 -1을 리턴 합니다.
        // 탐색 대상이 되는 노드를 temp로 지정합니다.
        Node temp = head;
        int index = 0;
        while (temp.data != data) {
            temp = temp.next;
            index++;
            if (temp == null) {
                return -1;
            }

        }
        return index;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
        // 탐색 값과 탐색 대상의 값을 비교합니다
        // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미합니다.이 때 -1을 리턴합니다.

    }
}



