package Algorithm;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1,6},{8,10},{15,18}};
        for(int[] row : merge(intervals))
            System.out.println("[" + row[0] + ", " + row[1] + "]");
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] ans = new int[intervals.length][2];
        ans[0] = intervals[0];
        int pos = 0;//pos of answer
        for(int i = 1; i < intervals.length; i++){
            if(ans[pos][1] >= intervals[i][1]){
                continue;
            }
            else if(ans[pos][1] >= intervals[i][0] && ans[pos][1] < intervals[i][1]){
                ans[pos][1] = intervals[i][1];
            }
            else{
                ans[pos + 1] = intervals[i];
                pos++;
            }
        }
        int[][] ansFinal = new int[pos + 1][2];
        for(int i = 0; i <= pos; i++){
            ansFinal[i] = ans[i];
        }
        return ansFinal;
    }
}
