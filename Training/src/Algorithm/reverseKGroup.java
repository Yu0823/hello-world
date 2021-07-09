package Algorithm;

public class reverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int l = 0;
        ListNode p = head;
        while(p != null){
            l++;
            p = p.next;
        }

        int numOfGroup = l / k;

        //1 -> 2 -> 3  1    2 -> 3  1 <- 2  3

        ListNode groupTail = head, pre = null, now = head, next = null;
        ListNode ans = null;
        ListNode h1,h2 = null;
        for(int i = 0; i < numOfGroup; i++) {

            if (i == 0) {

                for (int j = 0; j < k; j++) {
                    next = now.next;
                    now.next = pre;

                    pre = now;
                    now = next;
                }

                ans = pre;

                head.next = now;

            }
            else {
                ListNode tail2 = now;

                pre = null;

                h1 = h2;
                h2 = now;

                for (int j = 0; j < k; j++) {
                    next = now.next;
                    now.next = pre;

                    pre = now;
                    now = next;
                }

                if(i == 1){
                    head.next = pre;
                }
                else{
                    //把前面的接到pre上
                    h1.next = pre;
                }
                tail2.next = now;
            }
        }

        return ans;
    }

    public static void main (String[] args) {
        reverseKGroup r = new reverseKGroup();
//        ListNode l7 = new ListNode(7);
//        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        r.reverseKGroup(l1,3);
    }
}
