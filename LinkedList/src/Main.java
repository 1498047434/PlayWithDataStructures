public class Main {

    public static void main(String[] args) {
	// write your code here

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0; i<5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(5,666);
        System.out.println(linkedList);

        System.out.println(linkedList.get(5));

        linkedList.set(5,555);
        System.out.println(linkedList);


        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
