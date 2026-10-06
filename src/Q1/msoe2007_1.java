package Q1;
import java.util.*;
public class msoe2007_1{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter height 1");
        double h1=input.nextDouble();
        System.out.println("Enter length 1");
        double l1=input.nextDouble();
        System.out.println("Enter length 2");
        double l2=input.nextDouble();
        double total=(h1/l1)*l2;
        System.out.println("The second height is "+total);
        input.close();
    }
}
//Enter height 1
//4
//Enter length 1
//4
//Enter length 2
//2
//The second height is 2.0