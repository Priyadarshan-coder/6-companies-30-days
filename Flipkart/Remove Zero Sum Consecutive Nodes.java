class Solution{
public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(prefix,dummy);
        while (head != null) {
            prefix += head.val;
            if (map.containsKey(prefix)) {
               ListNode curr =  map.get(prefix);
                int p = prefix ;
                while (curr!=null && curr!=head) {
                    curr=curr.next;
                    p+=curr.val;
                    if(curr!=head)
                    {
                        map.remove(p);
                    }
                }
                map.get(prefix).next=head.next;
            } else {
                map.put(prefix, head);
            }
            head=head.next;
        }
        return dummy.next;
    }
 }