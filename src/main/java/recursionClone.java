public class recursionClone {

    int[] data;

    public recursionClone(int[] data) {
        this.data = data; //input이라는 매개변수를 쓰지 않고 data를 초기화해서 사용
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < data.length; i++) {
            str += data[i];
            if(i < data.length-1){
                str += ", "; //쉼표추가
            }
        }
        return str;
    }

    public int getIndexOfMaxValWithIter() {
        if (data.length < 1) { //값이 없으면
            return -1; //-1을 리턴
        }
        int index = 0;
        int max = data[0];
        int i = 1;
        while (i < data.length) {
            if (data[i] > max) {
                max = data[i];
                index = i;
            }
            i++;
        }
        return index;
    }

    public int getIndexOfMaxValWithRec(int head) {
        if (head == (data.length - 1)) {
            return head;
        }
        int temp = getIndexOfMaxValWithRec(head + 1);
        if (data[head] > data[temp]) {
            return head;
        } else {
            return temp;
        }
    }

    public int searchIndex(int val) { //인덱스 넘버를 출력하는 메소드
        int i = 0;
        while (i < data.length) {
            if (data[i] == val) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int searchLocation(int val) { //index+1인 실제 위치를 출력하는 메소드
        int i = 0;
        while (i < data.length) {
            if (data[i] == val) {
                return i+1;
            }
            i++;
        }
        return -1;
    }

    public int searchLocByIndex(int val, int index) { //인덱스를 통해서 value 찾기
        if (index == data.length) {
            return -1;
        }
        if (data[index] == val) {
            return index;
        } else {
            return searchLocByIndex(val, index + 1);
        }
    }

    public int searchLocByPivot(int val, int start, int end) { //중간 값을 통해서 value 찾기
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(data[mid]==val){
            return mid;
        }else if (data[mid]<val){
            return searchLocByPivot(val,start,mid-1);
        }else{
            return searchLocByPivot(val,mid+1,end);
        }
    }

    public static void main(String[] args) {
        int[] data = {12,36,23,55,1,76,42,69};
        recursionClone rc = new recursionClone(data);
        System.out.println(rc.toString());
        System.out.println(rc.getIndexOfMaxValWithIter());
        System.out.println(rc.getIndexOfMaxValWithRec(0));
        int val = 42;
        System.out.println("Index of "+ val+" : "+rc.searchIndex(42));
        System.out.println("Loc. of "+ val+" : "+rc.searchLocation(42));
        System.out.println("Index of "+ val+" : "+rc.searchLocByIndex(42,0));
        System.out.println("Index of "+ val+" : "+rc.searchLocByPivot(42,0,7));
    }
}
