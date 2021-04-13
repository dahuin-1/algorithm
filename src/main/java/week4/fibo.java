package week4;

import java.util.Scanner;

public class fibo {
    static long array[];
    //1 1 2 3 5 8 13 21 34 55 89
    public static void main(String[] args) {
        array = new long[101];
        // int rst = fibo_recursion(4);
        System.out.println("몇번째 피보나치 수를 알고싶나요?");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(fibo_memoization(a));
    /*    long rst = 0;
        for(int i = 0; i < a; i++){
           rst = rst + array[i];
            System.out.println(array[i]);
        }
        System.out.println(a+"까지의 합은 : "+rst);*/
    }
    public static int fibo_recursion(int a) {
        if (a == 1 || a == 2) {
            return 1;
        } else {
            return fibo_recursion(a - 2) + fibo_recursion(a - 1);
        }
    }
    public static long fibo_memoization(int a) {
        if (a <= 1) {
            return a;
        }else if (array[a] != 0) {
            return array[a];
        }else{
            return array[a] = fibo_recursion(a-1)+fibo_recursion(a-2);
        }
    }
}


