package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        int length = s.length();
        if(length == 0)
            return 0;
        else if(length == 1)
            return 1;
        char[] array = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        //right is the next
        while(right < length){
            if(!set.contains(array[right])){
                set.add(array[right]);
            }
            //duplicate letter
            else{
                while(array[left] != array[right]){
                    set.remove(array[left]);
                    left++;
                }
                left++;
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
    }
}

