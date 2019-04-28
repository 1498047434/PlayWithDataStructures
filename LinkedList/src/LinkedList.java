public class LinkedList<E> {

    private  class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e,head);
        size ++;
    }


    //在链表index(0-based)处添加元素e
    public void add(int index, E e){
        if(index <0 || index > size){
            throw new IllegalArgumentException("Add faild. Illegal index");
        }
        if(index == 0){
            addFirst(e);
        }else{
            Node prve = head;
            for (int i=0; i<index-1; i++){
                prve = prve.next;
            }
//            Node node = new Node(e);
//            node.next = prve.next;
//            prve.next = node;

            prve.next = new Node(e, prve.next);
            size ++;
        }
    }

    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }
}
