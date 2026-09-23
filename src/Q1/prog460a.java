package Q1;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
public class prog460a {
    public static void main(String[] args )
    {
    try {
            ArrayList<Integer> list=new ArrayList<>();
            var file = new Scanner(new File("Langdat/sort.txt"));
            while (file.hasNextInt()) 
            {
             int temp=file.nextInt();
             list.add(temp);
            }
            int[] ans=new int[list.size()];
            int cnt=0;
            for(var l:list){
                ans[cnt]=l;
                cnt++;
            }
            Scanner input=new Scanner(System.in);
            System.out.println("Please enter number:");
            int key=input.nextInt();
            int index =Arrays.binarySearch(ans,key);
            if(ans[index]!=key)
            {
                System.out.println("The number "+key+" is not in the list.");
            }else{
                System.out.println("The number "+key+" is  in position: "+index);
            }
            input.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
