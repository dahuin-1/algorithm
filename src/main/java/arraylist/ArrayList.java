package arraylist;


public class ArrayList {
    private int size = 0;
    private Object[] elementData = new Object[100];

    public ArrayList() {
    }

    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, Object element) {
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
    }

    public boolean addFirst(Object element) {
        add(0,element);
        return true;
    }

    public String toString() {
        String str = "[";
        for(int i=0; i<size; i++){
            str += elementData[i];
            if(i<size-1){
                str += ",";
            }
        }
        return str + "]";
    }

    public Object remove(int index) {
        // 엘리먼트를 삭제하기 전에 삭제할 데이터를 변수에 저장합니다.
        Object removed = elementData[index];
        for(int i = index+1; i < size-1; i++){
            elementData[i-1] = elementData[i];
        }
        elementData[index] = null;
        size--;
        return removed;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public Object get(int index) {
        return elementData[index];
    }

    public int size() {
        return size;
    }

    public Object indexOf(Object o) {
        //값이 있다면 그 값이 발견되는 첫번째 인덱스 값을 리턴
        // 값이 없다면 -1을 리턴
        for(int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;

    }

}