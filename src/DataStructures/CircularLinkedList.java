package DataStructures;
import java.util.*;
public class CircularLinkedList<T extends Comparable <T> >implements Iterable<T> {
     private class node implements Comparable<node> {
        private T data;
        private node next;

        node(T data) {
            this.data = data;
            next = null;
        }

        public int compareTo(node o) {
            return data.compareTo(o.data);
        }
    }
    node head;
    int size;
    public CircularLinkedList(){
        size=0;
        head=null;
    }
    public void add(T element){
        var temp=new node(element);
        if(head==null)
        {
            head=temp;
            head.next=head;
        }else{
            node current=head;
            while(current.next!=head)
            {
                current=current.next;
            }
            current.next=temp;
            temp.next=head;
        }
        size++;
    }
    public void remove(int index)
    {
        if(index<0|| index>=size){
            throw new IndexOutOfBoundsException();
        }
        node current=head;
        if(index==0){
            while(current.next!=head)
            {
                current=current.next;
            }
            head=head.next;
            current.next=head;
        }else{
            for(int i=0;i<index-1;i++)
            {
                current=current.next;
            }
            current.next=current.next.next;
        }
        size--;
    }
    public T get(int index){
        if(index<0|| index>=size){
            throw new IndexOutOfBoundsException();
        }
        node current=head;
        for(int i=0;i<index;i++)
        {
            current=current.next;
        }
        return current.data;
    }
    public void set(int index,T data){
        if(index<0|| index>=size){
            throw new IndexOutOfBoundsException();
        }
        node current=head;
        for(int i=0;i<index;i++)
        {
            current=current.next;
        }
        current.data=data;
    }
    public void print(){
        node current=head;
        do{
            System.out.print(current.data+" ");
            current=current.next;
        }while(current!=head);
        System.out.println();
    }
     public int size() {
        return size;
    }

    public boolean IsEmpty() {
        return size == 0;
    }
     public Iterator<T> iterator() {
        return new Iterator<>() {
            private node current = head;
            private int index=0;
            public boolean hasNext() {
                return index<size;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                index++;
                return data;
            }
        };
    }

}
