public class factorial {

    static long count_r = 0;
    static long count_f = 0;

   public static void main(String[] args) {
       factorial f = new factorial();
       long val;

       for(int i=5; i<30; i++) {
           val = f.fact_for(i);
           System.out.print("n= "+i+",value= "+ val + " count : (iteration)" + count_f);
           val = f.fact_recursion(i);
           System.out.println(" (recursion) :" + count_r);
       }
    }
    public long fact_recursion(int n){ //재귀(recursion)를 이용한 팩토리얼 구현
       count_r++;
        if(n <= 1){
            return 1;
        }
        return fact_recursion(n-1) * n;
    }
    public long fact_for(int n) { //반복(for)을 이용한 팩토리얼 구현
        int result = 1;
        for(int i = 1; i < n; ++i){
            count_f++;
            result *= i+1;
        }
        return result;
    }
}


