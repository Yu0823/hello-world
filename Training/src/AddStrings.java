import com.sun.deploy.util.ArrayUtil;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l = Math.max(l1, l2) + 1;
        char[] a = new char[l];
        int up = 0;
        for(int i = 1; i <= Math.max(l1, l2); i ++){
            if(l1 - i >= 0 && l2 - i >= 0)
                a[l - i] = (char) ('0' + (num1.charAt(l1 - i) - '0') + (num2.charAt(l2 - i) - '0'));
            else if(l1 - i >= 0)
                a[l - i] = num1.charAt(l1 - i);
            else
                a[l - i] = num2.charAt(l2 - i);
            if(up != 0) {
                a[l - i]++;
                up = 0;
            }
            if(a[l - i] > '9'){
                a[l - i] -= 10;
                up++;
            }
        }
        if(up != 0)
            a[0] = '1';
        if (a[0] <= '9' && a[0] >= '0')
            return String.valueOf(a);
        else
            return String.valueOf(a).substring(1);
    }

    public static void main(String[] args) {
        System.out.println("" + new AddStrings().addStrings("999","1"));
    }
}
