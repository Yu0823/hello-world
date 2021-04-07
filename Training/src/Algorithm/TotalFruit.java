package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public static void main(String[] args) {
        int[] tree = {1,2,1};
        System.out.println(totalFruit(tree));
    }
    public static int totalFruit(int[] tree) {
        int max = 0;
        int left = 0, right = 0;
        Map kindNum = new HashMap();
        int total = 0; //num of fruits
        while(right < tree.length){
            if(kindNum.containsKey(tree[right])){
                int num = (int) kindNum.get(tree[right]);
                kindNum.put(tree[right], num + 1);
            }
            else{
                if(kindNum.keySet().size() < 2){
                    kindNum.put(tree[right], 1); // add new fruit
                }
                else{
                    //we should make the size smaller now
                    while(kindNum.keySet().size() == 2) {
                        total--;
                        int num = (int) kindNum.get(tree[left]);
                        num--;
                        if (num == 0) {
                            kindNum.remove(tree[left]);
                        } else {
                            kindNum.put(tree[left], num);
                        }
                        left++;
                    }
                    kindNum.put(tree[right], 1);
                }
            }
            total++;
            max = Math.max(max, total);
            right++;
        }
        return max;
    }
}
