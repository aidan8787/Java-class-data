package Q1.Prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.LinkedlistStack;

public class prog285bLLstack {
     public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var stack=new LinkedlistStack<CL285b>();
            System.out.println("Id\tCode\tSales\t\tCommission");
            while (file.hasNext()) {
                int id=file.nextInt();
                int  c=file.nextInt();
                double s= file.nextDouble();
                var sp= new CL285b(id,c,s);
                stack.push(sp);
            }
            file.close();
            while(!stack.isEmpty())
            {
                var sale=stack.pop();
                System.out.println(sale.toString());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
