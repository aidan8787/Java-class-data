package Algarithims;
import java.util.*;
@SuppressWarnings({"unused","ManualArrayCopy"})
public class SortingAlgorithims {
    public static <T extends Comparable<T>> void swap(T[]arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static <T extends Comparable<T>> void bubbleSort(T[]arr){
     for (int i=0;i<arr.length-1;i++){
      for (int j=0;j<arr.length-i-1;j++){
        if(arr[j].compareTo(arr[j+1])>0){
            swap(arr, j, j+1);
        }
     }
     }
    }
    public static <T extends Comparable<T>> void insertionSort(T[]arr){
       insertionSort(arr,arr.length);
    }
      public static <T extends Comparable<T>> void insertionSort(T[]arr,int n){
        for (int i=1;i<n;i++){
            T key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j].compareTo(key)>0){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
      }
       public static <T extends Comparable<T>> void insertionSort(T[]arr,int n,int s){
        for (int i=s;i<n;i++){
            T temp=arr[i];
            int j=i;
            while(j>=s&&arr[j-s].compareTo(temp)>0){
                arr[j]=arr[j-s];
                j-=s;
            }
            arr[j]=temp;
        }
      }
        public static <T extends Comparable<T>> void selectionSort(T[]arr){
           for(int i=0;i<arr.length-1;i++){
             int mIndex=i;
             for( int j=i+1;j<arr.length;j++){
                if(arr[j].compareTo(arr[mIndex])<0){
                    mIndex=j;
                }
             }
             swap(arr, i, mIndex);
           }
        }
        public static <T extends Comparable<T>> void shellSort(T[]arr){
            int gap=arr.length/2;
            while(gap>0){
                insertionSort(arr,arr.length,gap);
                gap=gap/2;
            }
        }
}
