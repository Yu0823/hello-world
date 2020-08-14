package Algorithm;

public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = k - 1, count = 0, all = 0;
        for(int i = left; i <= right; i++){
            all = all + arr[i];
        }
        int val = k * threshold;
        int dif = all - val;
        if(dif >= 0)
            count++;
        while(right < arr.length - 1){
            left++;
            right++;
            if(arr[right] - arr[left - 1] + dif >= 0)
                count ++;
            dif = arr[right] - arr[left - 1] + dif;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2,2,2,2,5,5,5,8};
        System.out.println(new NumOfSubarrays().numOfSubarrays(a ,3 ,4));
    }
}
