import java.util.Arrays;

public class permutationClone {

    char[] data;
    int numberOfPatterns;

    public permutationClone(char[] data) {
        this.data = data; //input이라는 변수를 새로 쓰지 않고 data를 초기화해서 사용
    }

    public void permWithFunc() { //3중 포문이 아닌 메소드를 이용한 permutation
        int size = data.length;
        numberOfPatterns = 0;
        swapfrom0(size);
    }

    public void swapfrom0(int size) {
        for (int i = 0; i < size; i++) {
            swap(data,0, i);
            swapfrom1(size);
        }
    }
    public void swapfrom1(int size) {
        for (int k = 1; k < size; k++) {
            swap(data,1, k);
            swapfrom2(size);
        }
    }

    public void swapfrom2(int size) {
        for (int z = 2; z < size; z++) {
            swap(data,2, z);
            numberOfPatterns++;
            System.out.print(numberOfPatterns + " : ");
            System.out.println(data);
            swap(data,3, 4);
            numberOfPatterns++;
            System.out.println(numberOfPatterns + " : " + toString());
        }
    }

    public void permWithIter() {
        int size = data.length;
        numberOfPatterns = 0;
        for (int i = 0; i < size; i++) {
            swap(data,0, i);
            for (int k = 1; k < size; k++) {
                swap(data,1, k);
                for (int z = 2; z < size; z++) {
                    swap(data,2, z);

                    numberOfPatterns++;
                    System.out.println(numberOfPatterns + " : " + toString());
                    swap(data,3, 4);
                    numberOfPatterns++;
                    System.out.println(numberOfPatterns + " : " + toString());

                    swap(data,3, 4);
                    swap(data,2, k);
                }
                swap(data,1, k);
            }
            swap(data,0, i);
        }
    }

   public void swap(char[] data, int i, int j) {
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    //같은 이름과 기능을 갖는 메소드가 두개일 필요는 없을것 같아서 하나로 통일

    public void permRecursion(char[] input, String str) {
        if (input.length == 1) { //배열의 길이가 1이라면, 즉 배열에 들어있는 값이 하나라면
            System.out.println(numberOfPatterns+1 + " " + str + input[0]); //출력 (1번부터 넘버링)
            numberOfPatterns++;
        }
        for (int i = 0; i < input.length; i++) {
            swap(input, 0, i); //swap
            str += input[0];
            permRecursion(Arrays.copyOfRange(input, 1, input.length), str);
            //input[1]부터 input[]의 길이 만큼 copy한 array를 매개변수로 가지고 permRecursion을 돌림
            //input[0]은 77번째 줄에서 str에 추가되었기 때문에, input[0]부터 시작.
            //배열의 모든 값이 str에 추가될때까지 반복
            str = str.substring(0, str.length() - 1);
        }
    }

    public void permRecursion() {
        permRecursion(this.data, "");
    }

    public String toString() {
        String str = "";
        for(int i=0; i<data.length; i++){
            str += data[i];
        }
        return str;
    }

    public static void main(String[] args) {
        char data[] = {'a','b','c','d','e'};
        permutationClone pc = new permutationClone(data);
        //pc.permRecursion();
       //pc.permWithFunc();
        pc.permWithIter();
    }

}
