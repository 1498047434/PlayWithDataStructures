import java.io.File;
import java.util.ArrayList;

public class Main {

//    public static void main(String[] args) {
//
//        System.out.println("Pride and Prejudice.");
//        ArrayList<String> words1 = new ArrayList<>();
//        FileOperation.readFile("pride-and-prejudice.txt",words1);
//        System.out.println("Total words: " + words1.size());
//        BSTSet<String> set1 = new BSTSet<>();
//        for (String word: words1){
//            set1.add(word);
//        }
//        System.out.println("Total diffreent words: " + set1.getSize());
//
//
//        System.out.println();
//
//
//        System.out.println("A Tale Of Two Cities.");
//        ArrayList<String> words2 = new ArrayList<>();
//        FileOperation.readFile("a-tale-of-two-cities.txt",words2);
//        System.out.println("Total words: " + words2.size());
//        BSTSet<String> set2 = new BSTSet<>();
//        for (String word: words2){
//            set2.add(word);
//        }
//        System.out.println("Total diffreent words: " + set2.getSize());
//    }

    private static double testSet(Set<String> set, String filename){
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());

            for (int i = 0; i < 2; i++) {
                for (String word: words) {
                    set.add(word);
                }
            }
            System.out.println("Toyal different words: " + set.getSize());
        }

        long endstart = System.nanoTime();

        return (endstart - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "a-tale-of-two-cities.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet,filename);
        System.out.println("BST Set: " + time1 + "s" + "\n");

        LinkedListSet<String> listSet = new LinkedListSet<>();
        double time2 = testSet(listSet,filename);
        System.out.println("LinkedList Set: " + time2 + "s");
    }
}
