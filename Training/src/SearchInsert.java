public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                break;
            }
        }
        if(i == nums.length){
            return nums.length;
        }
        else
            return i;
    }
    public static void main(String args[]){
        int[] a = {1,3,5,6};
        System.out.println(new SearchInsert().searchInsert(a,0));
    }
}
