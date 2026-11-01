package Q1.Prog285b;
import DataStructures.Stack;
import java.io.*;
import java.util.*;
public class prog285bstack {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var stack=new Stack<CL285b>();
            System.out.println("Id\tCode\tSales\t\tCommission");
            while (file.hasNext()) {
                int id=file.nextInt();
                int  c=file.nextInt();
                double s= file.nextDouble();
                var sp= new CL285b(id,c,s);
                stack.push(sp);
            }
            file.close();
            while(!stack.IsEmpty())
            {
                var sale=stack.pop();
                System.out.println(sale.toString());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Id      Code    Sales           Commission
// 291     17      $750.00         $90.00
// 264     17      $4150.00                $410.50
// 235     5       $5250.00                $396.25
// 218     5       $5000.00                $375.00
// 203     8       $3250.00                $243.75
// 192     8       $8125.00                $640.63
// 138     17      $6375.00                $677.50
// 125     5       $6500.00                $502.50
// 118     8       $7350.00                $574.75
// 117     3       $7350.00                $0.00
// 103     5       $4000.00                $300.00
// 101     17      $2250.00                $270.00