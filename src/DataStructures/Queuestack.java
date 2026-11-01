package DataStructures;

public class Queuestack<T extends Comparable<T>> {
    Queue<T> actual;
    Queue<T> temp;
    public Queuestack()
    {
        actual=new Queue<>();
    }
    public void push(T element)
    {
       actual.enqueue(element);
    }
    public T pop()
    {
        temp=new Queue<>();
        while(!temp.IsEmpty())
        {
            temp.deque();
        }
        while(actual.size()!=1)
        {
            temp.enqueue(actual.deque());
        }
        var data=actual.deque();
        while(!temp.IsEmpty())
        {
            actual.enqueue(temp.deque());
        }
        return data;
    }
    public T peek()
    {
        while(actual.size()!=1)
        {
            temp.enqueue(actual.deque());
        }
        var data=actual.peek();
        while(!temp.IsEmpty())
        {
            actual.enqueue(temp.deque());
        }
        return data;
    }
    public int size(){
        return actual.size();
    }
    public boolean isEmpty() { return actual.IsEmpty();}
}
