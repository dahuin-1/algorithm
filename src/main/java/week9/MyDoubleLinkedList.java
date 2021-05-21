package week9;

import java.util.Arrays;
import java.util.Comparator;

class MyDoubleLinkedList<T> {

    private Node<T> head, tail;

    public MyDoubleLinkedList() {
        head = null;
        tail = null;
    }

    public T get(int index) {
        if(!validIndex(index))
            return null;
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    private boolean validIndex(int index) {
        if (index<sizeOf() && index>=0)
            return true;
        else
            return false;
    }

    public void set(int index, T data) {
        if(!validIndex(index))
            return;
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data, null, head);
        head = newNode;
        if(tail == null)
            tail = newNode;
        else
            head.next.pre = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data, tail, null);
        tail = newNode;
        if(head==null)
            head=newNode;
        else
            tail.pre.next = newNode;
    }

    public void add(int index, T data) {
        //구현결과
        if(index==0)
            addFirst(data);
        else if (index == sizeOf())
            addLast(data);
        else {
            if (!validIndex(index))
                return;
            Node temp = head;
            int i = 1;
            while (i < index) {
                temp = temp.next;
                i++;
            }
            Node<T> newNode = new Node<>(data, temp, temp.next);
            newNode.pre.next=newNode;
            newNode.next.pre=newNode;
        }
    }

    public T removeFirst() {
        if(head != null) {
            T retVal = head.data;
            head = head.next;
            if(head!=null)
                head.pre = null;
            else
                tail = null;
            return retVal;
        }
        else
            return null;
    }

    public T removeLast() {
        if(tail!=null) {
            T retVal = tail.data;
            tail = tail.pre;
            if(tail!=null)
                tail.next = null;
            else
                head = null;
            return retVal;
        }
        else
            return null;
    }

    public T remove (int index) {
        if(!validIndex(index))
            return null;
        if(index==0)
            return removeFirst();
        else if(index==sizeOf()-1)
            return removeLast();
        else {
            Node<T> temp = head.next;
            int i = 1;
            while (i<index) {
                temp = temp.next;
                i++;
            }
            T retVal = temp.data;
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;

            return retVal;
        }
    }

    public int remove(T data){
        int index = indexOf(data);
        remove(index);
        return index;
    }

    private int indexOf(T data) {
        /* Node temp = head;
        for(int i=0; i<sizeOf(); i++) {
            if(temp.data.compareTo(data)==0)
                return i;
            temp = temp.next;
        }
        return -1;*/
        int index = 0;
        for(Node<T> x = head; x != null; x = x.next) {
            if(data.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int sizeOf() {
        return sizeOf(head);
    }

    private int sizeOf(Node<T> link) {
        if(link==null)
            return 0;
        else
            return 1+sizeOf(link.next);
    }

    public Object[] toArray() {
        Object[] array = new Object[sizeOf()];
        int idx = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            array[idx++] = (T) x.data;
        }
        return array;
    }

  /*private Node<T> findMin(Node<T> temp) {
        Node<T> min = temp;
        while (temp.next != null) {
            temp = temp.next;
            //if(temp.data.compareTo(min.data)>0)
            if (compare(temp.data, min.data) > 0) {
                //min = temp;
                T temp = temp.data;
            }
            return min;
        }
    }*/

    public String toString() {
        Node<T> temp = head;
        String retVal = "";
        while (temp != null) {
            retVal=retVal+"/"+temp.data.toString();
            temp = temp.next;
        }
        return retVal;
    }

    public static void main(String[] args) {
        MyDoubleLinkedList<String> list1 = new MyDoubleLinkedList<>();
        list1.addLast("lee");
        System.out.println(list1.toString());
        list1.addFirst("kim");
        System.out.println(list1.toString());
        list1.addLast("park");
        System.out.println(list1.toString());
        list1.add(1,"choi");
        System.out.println(list1.toString());
        list1.addFirst("jung");
        System.out.println(list1.toString());
        list1.add(0,"hong");
        System.out.println(list1.toString());
    }

    private class Node<T> {
        private T data;
        private Node<T> pre;
        private Node<T> next;

        private Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }
}
