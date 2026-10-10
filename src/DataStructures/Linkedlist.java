package DataStructures;

public class Linkedlist<T extends Comparable<T>> { // implements List<T>
    private class Node implements Comparable<Node>{
        T data;
        Node next;

        Node(T value){
         data=value;
         next=null;   
        }
        public int compareTo(Node O){
            return data.compareTo(O.data);
        }
    }
    private Node head;
    private int size;
    public Linkedlist(){
        head=null;
        size=0;
    }
    public boolean add(T element){
        var node= new Node(element);
        if(head==null){
            head=node;
        }else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=node;
        }
        size++;
        return true;
    }
    public T remove(int index){
        T old;
        //if(size>=index){
        //    throw new IndexOutOfBoundsException();
        //}
        if(index==0){
            old=head.data;
            head=head.next;
        }else{
            Node current=head;
            for(int i=0;i<index-1;i++){
                current=current.next;
            }
            old=current.next.data;
            current.next=current.next.next;
        }
        size--;
        return old;
    }
    public T get(int index){
        T dat;
         Node current=head;
            for(int i=0;i<index;i++){
                current=current.next;
            }
            dat=current.data;
            return dat;
    }
    public T set(int index,T element)
    {
        T old;
          Node current=head;
            for(int i=0;i<index;i++){
                current=current.next;
            }
            old=current.data;
            current.data=element;
            return old;
    }
    public void print(){
        for(Node current=head;current!=null;current=current.next){
            System.out.print(current.data+" ");
        }
        System.out.println();
    }
    public int size()        { return size; }
    public boolean IsEmpty() { return size==0; }
}
