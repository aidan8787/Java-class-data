import java.util.*;
public class LP3-5
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter amount of change in cents:");
        int total=input.nextInt();
        int qu=0;
        int d=0;
        int nic=0;
        int pen=0;
        int temp=0;
        temp=total%25;
        qu=total/25;
        total=temp;
        temp=total%10;
        d=total/10;
        total=temp;
        temp=total%5;
        nic=total/5;
        total=temp;
        pen=total;
        System.out.println("The minimum number of coins is:");
        System.out.println("Quarters: "+qu);
        System.out.println("Dimes   : "+d);
        System.out.println("Nickles : "+nic);
        System.out.println("Pennies : "+pen);
    }
}
