package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class msoe2007_8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows=input.nextInt();
        System.out.println("Enter number of columns: ");
        int cols=input.nextInt();
        int[][] grid=new int[rows][cols];
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++){
                grid[rows][cols]=input.nextInt();
            }
        }
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++){
                int center=grid[rows][cols];
                if(center>grid[rows][cols+1]&&center>grid[rows+1][cols]&&center>grid[rows][cols-1]&&center>grid[rows-1][cols]&&center>grid[rows+1][cols-1]&&center>grid[rows+1][cols+1]){
                    
                }
            }
        }
    }
}
