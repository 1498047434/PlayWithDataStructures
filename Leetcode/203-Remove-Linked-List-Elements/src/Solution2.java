class Solution2 {
    //使用虚拟头指针
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
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
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,5,6,7,8,5,6,1,7,8,1,4,2,3,5,2};
        ListNode list = new ListNode(arr);
        System.out.println(list);
        System.out.println(new Solution2().removeElements(list,5));

    }
}
