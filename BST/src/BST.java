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
