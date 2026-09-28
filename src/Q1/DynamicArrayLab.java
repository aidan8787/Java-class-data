package Q1;
import java.util.ArrayList;

import DataStructures.DynamicArray;
public class DynamicArrayLab {
    public static void main(String[] args) {
        System.out.println("========== Dynamic Array ==========");
        var dArray= new DynamicArray<Integer>();
        long start=System.nanoTime();
        for(int i=0;i<100_000;i++){
            dArray.add((int)(Math.random()*100_000));
        }
        long end=System.nanoTime();
        System.out.println("Array add: "+(end-start)/1e6+" ms");//ns to ms

        start=System.nanoTime();
        dArray.sort();
        end=System.nanoTime();
        System.out.println("Array sort: "+(end-start)/1e6+" ms");

        start=System.nanoTime();
        for(int i=0;i<100_000;i++)
        {
        dArray.remove(0);
        }
        end=System.nanoTime();
        System.out.println("Array remove: "+(end-start)/1e6+" ms");
        System.out.println("========== Array  List ==========");
        ArrayList<Integer> larray= new ArrayList<Integer>();
        long lstart=System.nanoTime();
        for(int i=0;i<100_000;i++){
            larray.add((int)(Math.random()*100_000));
        }
        long lend=System.nanoTime();
        System.out.println("Lists add: "+(lend-lstart)/1e6+" ms");///ns to ms

        lstart=System.nanoTime();
        larray.sort(null);
        lend=System.nanoTime();
        System.out.println("Lists sort: "+(lend-lstart)/1e6+" ms");

        lstart=System.nanoTime();
        for(int i=0;i<100_000;i++)
        {
        larray.remove(larray.size()-1);
        }
        lend=System.nanoTime();
        System.out.println("Lists remove: "+(lend-lstart)/1e6+" ms");
    }
}
/* 
========== Dynamic Array ==========
Array add: 14.802369 ms
Array sort: 25527.51515 ms
Array remove: 41531.240718 ms
========== Array  List ==========
Lists add: 17.303182 ms
Lists sort: 76.430384 ms
Lists remove: 25.077977 ms
*/