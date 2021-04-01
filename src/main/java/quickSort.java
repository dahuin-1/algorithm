public class quickSort {

    public int[] quickSort(int[] data, int l, int r) { //변수 이름을 left의 l right의 r로 변경
        if(l<r) {
            int q = partition(data,l,r);
            quickSort(data,l,q-1);
            quickSort(data,q+1,r);
        }
        return data;
    }

    private int partition(int[] data, int l, int r) {
        int pivot = r;
        int left = l;
        int right = r;

        while(left<right) {
            while (data[left]<data[pivot] && left<right) left++;
            while (data[right]>data[pivot] && left<right) right--;
            if(left<right) swapData(data,left,right);
        }
        swapData(data,pivot,right);
        return right;
    }

    private void swapData(int[] data, int i, int j){
        int temp = data[i];
        data[i] =  data[j];
        data[j] =  temp;
    }

    public static void main(String[] args) {
        int[] data = {12,21,15,32,22,9,11,33,41,27};
        int[] sortedData; //불필요한 초기화 삭제
        quickSort sort = new quickSort();
        sortedData = sort.quickSort(data,0,data.length-1);
        for(int i = 0; i < sortedData.length; i++){
            System.out.print(sortedData[i]+ " ");
        }
    }
}
