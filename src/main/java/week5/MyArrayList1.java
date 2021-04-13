package week5;

public class MyArrayList1 {
    int initSize = 0;
    String[] array;
    int size;
   // int numOfData;

    public MyArrayList1() {
        size = initSize;
        array = new String[size];
       // numOfData=0;
    }

    public String get(int index) {
        return array[index];
    }

    public void add(int index, String data){
        //추가된 자리 바로 뒷 자리부터 끝까지 오른쪽으로 한칸씩 옮김
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //값을추가
        array[index] = data;
        //사이즈++
        size++;

    }
    public String remove(int index) {
        // 엘리먼트를 삭제하기 전에 삭제할 데이터를 변수에 저장!.
        String removed = array[index];
        //추가된 자리 바로 뒷 자리부터 끝까지 왼쪽으로 한칸씩 당김
        for(int i = index+1; i < size-1; i++){
            array[i-1] = array[i];
        }
        //값을 명시적으로 지워줌
        array[index] = null;
        //사이즈--;
        size--;
        //삭제된 데이터 리턴
        return removed;
    }

    public int remove(String data) {
        //데이터 검색 후 인덱스 출력
        for(int i=0; i<size; i++){
            if(array[i].equals(data)){
                array[i] = null;
                size--;
                return i;
            }
        }
        //값이 없다면 -1출력
        return -1;
    }

    public int sizeOf() {
        return size;
    }
    public int arrSize() {
        return size;
    }
    public String toString() {
        //자바 내의 toString() 메소드를 사용한 것처럼 수정
        String str = "[";
        for(int i=0; i<size; i++){
            str += array[i];
            if(i<size-1){
                str += ",";
            }
        }
        return str + "]";
    }

    public static void main(String[] args) {
        MyArrayList1 list = new MyArrayList1();

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
