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

//        System.out.println(bst.contains(11));
//        bst.preOrder();
//        bst.inOrder();
//        System.out.println();
//        bst.preOrderNR();

//        System.out.println(bst);

//        bst.afterOrder();
//        bst.stageOrder();

//        System.out.println(bst.size());
//        System.out.println();
//        bst.removeMin();
//        bst.preOrderNR();
//        System.out.println();
//        System.out.println(bst.size());
//
//        System.out.println();
//        bst.removeMin();
//        bst.preOrderNR();

        bst.removeMax();
        bst.preOrderNR();


        System.out.println();
        bst.removeMax();
        bst.preOrderNR();
    }


}
