public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> bst = new BST<>();

        bst.add(8);
        bst.add(6);
        bst.add(11);
        bst.add(9);
        bst.add(12);

        //         8
        //     6       11
        //           9   12

        System.out.println(bst.contains(11));
        bst.preOrder();
        bst.inOrder();
//        System.out.println(bst);
    }


}