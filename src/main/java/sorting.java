import java.util.ArrayList;

public class sorting {

    static long count_r = 0;
    static long count_f = 0;

    public static void main(String[] args) {
        sorting s = new sorting();
        int[] result;
        int[] arr = {7,3,4,2,5,10};
        result = s.sort_for(arr);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println("카운트"+count_f);
        //System.out.println(result);
    }

    public void sort_recursion() {

    }

    public int[] sort_for(int[] arr) {
        int temp;
        int[] tempArr = new int[arr.length]; //답을 담을 배열 선언
        for(int i=0; i<arr.length; i++){
            tempArr[i] = arr[i]; //위에서 받은 배열을 새 배열에 담는다.
        }
        for(int i = 0; i<tempArr.length; i++) {
            for(int j = 0; j<tempArr.length-i-1; j++) {
                count_f++;
                if(tempArr[j] < tempArr[j+1]) {
                    temp = tempArr[j]; //swap
                    tempArr[j] = tempArr[j+1];
                    tempArr[j+1] = temp;
                }
            }
        }
      return tempArr;

    }
}
