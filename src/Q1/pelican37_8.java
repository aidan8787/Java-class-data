package Q1;
import java.util.*;
public class pelican37_8 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("What is the slope of your line?");
        double slope=input.nextDouble();
         System.out.println("What is the y-intercept of your line?");
        double yint=input.nextDouble();
        linear line=new linear(slope, yint);
        System.out.println("The Slope is "+line.getslope());
        System.out.println("The Y intercept is "+line.getyint());
        System.out.println("The root of the line is "+line.getroot());
        System.out.println("Enter a x value ");
        double x=input.nextDouble();
        System.out.println("The y value at x= "+x+" is "+line.gety(x));
        System.out.println("Enter a y value ");
        double y=input.nextDouble();
        System.out.println("The x value at y= "+y+" is "+line.getx(y));
        input.close();
    }
}
class linear{
private double m;
private double b;
public linear(double slope,double yint){
b=yint;
m=slope;
}
public double gety(double x){
    return m*x+b;
}
public double getx(double y){
    return (y-b)/m;
}
public double getroot(){
    return getx(0);
}
public double getyint(){
    return b;
}
public double getslope(){
    return m;
}
}
//What is the slope of your line?
//-3
//What is the y-intercept of your line?
//2.5
//The Slope is -3.0.
//The Y intercept is 2.5.
//The root of the line is 0.8333333333333334.
//Enter a x value: 
//-4.61
//The y value at x= -4.61 is 16.330000000000002.
//Enter a y value: 
//5
//The x value at y= 5.0 is -0.8333333333333334.