import java.util.*;
public class LP 3-12
{
    public static void main(String[] args)
    {
        double food;
        double clothes;
        double entertain;
        double rent;
        double total;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter amount spent on food: ");
        food=input.nextDouble();
        System.out.print("Enter amount spent on clothes: ");
        clothes=input.nextDouble();
        System.out.print("Enter amount spent on entertainment: ");
        entertain=input.nextDouble();
        System.out.print("Enter amount spent on rent: ");
        rent=input.nextDouble();
        total=rent+food+clothes+entertain;
        food=(food/total)*100;
        rent=(rent/total)*100;
        entertain=(entertain/total)*100;
        clothes=(clothes/total)*100;
        System.out.print("Money spent on food is %");
        System.out.printf("%.2f",food);
        System.out.println(" of the total weekly budget.");
        System.out.print("Money spent on entertainment is %");
        System.out.printf("%.2f",entertain);
        System.out.println(" of the total weekly budget.");
        System.out.print("Money spent on clothes is %");
        System.out.printf("%.2f",clothes);
        System.out.println(" of the total weekly budget.");
        System.out.print("Money spent on rent is %");
        System.out.printf("%.2f",rent);
        System.out.println(" of the total weekly budget.");
    }
}
