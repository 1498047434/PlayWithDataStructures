import java.util.ArrayList;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeE(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice.");
        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println("Total words: " + words1.size());
        LinkedListSet<String> set1 = new LinkedListSet<>();
        for (String word: words1){
            set1.add(word);
        }
        System.out.println("Total diffreent words: " + set1.getSize());


        System.out.println();


        System.out.println("A Tale Of Two Cities.");
        ArrayList<String> words2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",words2);
        System.out.println("Total words: " + words2.size());
        LinkedListSet<String> set2 = new LinkedListSet<>();
        for (String word: words2){
            set2.add(word);
        }
        System.out.println("Total diffreent words: " + set2.getSize());
    }
}
