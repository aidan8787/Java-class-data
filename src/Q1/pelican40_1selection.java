package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Algorithms.SortingAlgorithms;

public class pelican40_1selection {
    
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
            SortingAlgorithms.selectionSort(arr);
            System.out.println("Sorted list: "+Arrays.toString(arr));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
  }
}
