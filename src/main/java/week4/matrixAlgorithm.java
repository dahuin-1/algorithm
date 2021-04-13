/*public class matrixAlgorithm {
    int[][] matrix;
    int[][] memo;
    int nOfCalls;

    public matrixAlgorithm(int[][] matrix) {
        this.matrix = matrix;
        this.nOfCalls = 0;
    }

    public int maxPathWeight(int row, int col) {
        nOfCalls++;
        if(row==0 && col==0){
            return matrix[row][col];
        }else if (row==0){
            return matrix[row][col]+maxPathWeight(row, col-1);
        }else if(col==0)
            return matrix[row][col]+maxPathWeight(row-1,col);
        else
            return matrix[row][col]
            +Math.max(maxPathWeight(row,col-1),maxPathWeight(row-1,col));
    }

    public int nCalls() {
        return nOfCalls;
    }

    public int mPWIteration(int row, int col) {
        int[][] accWeight = new int[row+1][col+1];
        accWeight[0][0]=matrix[0][0];
        for(int i = 1; i <= row; i++)
            accWeight[i][0] = matrix[i][0]+accWeight[i-1][0];
        for(int i = 1; i <= col; i++)
            accWeight[0][i] = matrix[0][i]+accWeight[0][i-1];
        for(int depth = 1; depth <= Math.min(row,col); depth++) {
            for (int i = depth; i <= row; i++)
                accWeight[i][depth] = matrix[i][depth] + Math.max(accWeight[i-1][depth-1]);
            for (int i = 1; i <= col; i++)
                accWeight[depth][i] = matrix[depth][i] + Math.max(accWeight[depth-1][i-1]);
        }
        printMatrix(accWeight,row,col);
        return accWeight[row][col];
    }

    private void printMatrix(int [][] data, int row, int col) {
        for (int i = 0; i <= row; i++) {
            System.out.println();
            for (int j = 0; j <= col; j++)
                System.out.println(data[i][j]+" ");
        }
        System.out.println();
    }
    public void initMemo() {
        nOfCalls = 0;
        int n = matrix.length;
        memo = new int[n][n];
        printMatrix(memo,n-1,n-1);
    }
    public int maxPathWeight2(int row, int col){
        nOfCalls++;

        if(row==0 && col==0){
            if(memo[row][col]==0)
                memo[row][col] = matrix[row][col];
            return memo[row][col];
        }
        else if (row==0) {
            if(memo[row][col]==0)
                memo[row][col] = matrix[row][col]+maxPathWeight2(row,col-1);
            return memo[row][col];
        } else if (col==0) {
            if (memo[row][col] == 0)
                memo[row][col] = matrix[row][col] + maxPathWeight2(row-1,col);
            return memo[row][col];
        } else {
            if (memo[row][col] == 0)
                memo[row][col] = matrix[row][col]
                        + Math.max(maxPathWeight2(row, col - 1), maxPathWeight2(row-1, col));
            return memo[row][col];
        }
    }

    public static void main(String[] args) {
        int nDim = 4;
        int [][] matrix = {{6,7,12,5},
                {5,3,11,18},
                {0,17,3,3},
                {8,10,14,9}};
        matrixAlgorithm matrixAlgorithm = new matrixAlgorithm(matrix);
        System.out.println(matrixAlgorithm.maxPathWeight(nDim-1,nDim-1)+"("+matrixAlgorithm.nCalls()+")");
        }
    }*/

