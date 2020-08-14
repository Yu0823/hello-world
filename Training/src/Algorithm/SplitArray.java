package Algorithm;

import java.util.ArrayList;

public class SplitArray {
    public int splitArray(int[] nums, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        while(list.size() > m){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int n : list){
                if(n < min2 && n < min1){
                    min2 = min1;
                    min1 = n;
                }
                else if(n < min2){
                    min2 = n;
                }
            }
            list.add(min1 + min2);
            list.remove(new Integer(min1));
            list.remove(new Integer(min2));
        }
        int max = -1;
        for(int n : list){
            if(n > max)
                max = n;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {3};
        System.out.println(new SplitArray().splitArray(a, 1));
    }
}
