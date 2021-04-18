package week6;

public class MyQueue2 {

        MyArrayList1 queue = new MyArrayList1(3);
        int front = 0;
        int rear = 0;

        public void enqueue(String data) {
            queue.add(rear, data);
            rear = queue.sizeOf();
        }
        public String dequeue() {
            if(front==rear)
                return null;
            else {
                String retVal = queue.remove(front);
                rear = queue.sizeOf();
                return retVal;
            }
        }
        public int sizeOf() {
            System.out.println("Array Size : "+queue.arrSize());
            return rear - front;
        }
        public void showQueue() {
            System.out.println(queue.toString());
        }

        public static void main(String[] args) {
            MyQueue2 q = new MyQueue2();
            q.enqueue("lee");
            q.enqueue("kim");
            q.enqueue("park");
            q.enqueue("choi");
            q.showQueue();

            System.out.println(q.sizeOf());
        }
    }

