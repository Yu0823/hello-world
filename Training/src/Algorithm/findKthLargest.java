package Algorithm;

import java.util.Arrays;

public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int r = quickSort(nums, 0, len - 1);
        if(r == len - k){
            return nums[r];
        }
        else if(r < len - k){
            if(r == len - 1)
                return nums[r];
            return findKthLargest(Arrays.copyOfRange(nums, r + 1, len), k);
        }
        else{
            if(r == 0)
                return nums[0];
            return findKthLargest(Arrays.copyOfRange(nums, 0, r), k - (len - r));
        }
    }

    public int quickSort(int[]a, int left, int right){
        int pivot = a[left];
        int j = left; //j is the pos to put the pivot
        for(int i = left + 1; i <= right; i++){
            if(a[i] < pivot){
                j++;
                swag(a, i, j);
            }
        }
        swag(a, j, left);

        return j;
    }

    public void swag(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(new findKthLargest().findKthLargest(a, 2));
    }
}
