package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
public class prog602bstack {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            var stack=new Stack<people>();
            while (file.hasNext()) {
                int a=file.nextInt();
                double hour=file.nextDouble();
                int code=file.nextInt();
                var p= new people(a,hour,code);
                stack.add(p);
            }
            System.out.println("Account\tHours\tCode\t\tAmount Due");
            while(!stack.empty())
            {
                var person=stack.pop();
                System.out.println(person);
            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
 class people  {
    private int id;
    private int code;
    private double hours;
    private double com=0;
    private void calc(){
        if(hours>15)
        {
            com=(hours-15)*30+550;
        }else{
            if(hours>5){
                com=(hours-5)*50+200;
            }else{
                com=200;
            }
        }
        if(code==1)
        {
            com+=50;
        }else{
            if(code==2)
            {
                com+=150;
            }
        }
    }
    public people(int i,double h,int c){
        id=i;
        com=0;
        code=c;
        hours=h;
        calc();
    }
    public String toString(){
        return String.format("%d\t%.2f\t%d\t\t$%.2f",id,hours,code,com);
    }
}
// Account Hours   Code            Amount Due
// 29118   15.02   0               $550.60
// 23051   1.55    2               $350.00
// 22841   27.90   2               $1087.00
// 21352   5.84    0               $242.00
// 20045   5.00    1               $250.00
// 19111   12.00   2               $700.00
// 17185   7.93    1               $396.50
// 14063   17.06   1               $661.80
// 1825    3.25    0               $200.00