import java.util.ArrayList;
import java.util.List;

public class Solve {
    int row;
    int col;
    char[][] board;
    int[][] record;//记录 扫过后记录为1
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        row = board.length;
        col = board[0].length;
        this.board = board;
        record = new int[row][col];
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                if(board[i][j] == 'O' && record[i][j] != 1){
                    List<int[]> DFSRecord = new ArrayList<>();
                    if(DFS(i, j, DFSRecord)){
                        for(int[] now : DFSRecord){
                            board[now[0]][now[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
    
    public boolean DFS(int i, int j, List<int[]> l){//可修改记录为true 不可修改记录为false
        record[i][j] = 1;
        System.out.println("" + i + " " + j);
        int[] now = {i, j};
        l.add(now);
        Boolean jud = true;
        if(i == 0 || j == 0 || i == row - 1 || j == col - 1)
            return false;
        else{
            if(i - 1 >= 0 && record[i - 1][j] == 0 && board[i - 1][j] == 'O'){
                boolean result = DFS(i - 1, j, l);
                if(jud)jud = result;
            }
            if(i + 1 < row && record[i + 1][j] == 0 && board[i + 1][j] == 'O'){
                boolean result = DFS(i + 1, j, l);
                if(jud)jud = result;
            }
            if(j - 1 >= 0 && record[i][j - 1] == 0 && board[i][j - 1] == 'O'){
                boolean result = DFS(i, j - 1, l);
                if(jud)jud = result;
            }
            if(j + 1 < col && record[i][j + 1] == 0 && board[i][j + 1] == 'O'){
                boolean result = DFS(i, j + 1, l);
                if(jud)jud = result;
            }
        }
        return jud;
    }

    public static void main(String[] args) {
        char[][] area = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};
        new Solve().solve(area);
        for(int i = 0; i < area.length; i ++) {
            for (int j = 0; j < area[0].length; j++)
                System.out.print(area[i][j]);
            System.out.println();
        }
    }
}
