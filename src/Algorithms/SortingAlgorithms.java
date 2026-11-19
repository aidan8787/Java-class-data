package Algorithms;
import java.util.*;
@SuppressWarnings({"unused","ManualArrayCopy"})
public class SortingAlgorithms {
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
             /* ========== Merge Sort ==========  */
           @SuppressWarnings({"unchecked"})
        public static <T extends Comparable<T>> void mergeSort(T[]a){
            T[]l;
            T[]r;
            if(a.length>1)
            {
              int middle=a.length/2;
               l=(T[]) new Comparable[middle];
               r=(T[]) new Comparable[middle];
              for(int i=0;i<middle;i++){
                l[i]=a[i];
                r[i]=a[i+middle];
              }
              quickSort(r);
              quickSort(l);
              merge(a,l,r);
            }
        }
       public static <T extends Comparable<T>> void merge(T[]a,T[]l,T[]r){
        for(var x:l)
            System.out.print(x+" ");
            int i=0;
            int k=0;
            int j=0;
            while((i<l.length)&&(j<r.length)){
                if(l[i].compareTo(r[j])<=0){
                    a[k]=l[i];
                    i++;
                    k++;
                }else{
                    a[k]=r[j];
                    j++;
                    k++;
                }
            }
            while(j<r.length){
                a[k]=r[j];
                j++;
                k++;
            }
            while(i<l.length){
                a[k]=l[i];
                i++;
                k++;
            }
        }
                    /* ========== Quick Sort ==========  */
                public static <T extends Comparable<T>> void quickSort(T[]a){
                    quickSort(a,0,a.length-1);
                }

        public static <T extends Comparable<T>> void quickSort(T[]a,int low,int high){
            if(low<high)
            {
            int pivotindex=generatepivot(low,high);
            int partitionindex=partition(a,low,high,pivotindex);
            quickSort(a, low, partitionindex-1);
            quickSort(a, partitionindex+1,high);
            }
        }
         public static <T extends Comparable<T>> int generatepivot(int low,int high){
            return low+(int)(Math.random()*(high-low+1));
        }
          public static <T extends Comparable<T>> int partition(T[]a,int low,int high, int pivotindex){
            T pivot=a[pivotindex];
            int partitionindex=(low-1);
            for(int k=low;k<=high;k++){
                if(a[k].compareTo(pivot)<=0){
                    partitionindex++;
                }
            }
            swap(a,pivotindex,partitionindex);
            int i=low;
            int j=high;
            while(i<j){
                if(a[i].compareTo(pivot)<=0){
                    i++;
                }else if(a[j].compareTo(pivot)>0){
                    j--;
                }else{
                    swap(a,i,j);
                    i++;
                    j--;
                }
            }
            return partitionindex;
          }
}
