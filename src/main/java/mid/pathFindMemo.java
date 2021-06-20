package mid;//60171620 김다흰
//2번 (2)

import java.util.Scanner;

public class pathFindMemo {

    static int count = 0;

    public static void main(String[] args) {
        pathFindMemo pfm = new pathFindMemo();
        int[][] arr = {{6,-7,12,-5,2,8},
                {0,-3,11,18,-1,6},
                {0,0,17,-3,5,-11},
                {0,0,0,-2,13,-4},
                {0,0,0,0,-9,10},
                {0,0,0,0,0,5}};
        System.out.println(pfm.pathFindbyM(arr));
        System.out.println("호출횟수는" + count);
    }

    public long pathFindbyM(int[][] arr) {
        int n = arr.length;
        long[][] memo = new long[n][n]; //memoization할 배열
       // memo[1][1] = arr[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                memo[i][j] = Math.max(memo[i][j - 1], Math.max(memo[i - 1][j - 1], memo[i - 1][j])) + arr[i][j];
                count++;
                /*
                arr[i][j]는 memo[i][j-1], memo[i-1][j-1]와 memo[i-1][j]중 큰 값과 더해져 memo[i][j]에 저장된다.
                (memo[i][j-1]는 대각선 왼쪽  memo[i-1][j-1]는 위쪽, memo[i-1][j] 왼쪽을 의미한다. )
                */
            }
        }
        return memo[n][n];
    }

    public long PathFindbyR(int[][] arr, int t) {

        for (int i = 1; i <= t; i++) {
            for (int j = i; j <= t; j++) {
                arr[i][j] = arr[i-1][j-1]>arr[i-1][j] ? arr[i][j] + arr[i-1][j-1]: arr[i][j] + arr[i-1][j];
                //시간이 부족해서 더이상 풀지 못했습니다
            }
        }

        return arr[t][t];
    }


}
