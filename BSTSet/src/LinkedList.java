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

//    private Node head;
    private Node dummyHead;
    private int size;


    public LinkedList(){
//        head = null;
//        dummyHead = null;
        dummyHead = new Node(null,null);
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

//    //在链表头添加新的元素e
//    public void addFirst(E e){
////        Node node = new Node(e);
////        node.next = head;
////        head = node;
//
//        head = new Node(e,head);
//        size ++;
//    }


    //在链表index(0-based)处添加元素e
    public void add(int index, E e){
        if(index <0 || index > size){
            throw new IllegalArgumentException("Add faild. Illegal index");
        }
//        if(index == 0){
//            addFirst(e);
//        }else{
//            Node prve = head;
//            for (int i=0; i<index-1; i++){
//                prve = prve.next;
//            }
////            Node node = new Node(e);
////            node.next = prve.next;
////            prve.next = node;
//
//            prve.next = new Node(e, prve.next);
//            size ++;
//        }
        Node prve = dummyHead;
        for (int i=0; i<index; i++){
                prve = prve.next;
        }
        prve.next = new Node(e, prve.next);
        size ++;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e,head);

//        size ++;
        add(0,e);
    }

    //在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }


    //获得链表的第index(0-based)个位置的元素
    //在链表中不是一个常用的操作，练习用：
    public E get(int index){

        if(index <0 || index >= size){
            throw new IllegalArgumentException("Get faild. Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表的最后一元素
    public E getLast(){
        return get(size-1);
    }

    //修改链表的第index(0-based)个位置的元素
    //在链表中不是一个常用的操作，练习用：
    public void set(int index, E e){

        if(index <0 || index >= size){
            throw new IllegalArgumentException("Update faild. Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    //删除链表的第index(0-based)个位置的元素
    //在链表中不是一个常用的操作，练习用：
    public E remove(int index){

        if(index <0 || index >= size){
            throw new IllegalArgumentException("Remove faild. Illegal index");
        }
        Node prev = dummyHead;
        for(int i=0; i<index; i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //删除指定元素
    public void removeE(E e){
        remove(dummyHead , e);
    }

    //删除指定元素
    private void remove(Node node,E e){

        if(node.next == null){
            return;
        }

        remove(node.next, e);

        if(node.next.e == e){
            Node nextNode = node.next.next;
            node.next.next = null;
            node.next = nextNode;

//            Node delNode = node.next;
//            node.next = delNode.next;
//            delNode.next = null;
        }
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeLast(){
        return remove(size -1);
    }



}
