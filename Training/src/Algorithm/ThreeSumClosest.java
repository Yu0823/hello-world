package Algorithm;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] num = {-1,2,1,-4};
        System.out.println(threeSumClosest(num, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left, right;
        int sumNow = 0;
        int ansNow = 0;
        boolean getAns = false;
        for(int i = 0; i < nums.length - 2; i++){
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                sumNow = nums[i] + nums[left] + nums[right];
                if(!getAns){
                    //if it's the first time
                    getAns = true;
                    ansNow = sumNow;
                }
                else if(Math.abs(target - ansNow) > Math.abs(target - sumNow)){
                    ansNow = sumNow;
                }
                if(target - sumNow > 0){
                    //the sum is less than the target
                    left++;
                }
                else if(target - sumNow < 0){
                    //the sum is larger than the target
                    right--;
                }
                else
                    return sumNow;
            }
        }
        return ansNow;
    }
}
