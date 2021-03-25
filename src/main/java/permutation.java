public class permutation { //반복을 이용한 방법

   public static void main(String[] args) {
        char[] arr = {'a','b','c'};
        per(arr,0,3,3);
    }

    public static void per(char arr[], int depth, int n, int r){
        if(depth == r) {
            print(arr,r);
            return;
        }
        for(int i = depth; i < n; i++){
            swap(arr,i,depth);
            per(arr,depth+1,n,r);
            swap(arr,i,depth);
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(char[] arr, int r) {
        for(int i = 0; i < r; i++){
            if(i==r-1)
                System.out.println(arr[i]);
            else
                System.out.print(arr[i]+",");
        }
    }
}
