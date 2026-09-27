package Q1;

public class pelican50_4 {
    public static void main(String[] args) {
        int[] i={-7,15,21,22,43,49,51,67,78,81,84,89,95,97};
        Integer[] iw= new Integer[14];
        for(int k=0;k<14;k++){
            iw[k]=i[k];
        }
        System.out.println(binarySearch(iw,  22));
        System.out.println(binarySearch(iw,  89));
        System.out.println(binarySearch(iw,        -100));
        System.out.println(binarySearch(iw,  72));
        System.out.println(binarySearch(iw, 102));
    }
    private static <T extends Comparable<T>> int binarySearch(T[]arr,T target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid].compareTo(target)==0){
                return mid;
            }else if(target.compareTo(arr[mid])>0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}