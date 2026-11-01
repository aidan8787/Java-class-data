package DataStructures;

public class LinkedlistStack<T extends Comparable <T>> {
    private final Linkedlist<T> stack;
    public LinkedlistStack(){
        stack=new Linkedlist<>();
    }
    public void push(T element)
    {
        stack.add(element);
    }
    public T pop()
    {
        return stack.remove(stack.size()-1);
    }
    public T peek()
    {
        return stack.get(stack.size()-1);
    }
    public int size()
    {
        return stack.size();
    }
    public boolean isEmpty()
    {
        return stack.IsEmpty();
    }
}
