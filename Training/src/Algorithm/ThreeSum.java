package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3)
            return result;
        Arrays.sort(nums);
        int left, right;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0){
                return result;
            }
            else if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int sum = 0;
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                }
                else if(sum > 0){
                    right--;
                }
                else if(sum == 0){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    result.add(ans);
                    while(left + 1 < nums.length - 1 && nums[left] == nums[left + 1])
                        left++;
                    left++;
                    while(right - 1 > i && nums[right] == nums[right - 1])
                        right--;
                    right--;
                }
            }
        }
        return result;
    }
}
