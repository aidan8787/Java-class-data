package Q2;

import java.io.File;
import java.io.IOException;
import java.util.*;
import Algorithms.SortingAlgorithms;
public class Prog910q {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/numsort.dat"));
            var n= new ArrayList<Integer>();
            while (file.hasNext()) {
                n.add(file.nextInt());
            }
            file.close();
            var nums=n.toArray(new Integer[0]);
            for(Integer x:nums)
            System.out.println(x);
            SortingAlgorithms.quickSort(nums);
            for(Integer x:nums)
            System.out.println(x);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
