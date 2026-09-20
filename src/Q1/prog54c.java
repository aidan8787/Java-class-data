import java.util.*;
public class prog54c
{
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Radius: ");
        double radius=input.nextDouble();
        double pi= 3.14159;
        double cir=2*pi*radius;
        cir=((int)(cir*1000))/1000.0;
        double area=pi*Math.pow(radius,2);
        area=((int)(area*1000))/1000.0;
        System.out.println("Area:          "+area);
        System.out.println("Radius:        "+radius);
        System.out.println("Circumference: "+cir);
    }
}
