import java.util.Arrays;

public class sorting {

    static long count_r = 0;
    static long count_f = 0;

    public static void main(String[] args) {
        sorting s = new sorting();
        int[] result;
        int[] arr = {1, 30, 9, 5, 7, 3, 4, 2, 5, 10};
        int[] data = arr.clone();
        s.sort_recursion(data, 0, data.length - 1);
        result = s.sort_for(arr);
        String str = "";
        for (int i = 0; i < result.length; i++) {
            str += result[i];
            if (i != result.length - 1) {
                str += ",";
            }
        }
        //System.out.println(str);
        System.out.println(Arrays.toString(result));
        System.out.println("count : (iteration) : " + count_f);
        System.out.println(Arrays.toString(data));
        System.out.println("count : (recursion/QuickSort) : " + count_r);
    }

    public void sort_recursion(int data[], int l, int r) {
        int left = l;
        int right = r;
        int pivot = data[(l + r) / 2];
        do {
            count_r++;
            while (data[left] > pivot) left++;
            while (data[right] < pivot) right--;
            if (left <= right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);
        if (l < right) sort_recursion(data, left, r);
        if (r > left) sort_recursion(data, l, right);
    }


    public int[] sort_for(int[] arr) {
        int temp;
        int[] tempArr = new int[arr.length]; //답을 담을 배열 선언
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i]; //위에서 받은 배열을 새 배열에 담는다.
        }
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr.length - i - 1; j++) {
                count_f++;
                if (tempArr[j] < tempArr[j + 1]) { // 큰 값이 작은 값보다 뒤에 있다면
                    temp = tempArr[j]; //swap
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = temp;
                }
            }
        }
        return tempArr;
    }
}
