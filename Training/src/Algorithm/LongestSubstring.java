package Algorithm;

//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestSubstring(s, 1));
    }
    public static int longestSubstring(String s, int k) {
        int max = 0;
        for(int t = 1; t <= 26; t++){
            //t is the required total num of different characters
            int[] count = new int[26];
            int l_num = 0;//num of diff characters in substring
            int less = 0;//num of characters which's total is smaller than k
            int l = 0, r = 0;
            while(r < s.length()){
                count[s.charAt(r) - 'a']++;
                if(count[s.charAt(r) - 'a'] == 1){
                    //first in
                    l_num++;
                    less++;
                }
                if(count[s.charAt(r) - 'a'] == k){
                    less--;
                }
                while(l_num > t) {
                    count[s.charAt(l) - 'a']--;
                    if (count[s.charAt(l) - 'a'] == 0) {
                        l_num--;
                        less--;
                    }
                    if (count[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    l++;
                }
                if(less == 0){
                    max = Math.max(max, r - l + 1);
                }
                r++;
            }
        }
        return max;
    }
}
