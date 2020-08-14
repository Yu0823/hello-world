package Algorithm;

public class MyAtoi {
    public int myAtoi(String str) {
        if(str.length() == 0)
            return 0;
        int ans = 0;
        char[] a = str.toCharArray();
        int i = 0;
        while(a[i] == ' '){
            i++;
            if(i == str.length())
                return 0;
        }
        int fac = 1;
        if(a[i] < '0' || a[i] > '9'){
            if(a[i] == '+')
                i++;
            else if(a[i] == '-'){
                fac = -1;
                i++;
            }
            else
                return 0;
        }
        while(i < a.length && a[i] >= '0' && a[i] <= '9'){
            if(ans > (Integer.MAX_VALUE - (a[i] - '0')) / 10.0)
                return fac == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + (a[i] - '0');
            i++;
        }
        return ans * fac;
    }

    public static void main(String[] args) {
        System.out.println("MAX:" + Integer.MAX_VALUE);
        System.out.println("MIN:" + Integer.MIN_VALUE);
        System.out.println(new MyAtoi().myAtoi("2147483646"));
    }
}
