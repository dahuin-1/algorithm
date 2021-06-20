package mid;

public class MyDoubleLinkedList {
    Node first, last;
    int size = 0;

    public MyDoubleLinkedList() {
        first = null;
        last = null;
    }

    private boolean validIndex(int index) {
        return index < sizeOf(first) && index >= 0; //단순화시킴
    }

    public void addFirst(String data) {
        Node newNode = new Node(data,null,null);
        // 새로운 노드의 다음 노드로 first 지정
        newNode.next = first;
        // 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정
        if (first != null)
            first.previous = newNode;
        // 헤드로 새로운 노드를 지정합
        first = newNode;
        size++;
        if (first.next == null) {
            last = first;
        }
    }
    public void addLast(String data) {
        // 노드를 생성
        Node newNode = new Node(data,null,null);
        if (size == 0) {
            addFirst(data);
        } else {
            //last 다음 노드로 생성한 노드를 지정
            last.next = newNode;
            // 새로운 노드의 이전 노드로 last 지정
            newNode.previous = last;
            // 마지막 노드를 갱신
            last = newNode;
            // 엘리먼트의 개수를 1 증가
            size++;
        }
    }

    Node node(int index) {
        // 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
        if (index < size / 2) {
            //first next를 이용해서 인덱스에 해당하는 노드를 찾음
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            // last ~ previous 이용해서 인덱스에 해당하는 노드를 찾음
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
    }

    public void add(int index, String data) {
        //	구현하시오!
        if (index == 0) {
            addFirst(data);
        } else {
            Node temp1 = node(index - 1);
            //index에 해당하는 노드를 temp2로 지정
            Node temp2 = temp1.next;
            // 새로운 노드를 생성
            Node newNode = new Node(data,null,null);
            // temp1의 다음 노드로 새로운 노드를 지정
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2를 지정
            newNode.next = temp2;
            // temp2의 이전 노드로 새로운 노드를 지정
            if (temp2 != null)
                temp2.previous = newNode;
            // 새로운 노드의 이전 노드로 temp1을 지정
            newNode.previous = temp1;
            size++;
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 last
            if (newNode.next == null) {
                last = newNode;
            }
        }
    }
    private int sizeOf(Node link) {
        if (link==null)
            return 0;
        else
            return 1+sizeOf(link.next);
    }

    public String toString() {
        Node temp = first;
        String retVal="";
        while(temp!=null) {
            retVal=retVal+"/"+temp.data.toString();
            temp=temp.next;
        }
        return retVal;
    }

    public static void main(String[] args) {

        MyDoubleLinkedList list = new MyDoubleLinkedList();

        list.addLast("lee");
        System.out.println(list.toString());
        list.addFirst("kim");
        System.out.println(list.toString());
        list.addLast("park");
        System.out.println(list.toString());
        list.add(1, "choi");
        System.out.println(list.toString());
        list.addFirst("jung");
        System.out.println(list.toString());
        list.add(0, "hong");
        System.out.println(list.toString());

    }

    private class Node{
        String data;
        Node previous;
        Node next;
        private Node(String input, Node f, Node n) {
            data = input;
            previous = f;
            next = n;
        }
    }
}
