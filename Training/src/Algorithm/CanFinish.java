package Algorithm;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] m = new int[numCourses][numCourses];
        for(int[] arc: prerequisites){
            m[arc[0]][arc[1]] = 1;
        }
        int[] out = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int j = 0; j < numCourses; j++){
                if(m[j][i] != 0)
                    out[i] ++;
            }
        }
        int countZero = 0;
        for(int n : out){
            if(n == 0){
                countZero++;
            }
        }
        while (countZero != 0){
            countZero = 0;
            for(int j = 0; j < numCourses; j++){
                //for every node that out degree is zero
                if(out[j] == 0){
                    //every node that has prerequisites with this node
                    for(int i = 0; i < numCourses; i++){
                        if(m[j][i] != 0){
                            out[i] --;
                            if(out[i] == 0)
                                countZero++;
                        }
                        out[j]--;
                    }
                }
            }
        }
        for(int n : out){
            if(n >= 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{1,0},{0,1}};
        System.out.println(new CanFinish().canFinish(2,a));
    }
}
