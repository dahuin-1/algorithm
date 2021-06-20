package mid;

public class PathTriangle {
    int[][] matrix;
    int[][] memo;
    int nOfCalls;

    public PathTriangle(int[][] input) {
        matrix=input;
        nOfCalls=0;
    }

    public int maxPathWeight(int row, int col) {
        nOfCalls++;
        if (row==0 && col==0)
            return matrix[row][col];
        else if (row==0)
            return matrix[row][col]+maxPathWeight(row, col-1);
        else if (row==col)
            return matrix[row][col]
                    +Math.max(maxPathWeight(row-1, col),maxPathWeight(row-1, col-1) );
        else
            return matrix[row][col]
                    +Math.max(Math.max(maxPathWeight(row, col-1),maxPathWeight(row-1, col)),maxPathWeight(row-1, col-1) );

    }

    public int nCalls() {
        return nOfCalls;
    }

    private void printMatrix(int [][] data, int row, int col) {
        for (int i=0; i<=row;i++) {
            System.out.println();
            for (int j=0; j<=col;j++)
                System.out.print(data[i][j]+"  ");
        }
        System.out.println();
    }
    public void initMemo() {
        nOfCalls=0;
        int n=matrix.length;
        memo=new int[n][n];
        System.out.println("\n<< Init. Memo. >>");
        printMatrix(memo, n-1, n-1);
    }
    public int maxPathWeight2(int row, int col) {
        nOfCalls++;

        if (row==0 && col==0) {
            if (memo[row][col]==0)
                memo[row][col]= matrix[row][col];
            printMatrix(memo, 5, 5);
            return memo[row][col];
        }
        else if (row==0) {
            if (memo[row][col]==0)
                memo[row][col]= matrix[row][col]+maxPathWeight2(row, col-1);
            printMatrix(memo, 5, 5);
            return memo[row][col];
        }
        else if (col==row) {
            if (memo[row][col]==0)
                memo[row][col]= matrix[row][col]
                        +Math.max(maxPathWeight2(row-1, col),maxPathWeight2(row-1, col-1) );
            printMatrix(memo, 5, 5);
            return memo[row][col];
        }
        else{
            if (memo[row][col]==0)
                memo[row][col]= matrix[row][col]
                        +Math.max(Math.max(maxPathWeight2(row, col-1),maxPathWeight2(row-1, col)),maxPathWeight2(row-1, col-1) );
            printMatrix(memo, 5, 5);
            return memo[row][col];
        }
    }

    public static void main(String[] args) {
        int nDim = 6;
        int [][] matrix = {{6,-7,12,-5,2,8},
                {0,-3,11,18,-1,6},
                {0,0,17,-3,5,-11},
                {0,0,0,-2,13,-4},
                {0,0,0,0,-9,10},
                {0,0,0,0,0,5}};
        PathTriangle pf = new PathTriangle(matrix);
        System.out.println(pf.maxPathWeight(nDim-1, nDim-1)+"("+pf.nCalls()+")");
        pf.initMemo();
        System.out.println(pf.maxPathWeight2(nDim-1, nDim-1)+"("+pf.nCalls()+")");

    }

}
