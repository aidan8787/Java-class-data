package Q1;
import java.lang.Math;
import java.util.*;
public class msoe2007_6 {
    public static void main(String[] args) {
        Stack<trapazoid>stack=new Stack<>();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter A value: ");
        double a=input.nextDouble();
        System.out.println("Enter B value: ");
        double b=input.nextDouble();
        System.out.println("Enter N value: ");
        double n=input.nextDouble();
        input.close();
        var trap=new trapazoid(a);
        stack.push(trap);
        double h=(b-a)/n;
        for(int i=1;i<n;i++){
            trap=new trapazoid(a+i*h);
            trap.doubled();
            stack.add(trap);
        }
        trap=new trapazoid(h*n+a);
        stack.add(trap);
        double area=0.0;
        while(!stack.isEmpty())
        {
            trap=stack.pop();
            area+=trap.getval();
        }
        area*=(h/2);
        System.out.println("The final area is: "+area);
    }
}
class trapazoid {
    private double total;
    public trapazoid(double x)
    {
        calc(x);
    }
    public void calc(double x)
    {
        total=Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }
    public double getval(){
        return total;
    }
    public void doubled(){
        total=total*2;
    }
}