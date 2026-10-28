package DataStructures;

@SuppressWarnings("unchecked")
public class Stack<T extends Comparable<T>> {
    private T[] stack;
    private int size;
    private int capacity;
    public Stack(){
        size=0;
        capacity=1;
        stack=(T[]) new Comparable[capacity];
    }
    public void push(T element){
        if(size==capacity)
        {
            resize(2*capacity);
        }
        stack[size++]=element;
    }
    public T pop(){
        T element=stack[--size];
        if(size==capacity/4)
        {
            resize(capacity/2);
        }
        return element;
    }
    public T peek()          { return stack[size-1];}
    public int size()        { return size;}
    public boolean IsEmpty() { return size==0;}
     private void resize(int newcapacity){
        if(newcapacity<1)
        {
            newcapacity=1;
        }
        var newstack=(T[]) new Comparable[newcapacity];
        System.arraycopy(stack,0,newstack,0,size);
        stack=newstack;
        capacity=newcapacity;
    }
}