package Algorithm;

public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        String ans = null;
        int max = -1;
        int center = 0;
        int left, right;
        while (center < s.length()) {
            left = right = center;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    ans = s.substring(left, right + 1);
                    max = right - left + 1;
                }
                left--;
                right++;
            }
            left = right = center;
            if (right + 1 == s.length())
                break;
            right++;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > max) {
                    ans = s.substring(left, right + 1);
                    max = right - left + 1;
                }
                left--;
                right++;
            }
            center++;
        }
        return ans;
    }
}