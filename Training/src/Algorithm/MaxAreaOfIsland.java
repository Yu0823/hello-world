package Algorithm;

public class MaxAreaOfIsland {
    int max, row, col;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        max = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    int result = DFS(i, j, grid);
                    if(result > max)
                        max = result;
                }
            }
        return max;
    }

    public int DFS(int i, int j, int[][] grid) {
        int count = 1;
        grid[i][j] = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            if (i + d[0] >= 0 && i + d[0] < row && j + d[1] >= 0 && j + d[1] < col && grid[i + d[0]][j + d[1]] == 1) {
                count = count + DFS(i + d[0], j + d[1], grid);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] a = {
                {0,1,0},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(a));
    }
}
