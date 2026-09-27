package Q1;

import java.io.*;
import java.util.*;
import Algarithims.SortingAlgorithims;;

public class prog481a {
    public static void main(String[] args) {
    try {
            var file = new Scanner(new File("Langdat/numsort.dat"));
            var nums=new ArrayList<Integer>();
            while (file.hasNextInt()) {
                nums.add(file.nextInt());
            }
            file.close();
            Integer[]arr=new Integer[nums.size()];
            for(int i=0;i<nums.size();i++){
                arr[i]=nums.get(i);
            }
            System.out.println("Original list: "+Arrays.toString(arr));
            SortingAlgorithims.bubbleSort(arr);
            System.out.println("Sorted list: "+Arrays.toString(arr));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
  }
}