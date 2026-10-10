package Q1;

import java.util.Scanner;

public class msoe2007_3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter angle number1:");
        int A=input.nextInt();
        System.out.println("Enter angle number2:");
        int B=input.nextInt();
        System.out.println("Enter angle number3:");
        int C=input.nextInt();
        System.out.println("Enter side length oppisite of angle3:");
        int c=input.nextInt();
        if(A+B+C==180){
            double r=c*(Math.sin(A/2.0))*(Math.sin(B/2.0))*(Math.sin(C/2.0));
            System.out.println("The radius of the circle is "+r);
        }else{
            System.out.println("The angles do not add up to 180");
        }
        input.close();
    }
}
