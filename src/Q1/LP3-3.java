import java.util.*;
public class LP3-3
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter scholarship amount: ");
        double off=input.nextDouble();
        System.out.println("Enter textbook cost: ");
        double books=input.nextDouble();
        System.out.println("How many books? ");
        books=books * input.nextInt();
        System.out.println("Enter housing cost: ");
        double house=input.nextDouble();
        System.out.println("How many years? ");
        house=house * input.nextInt();
        double cost=(house+books)-off;
        if(cost>0)
        {
            System.out.println("Total amount: "+cost);
        }else{
            System.out.println("Total amount: Free");
        }
     }
}
