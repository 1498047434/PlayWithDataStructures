import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{

        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树中添加新的元素e
    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size++;
//        }else{
//           add(root, e);
//        }
        root = add(root,e);

    }

    //向以node为根的二分搜索树中插入新的元素E， 递归算法
    /*private void add(Node root, E e){
        if (e.equals(root.e)){
            return;
        }
        if(e.compareTo(root.e )< 0 && root.left==null){
            root.left = new Node(e);
            size++;
            return;
        }
        if(e.compareTo(root.e )> 0 && root.right==null){
            root.right = new Node(e);
            size++;
            return;
        }
        if(e.compareTo(root.e )< 0){
            add(root.left, e);
        }
        if(e.compareTo(root.e )> 0){
            add(root.right, e);
        }
    }*/

    private Node add(Node node, E e){
        if(node == null){
            node = new Node(e);
            size ++;
            return node;
        }

        if(e.compareTo(node.e )< 0){
            node.left = add(node.left, e);
        }
        if(e.compareTo(node.e )> 0){
            node.right = add(node.right, e);
        }

        return node;
    }

    //看二分搜索树中是否有元素额
    public boolean contains(E e){
        return contains(root, e);
    }

    // 看以节点node为根的二分搜索树中是否含有元素额， 递归算法
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);

    }

    //前序遍历以node为根的二分搜索树， 递归算法
    private void preOrder(Node node) {
        if(node != null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //二分树前序遍历（非递归实现）
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if (node != null){
                System.out.println(node.e);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }

    //二分树中遍历（非递归实现）
    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.peek();
            if (node.left == null){
                System.out.println(stack.peek());
                Node node2 = stack.peek();
                stack.push(node2.right);
            }else {
                stack.push(node.left);
            }

        }
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);

    }

    //中序遍历以node为根的二分搜索树， 递归算法
    private void inOrder(Node node) {
        if(node != null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    //后序遍历
    public void afterOrder(){
        afterOrder(root);
    }

    //后序遍历以node为根的二分搜索树， 递归算法
    private void afterOrder(Node node) {
        if(node != null){
            afterOrder(node.left);
            afterOrder(node.right);
            System.out.println(node.e);
        }
    }

    //层次遍历
    public void stageOrder(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }

        }
    }

    //查找最小元素
    public Node minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root);
    }
    //查找最小元素（递归实现）
    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    //删除最小元素
    public Node removeMin(){
        Node ret = minimum();
        root = removeMin(root);
        return ret;
    }
    //删除最小元素递归实现）
    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);

        return node;
    }

    //查找最大元素
    public Node maximum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }

        return maximum(root);
    }
    //查找最大元素（递归实现）
    private Node maximum(Node node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    //删除最大元素
    public Node removeMax(){
        Node ret = maximum();
        root = removeMax(root);
        return ret;
    }
    //删除最大元素（递归实现）
    private Node removeMax(Node node) {
        if (node.right == null){
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }
        node.right = removeMax(node.right);

        return node;
    }

    //删除任意元素
    public void remove(E e){
        root = remove(root, e);
    }

    //删除任意元素（递归实现）
    private Node remove(Node node, E e) {
        if(node == null){//如果跟节点为空
            return null;
        }else if (e.compareTo(node.e)<0){
            node.left = remove(node.left, e);
            return node;
        }else if (e.compareTo(node.e)>0){
            node.right = remove(node.right, e);
            return node;

        }else { //node.e == e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else if (node.left != null && node.right != null){
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
            return null;
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, Integer depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(Integer depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}
