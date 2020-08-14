package Algorithm;

public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int[] origin = nums.clone();
        if(nums.length == 1)
            return 0;
        int odd = 0, even = 0;
        //odd代表奇数位大, even代表偶数位大
        for(int i = 0; i < nums.length; i = i + 2){
            if(i == 0){
                if(nums[i] <= nums[i + 1]){
                    even = even + (nums[i + 1] - nums[i] + 1);
                    nums[i + 1] = nums[i] - 1;
                }
            }
            else if(i == nums.length - 1){
                if(nums[i] <= nums[i - 1]){
                    even = even + (nums[i - 1] - nums[i] + 1);
                    nums[i - 1] = nums[i] - 1;
                }
            }
            else{
                if(nums[i] <= nums[i + 1]){
                    even = even + (nums[i + 1] - nums[i] + 1);
                    nums[i + 1] = nums[i] - 1;
                }
                if(nums[i] <= nums[i - 1]){
                    even = even + (nums[i - 1] - nums[i] + 1);
                    nums[i - 1] = nums[i] - 1;
                }
            }
        }
        nums = origin;//从头再来！
        for(int i = 1; i < nums.length; i = i + 2){
            if(i == nums.length - 1){
                if(nums[i] <= nums[i - 1]){
                    odd = odd + (nums[i - 1] - nums[i] + 1);
                    nums[i - 1] = nums[i] - 1;
                }
            }
            else{
                if(nums[i] <= nums[i + 1]){
                    odd = odd + (nums[i + 1] - nums[i] + 1);
                    nums[i + 1] = nums[i] - 1;
                }
                if(nums[i] <= nums[i - 1]){
                    odd = odd + (nums[i - 1] - nums[i] + 1);
                    nums[i - 1] = nums[i] - 1;
                }
            }
        }
        System.out.println(even + " " + odd);
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        int[] a = {9, 6, 1, 6, 2};
        System.out.println(new MovesToMakeZigzag().movesToMakeZigzag(a));
    }
}
