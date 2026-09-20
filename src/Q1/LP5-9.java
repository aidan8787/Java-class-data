import java.util.*;
public class LP5-9
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number:");
        int num=input.nextInt();
        for(int x=1;x<=num;x++)
        {
            System.out.print(" x^"+x+"    ");
        }
        System.out.print("\n");
        for(int x=1;x<=num;x++)
        {
            for(int a=1;a<=num;a++){
                System.out.print(" "+(int)(Math.pow(x,a))+"       ");
            }
            System.out.print("\n");
        }
    }
}
