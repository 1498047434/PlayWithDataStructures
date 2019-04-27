public class ArrayQueue<E> implements Queue<E> {

    private Array<E> queue;

    public ArrayQueue(int capacity){
        queue = new Array<>(capacity);
    }

    public ArrayQueue(){
        queue = new Array<>();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.getSize() == 0;
    }

    @Override
    public void enqueue(E e) {
        queue.addLast(e);
    }

    @Override
    public E dequeue() {
        return queue.removeFirst();
    }

    @Override
    public E getFront() {
        return queue.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i=0; i<queue.getSize(); i++){
            res.append(queue.get(i));
            if(i != queue.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i=0; i<11; i++){
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
