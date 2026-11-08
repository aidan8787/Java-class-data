package DataStructures;

public class CircularDeque<T extends Comparable<T>> extends CircularQueue<T> {
    public CircularDeque(int cap){
        super(cap);
    }
    public void enqueFront(T element){
        if(IsFull()){
            System.err.println("Queue is full");
            return;
        }
        head=(head-1+capacity)%capacity;
        buffer[head]=element;
        size++;
    }
    public void enqueRear(T element){
       super.enqueue(element);
    }
    public T dequeFront(){ 
        return super.deque();
    }
    public T dequeRear(){
        if(IsEmpty())
        {
            System.err.println("Queue is empty");
            return null;
        }
        tail=(tail-1+capacity)%capacity;
        T element=buffer[tail];
        size--;
        return element;
    }
    public T peekFront(){
        return super.peek();
    }
    public T peekRear(){
       if(!IsEmpty())
        return buffer[(tail-1+capacity)%capacity];
       return null;
    }
}
