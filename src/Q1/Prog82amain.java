package Q1;
import java.util.*;
public class Prog82amain
{
    public static void main(String[] args)
    {
        double speed;
        double limit;
        double fine;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter Speed: ");
        speed=input.nextDouble();
        System.out.print("Enter Speed Limit: ");
        limit=input.nextDouble();
        cop police=new cop(speed,limit);
        fine=police.getfine();
        System.out.print("Fine Amount: $");
        System.out.printf("%.2f",fine);
        input.close();
    }
}
