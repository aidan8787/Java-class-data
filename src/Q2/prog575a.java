package Q2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Algorithms.SortingAlgorithms;

public class prog575a {
        public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog575a.txt"));
            var n= new ArrayList<String>();
            while (file.hasNext()) {
                n.add(file.next());
            }
            file.close();
            var nums=n.toArray(new String[0]);
            for(String x:nums)
            System.out.println(x);
            SortingAlgorithms.mergeSort(nums);
            System.out.println("Sorted");
            for(String x:nums)
            System.out.println(x);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
