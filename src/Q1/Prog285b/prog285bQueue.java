package Q1.Prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataStructures.Queue;
public class prog285bQueue {
      public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var queue=new Queue<CL285b>();
            System.out.println("Id\tCode\tSales\t\tCommission");
            while (file.hasNext()) {
                int id=file.nextInt();
                int  c=file.nextInt();
                double s= file.nextDouble();
                var sp= new CL285b(id,c,s);
               queue.enqueue(sp);
            }
            file.close();
            while(!queue.IsEmpty())
            {
                var sale=queue.deque();
                System.out.println(sale.toString());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Id      Code    Sales           Commission
// 101     17      $2250.00                $270.00
// 103     5       $4000.00                $300.00
// 117     3       $7350.00                $0.00
// 118     8       $7350.00                $574.75
// 125     5       $6500.00                $502.50
// 138     17      $6375.00                $677.50
// 192     8       $8125.00                $640.63
// 203     8       $3250.00                $243.75
// 218     5       $5000.00                $375.00
// 235     5       $5250.00                $396.25
// 264     17      $4150.00                $410.50
// 291     17      $750.00         $90.00