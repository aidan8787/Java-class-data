package DataStructures;
@SuppressWarnings("unchecked")
public class CircularQueue<T extends Comparable<T>> {
    //protected can only be used by other child classes
    protected T[] buffer;
    protected int head;
    protected int tail;
    protected int size;
    protected int capacity;

    public CircularQueue(int cap){
        head=0;
        tail=0;
        size=0;
        capacity=cap;
        buffer=(T[])new Comparable[capacity];
    }
    public void enqueue(T element){
        if(IsFull())
        {
           System.err.println("Queue is Full");
           return;
        }
        buffer[tail]=element;
        tail=(tail+1)%capacity;
        size++;
    }
    public T deque(){
        if(IsEmpty())
        {
            System.err.println("Queue is empty");
            return null;
        }
        T element=buffer[head];
        head=(head+1)%capacity;
        size--;
        return element;
    }
    public T peek()          { if(IsEmpty())return null; return buffer[head];}
    public int size()        { return size;}
    public boolean IsEmpty() { return size==0;}
    public boolean IsFull()  {return size==capacity;}
}
