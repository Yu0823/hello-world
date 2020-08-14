package Algorithm;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums.length == 1)
            return nums[0] == 1 ? 0 : 1;
        int left = 0, right = nums.length - 1, mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] != mid && (mid == 0 || nums[mid - 1] == mid - 1)){
                return mid;
            }
            else if(nums[mid] == mid){
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(new MissingNumber().missingNumber(a));
    }
}
