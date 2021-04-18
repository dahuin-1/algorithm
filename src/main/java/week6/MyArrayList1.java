package week6;

public class MyArrayList1 {
    String[] array;
    int size;
    int numOfData;

    public MyArrayList1(int initSize) {
        size = initSize;
        array = new String[size];
        numOfData=0;
    }

    public String get(int index) {
        return array[index];
    }

    public void set(int index, String data) {
        array[index] = data;
    }

    public void addFirst(String data){
        add(0, data);
    }

    public void addLast(String data) {
        add(numOfData, data);
    }

    public void add(int index, String data){
       if(numOfData >= size){
           String[] bigArray = new String[size*2];
           for(int i = 0; i < size; i++)
               bigArray[i] = array[i];
           size *= 2;
           array = bigArray;
        }
        for(int j=numOfData-1; j>=index; j--)
            array[j+1] = array[j];

        array[index]=data;
        numOfData++;
    }

    public String remove(int index) {
       if(index<0)
           return null;
       String retVal = array[index];
       for (int i =  index+1; i <numOfData; i++)
           array[i-1] = array[i];
       numOfData--;
       return retVal;
    }

    public int remove(String data) {
       int index = indexOf(data);
       remove(index);
       return index;
    }

    private int indexOf(String data){
        for(int i=0; i<numOfData; i++)
            if(array[i]==data)
                return i;
        return -1;
    }

    public int sizeOf() {
        return numOfData;
    }
    public int arrSize() {
        return size;
    }

    public void sort() {
        for(int i=numOfData-1; i>0; i--) {
            for (int j=0; j<i; j++){
                if(array[j].compareTo(array[j+1])>0){
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public String toString() {
       String str = "[";
       for(int i=0; i<numOfData; i++) {
           str += array[i] ;
           if (i < numOfData - 1) {
               str += ",";
           }
       }
        return str + "]";
    }

    public static void main(String[] args) {
        MyArrayList1 list = new MyArrayList1(3);

        list.add(list.sizeOf(), "lee");
        list.add(list.sizeOf(), "kim");
        System.out.println(list.toString());
        System.out.println("Current Max.Size"+list.arrSize());

        list.add(1,"choi");
        System.out.println("current max. size : "+list.arrSize());
        list.add(1,"jung");
        list.add(0,"hong");
        System.out.println(list.toString());

        System.out.println(list.toString());
    }
}












