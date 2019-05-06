import java.util.ArrayList;

public class Main {


    private static double testMap(Map<String, Integer> map, String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());

            for (int i = 0; i < 2; i++) {
                for (String word: words) {
                    if (map.contains(word)){
                        map.set(word, map.get(word) + 1);
                    }else {
                        map.add(word,1);
                    }
                }
            }
            System.out.println("Toyal different words: " + map.getSize());
        }
        long endstart = System.nanoTime();

        return (endstart - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String fileName = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time2 = testMap(bstMap, fileName);
        System.out.println("BSTMap Map:" + time2 + "s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time1 = testMap(linkedListMap, fileName);
        System.out.println("LinkedList Map:" + time1 + "s");
    }
}
