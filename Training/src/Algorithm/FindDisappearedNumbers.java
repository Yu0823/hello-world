package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {

    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int pos = -1;
        List ans = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            pos = Math.abs(nums[i]) - 1;
            if(nums[pos] >= 0){
                nums[pos] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
