package Q1;
import java.util.*;
import java.io.*;
public class msoe2007_9 {
    public static void main(String[] args) {
        try{
        Scanner input=new Scanner(new File("Langdat/input.txt"));
        ArrayList<Integer> nums=new ArrayList<>();
        int count=0;
        ArrayList<Integer> ans= new ArrayList<>();
        System.out.println("Enter starting number");
        int start=input.nextInt();
         System.out.println("Enter jump number");
        int jump=input.nextInt();
        int current=start;
        System.out.println("Enter all numbers");
        int temp=0;
        while(input.hasNext()==true){
            temp=input.nextInt();
            nums.add(temp);
        }
        input.close();
        nums.sort(null);
        while(nums.size()>0)
        {
            count=0;
          for(int i=0;i<nums.size();i++){
            int num=nums.get(i);
            if(num>=current&&num<=current+jump){
               nums.remove(i);
               count++;
               i--;
            }
          }
          ans.add(count);
          current+=jump;
        }
        current=start;
        for(int i:ans)
        {
            System.out.print(current+"\3 - \3"+(current+jump)+"\t:\t");
            for(int lcv=0;lcv<i;lcv++){
                System.out.print("*");
            }
            System.out.println("");
            current+=jump;
        }
    }catch(IOException e){
        System.err.println(e);
    }
    }
}