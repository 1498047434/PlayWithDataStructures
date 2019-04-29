
import java.util.Random;

public class Main {

//    public static void main(String[] args) {
//	// write your code here
//
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i=0; i<5; i++){
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.add(5,666);
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(5));
//
//        linkedList.set(5,555);
//        System.out.println(linkedList);
//
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
//
//    }

    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Stack<Integer> s, int opCount){
        long startTime = System.nanoTime();
        //...
        Random random = new Random();
        for (int i=0; i<opCount; i++){
            s.push(random.nextInt());
        }
        for (int i=0; i<opCount; i++){
            s.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        double time1 = testQueue(linkedStack, opCount);
        System.out.println("LinkedStack, time: " + time1 + "s");

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time2 = testQueue(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time2 + "s");
    }

}
