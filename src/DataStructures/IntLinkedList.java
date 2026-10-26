import java.util.*;
public class IntLinkedList implements Iterable<Integer> { // implements List<T>
    private class node {
        int data;
        node next;
        node(int value){
         data=value;
         next=null;   
        }
    }
    private int size;
    private node head;
    public IntLinkedList(){
        head=null;
        size=0;
    }
    public void addfront(int data)
    {
        var add=new node(data);
        add.next=head;
        head=add;
        size++;
    }
    public void addlast(int data){
        var add=new node(data);
        if(head==null)
        {
            head=add;
            size++;
            return;
        }
        var current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=add;
        size++;
    }
    public void print(){
        node current=head;
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public int getcount(){
        return size;
    }
  
    public boolean isempty(){
        return size==0;
    }
    public boolean addspot(int index,int element){
        if(index<0||index>size)
        {
            return false;
        }
        node current=head;
        var add=new node(element);
        if(head==null)
        {
            head=add;
            size++;
            return true;
        }
        for(int i=0;i<index-1;i++)
        {
            current=current.next;
        }
        add.next=current.next;
        current.next=add;
        size++;
        return true;
    }
    public int getFirst()
    {
        return head.data;
    }
    public int getLast(){
        return get(size);
    }
    public void removelast(){
        remove(size);
    }
    public void removefirst(){
        remove(0);
    }
    public int get(int pos){
        if(pos>size||pos<0)
            throw new IndexOutOfBoundsException();
        node current=head;
        for(int i=0;i<pos-1;i++)
        {
            current=current.next;
        }
        return current.data;
    }
     public boolean remove(int spot)
  {
    if(size==1)
    {
        head=null;
        size=0;
        return true;
    }
    node temp=head;
    if(head==null)
    {
      return false;
    }
    if(head.next!=null&&spot==0)
    {
      head=head.next;
      size--;
      return true;
    }
    if(spot>size-1||spot<0)
    {
     return false;
    }
      for(int lcv=0;lcv<spot-2;lcv++)
      {
       temp=temp.next;
      }
      if(temp.next.next!=null)
      {
      temp.next=temp.next.next;
      size--;
      return true;
      }else{
      temp.next=null;
      size--;
      }
      return false;
  }
    public int countless(int num){
        int cnt=0;
        for(int i=0;i<=size;i++)
        {
            if(get(i)<num)
            {
                cnt++;
            }
        }
        return cnt;
    }
    public int countLess10()
    {
        return countless(10);
    }
    public boolean contains(int num){
        for(int i=0;i<=size;i++)
        {
            if(get(i)==num)
            {
                return true;
            }
        }
        return false;
    }
    public IntLinkedList getreverse()
    {
        var list=new IntLinkedList();
        for(int i=0;i<=size;i++)
        {
            list.addlast(get(i));
        }
        return list;
    }
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public Integer next() {
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }
    public double avg(){
        node current=head;
        double total=0;
        for(int i=0;i<=size;i++)
        {
            total+=current.data;
        }
        double avrage=total/size;
        return avrage;
    }
    public int min()
    {
        int min=get(0);
        for(int i=1;i<size;i++)
        {
            if(get(i)<min)
            {
                min=get(i);
            }
        }
        return min;
    }
    public int max(){
        int max=get(0);
        for(int i=1;i<size;i++)
        {
            if(get(i)>max)
            {
                max=get(i);
            }
        }
        return max;
    }
    public int indexofmax(){
        int max=get(0);
        int index=0;
        for(int i=1;i<size;i++)
        {
            if(get(i)>max)
            {
                max=get(i);
                index=i;
            }
        }
        return index;
    }
    public int lastindexofmax(){
        int max=get(0);
        int index=0;
        for(int i=1;i<size;i++)
        {
            if(get(i)>=max)
            {
                max=get(i);
                index=i;
            }
        }
        return index;
    }
 public void sort()
 {
   int len = size;
        for(int x = 0; x < len; x++) {
            node current =head;
            node last = head;
            while (current.next != null) {
                node next = current.next;
                if (current.data > next.data) {
                    if (current == head) {
                        current.next = next.next;
                        next.next = current;
                        last = next;
                        head = next;
                    }
                    else {
                        current.next = next.next;
                        next.next = current;
                        last.next = next;
                        last = next;
                    }
                } else {
                    last = current;
                    current = current.next;
       }
     }
   }
 }
 public int lose58()
 {
    int cnt=0;
        for(int i=0;i<size;i++)
        {
            if(get(i)==58)
            {
                remove(i-1);
                i--;
                cnt++;
            }
        }
        return cnt;
 }
  public int countEvens()
 {
    int cnt=0;
        for(int i=0;i<=size;i++)
        {
            if(get(i)%2==0)
            {
                cnt++;
            }
        }
        return cnt;
 }
  public void removeodd()
 {
    int ans=size-countEvens();
    int cnt=0;
         for(int i=0;i<=size;i++)
         {
            int data=get(i);
            if(data%2==1)
            {
               remove(i);
               cnt++;
               i--;
            }
        }
 }
 public void clear()
 {
    while(size>1)
    {
        remove(0);
    }
    remove(0);
 }
}
