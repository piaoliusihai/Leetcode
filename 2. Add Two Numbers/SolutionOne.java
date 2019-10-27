/*
    Method: Brute Force;
    TimeComplexity: O(max(m, n)), m is the length of the l1, s is the length of the l2;
    SpaceComplexity: O(max(m, n)), the length of the new list is at most max(m,n) + 1;
    Time: 2019/10/26;
    Attention: In README.md
*/
class SolutionOne {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

