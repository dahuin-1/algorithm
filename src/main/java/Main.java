public class Main {
    public static void main(String[] args) {
        int N = 4;
        int[][] dp = new int[4][4]; //4*4배열 선언
        int[][] map = {
                {6, 7, 12, 5},
                {5, 3, 11, 18},
                {9, 17, 3, 3},
                {8, 10, 14, 9}
        };
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + map[0][i];
            dp[0][i] = sum;
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + map[i][0];
            dp[i][0] = sum;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + map[i][j];
            }
        }
        System.out.println("최대값 " + dp[N - 1][N - 1]);
    }
}