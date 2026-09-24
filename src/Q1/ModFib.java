package Q1;
import java.util.*;
public class ModFib{
public static int modfibanochi(int n){
    if(n==0)
    {
    return 3;
    }else if(n==1){
        return 5;
    }else if(n==2)
    {
      return 8;
    }else{
        return modfibanochi(n-1)+modfibanochi(n-2)+modfibanochi(n-3);
    }
}
public static void main(String[]args){
    Scanner input=new Scanner(System.in);
    System.out.println("Enter a number");
    int n=input.nextInt();
    input.close();
    System.out.println(modfibanochi(n));
}
}