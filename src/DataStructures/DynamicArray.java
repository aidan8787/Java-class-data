package DataStructures;
import java.util.*;

import Algorithms.*;
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class DynamicArray<T extends Comparable<T>> implements Iterable<T>{
    private T[]arr;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY=16;
    public DynamicArray(){
        size=0;
        capacity=DEFAULT_CAPACITY;
        arr=(T[]) new Comparable[capacity];
    }
    private void resize(int newcapacity){
        var newArr=(T[]) new Comparable[newcapacity];
        if(size>=0){
            System.arraycopy(arr,0,newArr,0,size);
        }
        arr=newArr;
        capacity=newcapacity;
    }
    public void add(T element){
        if(size==capacity){
            resize(2*capacity);
        }
        arr[size++]=element; // Equivalent to array[size]=element; size++;
    }
    public T remove(int index){
        T element=arr[index];
        for(int i=index;i+1<size;i++){
            arr[i]=arr[i+1];
        }
        size--;
        if(size==capacity/4){
            resize(capacity/2);
        }
        return element;
    }
    public T get(int index){ return arr[index]; }
    public void set(int index,T element){arr[index]=element;}
    public int size(){return size;}
    public boolean IsEmpty(){return size==0;}
    public int indexOf(T element){ return SearchAlgorithms.linearSearch(arr, element);}
    public boolean contains(T element){ return indexOf(element)!=-1;}
    public void sort(){SortingAlgorithms.insertionSort(arr,size);} // TODO: replace w/ quicksort
    public Comparable[] toArray(){return Arrays.copyOf(arr,size);}
    public String toString(){return Arrays.toString(this.toArray());}
    public Iterator<T> iterator(){
        return new Iterator<>(){
            private int index=0;
            public boolean hasNext(){return index<size;}
            public T next(){return arr[index++];}
        };
    }
}