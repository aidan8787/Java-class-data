package Q1;
import java.util.*;
public class msoe2007_9 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Integer> nums=new ArrayList<>();
        ArrayList<Integer> part=new ArrayList<>();
        int count=0;
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        System.out.println("Enter starting number");
        int start=input.nextInt();
         System.out.println("Enter jump number");
        int jump=input.nextInt();
        int current=start;
        while(input.hasNextInt()){
            int temp=input.nextInt();
            nums.add(temp);
        }
        nums.sort(null);
        while(nums.size()>0)
        {
            part.clear();
          for(int i=0;i<nums.size();i++){
            if(nums.get(i)>current&&nums.get(i)<current+jump){
               part.add(nums.get(i));
               nums.remove(i);
               i--;
               count++;
            }
          }
          ans.add(part);
          current+=jump;
        }
        for()
    }
}
