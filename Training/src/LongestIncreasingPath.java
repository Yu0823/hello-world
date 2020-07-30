public class LongestIncreasingPath {
    int [][] memo;
    int row, col;
    int[][] m;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix;
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        row = matrix.length;
        col = matrix[0].length;
        memo = new int[matrix.length][matrix[0].length];
        int max = 0, rm = 0, cm = 0;
        for(int[] r : memo)
            for(int n : r)
                n = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++){
                if(max < DFS(i, j)) {
                    max = DFS(i, j);
                    rm = i;
                    cm = j;
                }
            }
//        System.out.println("Ans:" + rm + " " + cm);
        System.out.println(max);
        return max;
    }
    public int DFS(int i, int j){
        if(memo[i][j] != 0)
            return memo[i][j];
//        System.out.println("DFS:" + i + " " + j);
        memo[i][j]++;
        int max = 0;
        if(i - 1 >= 0 && m[i - 1][j] > m[i][j])
            if(DFS(i - 1, j) > max ) {
                max = DFS(i - 1, j);
            }
        if(j - 1 >= 0 && m[i][j - 1] > m[i][j])
            if(DFS(i , j - 1) > max) {
                max = DFS(i, j - 1);
            }
        if(j + 1 < col && m[i][j + 1] > m[i][j])
            if(DFS(i , j + 1) > max) {
                    max = DFS(i, j + 1);
            }
        if(i + 1 < row && m[i + 1][j] > m[i][j])
            if(DFS(i + 1 , j ) > max) {
                max = DFS(i + 1, j);
            }
        memo[i][j] = max + 1;
        return memo[i][j];
    }
    public static void main(String[] args) {
        int[][] a = {{1,2}};
//        int[][] a = {{3,4,5},{3,2,6},{2,2,1}};
        int r = new LongestIncreasingPath().longestIncreasingPath(a);
//        System.out.println(r);
    }
}
