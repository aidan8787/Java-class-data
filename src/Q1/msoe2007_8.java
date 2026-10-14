package Q1;
import java.util.*;

public class msoe2007_8 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Integer> answers=new ArrayList<>();
        System.out.println("Enter number of rows: ");
        int rows=input.nextInt();
        System.out.println("Enter number of columns: ");
        int cols=input.nextInt();
        int[][] grid=new int[rows][cols];
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++){
                System.out.println("Enter a number ");
                while(!input.hasNextInt())
                {

                }
                grid[r][c]=input.nextInt();
            }
        }
         for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++){
                System.out.print(grid[r][c]+" ");
            }
            System.out.println("");
        }
        input.close();
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++){
                int center=grid[r][c];
                int spot1=center-1;
                int spot2=center-1;
                int spot3=center-1;
                int spot4=center-1;
                int spot5=center-1;
                int spot6=center-1;
                int spot7=center-1;
                int spot8=center-1;
                if(r-1>-1){
                     spot1=grid[r-1][c];
                    if(c-1>-1){
                         spot2=grid[r-1][c-1];
                    }else{
                         spot2=center-1;
                    }
                    if(c+1<cols){
                         spot3=grid[r-1][c+1];
                    }else{
                        spot3=center-1;
                    }
                }else{
                     spot1=center-1;
                }
                if(r+1<rows){
                    spot4=grid[r+1][c];
                    if(c-1>-1){
                         spot5=grid[r+1][c-1];
                    }else{
                         spot5=center-1;
                    }
                    if(c+1<cols){
                         spot6=grid[r+1][c+1];
                    }else{
                         spot6=center-1;
                    }
                }else{
                    spot4=center-1;
                }
                if(c-1>-1){
                        spot7=grid[r][c-1];
                    }else{
                        spot7=center-1;
                    }
                    if(c+1<cols){
                        spot8=grid[r][c+1];
                    }else{
                        spot8=center-1;
                    }
                    if(center>spot8&&center>spot7&&center>spot6&&center>spot5&&center>spot4&&center>spot3&&center>spot2&&center>spot1){
                        answers.add(center);
                    }
            }
        }
        System.out.print("The high points are ");
    for(int i=0;i<answers.size();i++){
        System.out.print(answers.get(i)+" ");
    }
    System.out.println();
    }
}
