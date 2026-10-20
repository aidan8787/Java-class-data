package DataStructures;
import java.util.Iterator;
public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class node implements Comparable<node>{
        private T data;
        private node prev;
        private node next;
        node(T data){
            this.data=data;
            next=null;
            prev=null;
        }
        public int compareTo(node o){
            return data.compareTo(o.data);
        }
    }
    private node head;
    private node tail;
    private int size;
    public DoublyLinkedList(){
        size=0;
        tail=null;
        head=null;
    }
    /*Add to tail */
    public void add(T element){
        node temp=new node(element);
        if(head==null)
        {
            head=temp;
        }else{
            tail.next=temp;
            temp.prev=tail;
        }
        tail=temp;
        size++;
    }
    public void addfront(T element){
        var temp=new node(element);
        if(head!=null){
            temp.next=head;
            head.prev=temp;
        }
        head=temp;
        size++;
    }
     public void addback(T element){
        var temp=new node(element);
        if(tail!=null){
            tail.next=temp;
            temp.prev=tail;
        }
        tail=temp;
        size++;
    }
    public void insert(int index,T element){
       
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        node current=head;
        if(current==null)
        {
            addfront(element);
        }
        for(int i=0;i<index;i++)
        {
            current=current.next;
            if(current==null)
            {
                addback(element);
                break;
            }
        }
        node add=new node(element);
        if(current!=null)
        {
            current.prev=add.prev;
            current.prev=add;
            add.next=current;
            size++;
        }
        head=current;
    }
    /*Inserts new node in sorted order */
    public void addsorted(T element){
        int cnt=0;
        node  current=head;
        node temp=new node(element);
        if(current==null||current.compareTo(temp)<0)
        {
            addfront(element);
        }else{
        if(tail==null)
        {
            addback(element);
        }else{
        while(cnt<size&&current.compareTo(temp)<0)
        {
            cnt++;
            current=current.next;
            if(current==null)
            {
                cnt=size;
            }
        }
        insert(cnt,element);
    }
}
    }

    public void remove(int index)
    {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        if(head==null){
            size=0;
        }else{
        node current=head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        if(current==tail)
        {
           tail=tail.prev;
           tail.next=null;
        }else{
        node before=current.prev;
        node after=current.next;
        after.prev=before;
        before.next=after;
        current=before;
        current.next=after;
        head=current;
        size--;
        }
    }
    }
    public T get(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        node current=head;
        for(int i=0;i<index-1;i++){
            current=current.next;
        }
        if(current==null)
        {
            return tail.data;
        }
        return current.data;
    }
    public void set(int index,T element){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }
        node current=head;
        for( int i=0;i<index;i++)
        {
            current=current.next;
        }
        current.data=element;
    }
    public void print(){
        for(node current=head;current!=null;current=current.next)
            System.out.print(current.data+" ");
        System.out.println();
    }
    public void settail(T element){
        if(tail!=null)
        {
        tail.data=element;
        }else{
            node temp=new node(element);
            tail=temp;
        }
    }
    public void sethead(T element){
        if(head!=null)
        {
        head.data=element;
        }else{
            node temp=new node(element);
            head=temp;
        }
    }
    public void printbackward(){
        for(node current=tail;current!=null;current=current.prev)
            System.out.print(current.data+" ");
        System.out.println();
    }
    public int size(){return size;}
    public boolean IsEmpty(){return size==0;}
    public void remove(T element)
    {
        int cnt=0;
        while(get(cnt).compareTo(element)!=0)
        {
            cnt++;
        }
        remove(cnt);
    }
    public T pop(){
        T dat=tail.data;
        node temp=tail.prev;
        temp.next=null;
        tail=temp;
        size--;
        return dat;
    }
    public Iterator<T> iterator(){
        return new Iterator<>() {
            private node current=head;
            public boolean hasNext(){
                return current!=null;
            }
            public T next(){
                T data=current.data;
                current=current.next;
                return data;
            }
        };
    }
}
