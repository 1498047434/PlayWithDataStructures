
public class Solution3 {

    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if(head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }
        ListNode res =removeElements(head.next,val,depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if(head.val == val){
            ret =res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
    public static void main(String[] args) {
//        Integer[] arr = {1,5,6,7,8,5,6,1,7,8,1,4,2,3,5,2};
        Integer[] arr = {1,1,2};
        ListNode list = new ListNode(arr);
        System.out.println(list);
        System.out.println(new Solution3().removeElements(list,1, 0));

    }
}
