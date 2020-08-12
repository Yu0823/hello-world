import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] a = s.toCharArray();
        int left = 0, right = 1, max = 0;
        if(a.length == 0)
            return 0;
        set.add(a[0]);
        int now = 1;
        while(true){
            while(right < a.length && !set.contains(a[right])){
                set.add(a[right]);
                right++;
                now++;
            }
            max = Math.max(now, max);
            if(right == a.length)
                break;
            else{
                set.remove(a[left]);
                left++;
                now--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}

