package week6;

public class MyQueue3<T> {

    int qSize = 5;
    T[] queue = (T[])new Object[qSize];
    int front = 0;
    int rear = 0;

    public boolean enqueue(T data) {
        if ((rear + 1) % qSize == front)
            return false;
        else {
            queue[rear] = data;
            rear = (rear + 1) % qSize;
            return true;
        }
    }
    public T dequeue() {
        if (front == rear)
            return null;
        else {
            T retVal = queue[front];
            queue[front] = null;
            front = (front + 1) % qSize;
            return retVal;
        }
    }
    public int sizeOf() {
        System.out.println("Array Size : " + queue.length);
        return (rear >= front) ? (rear - front) : (rear - front + qSize);
    }
    public void showQueue() {
        for (int i = 0; i < qSize; i++)
            System.out.print(queue[i] + " - ");
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue3 q = new MyQueue3();
        q.enqueue("lee");
        q.enqueue("kim");
        q.enqueue("park");
        q.enqueue("choi");
        q.showQueue();

        System.out.println(q.sizeOf());

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue("lee");
        q.enqueue("kim");
        q.enqueue("park");
        q.enqueue("choi");
        q.showQueue();

        System.out.println(q.sizeOf());
    }
}


