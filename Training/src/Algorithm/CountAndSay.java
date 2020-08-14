package Algorithm;

import java.util.Scanner;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        else{
            return des(countAndSay(n - 1));
        }
    }
    public static String des(String s){
        String r = "";
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            int value = Integer.valueOf(s.charAt(i)) - 48;
            if(i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)){
                count++;
            }
            else{
                r = r + (count + 1) + value;
                count = 0;
            }
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(new CountAndSay().countAndSay(n));
    }
}
