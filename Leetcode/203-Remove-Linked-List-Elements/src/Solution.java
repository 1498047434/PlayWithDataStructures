class Solution {
    //不用虚拟头指针
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        while (head!=null && head.val==val){
//            ListNode retNode = head;
//            head = retNode.next;
//            retNode.next = null;
            head = head.next;
        }

        if(head == null){ //不加到这个地方，如果已经删除完了，下面会报错
            return null;
        }
        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
//                ListNode retNode = prev.next;
//                prev.next = retNode.next;
//                retNode.next = null;
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}
