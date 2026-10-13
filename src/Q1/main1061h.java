package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main1061h {
    public static void main(String[] args) {
        node1061h temp;
        String str;
        node1061helper help;
         try{
        Scanner input=new Scanner(new File("1061h.txt"));
            str=input.next();
            while(!str.contains("A"))
            {
                System.out.println(" You Need to add before printing or deleting");
                str=input.next();
            }
            str=str.substring(1);
            temp=new node1061h(str);
            help=new node1061helper(temp);
        while(input.hasNext())
        {
            str=input.next();
            if(str.substring(0,1).equals("A"))
            {
                help.add(str.substring(1));
            }else{
                if(str.substring(0,1).equals("D"))
                {
                 help.delete(str.substring(1));
                }else{
                if(str.equals("P"))
                {
                 help.Print();
                }else{
                    System.out.println("Invalid Command");
                }
            }
            }

        }
        System.out.println(help.toString());
        input.close();
        }catch(IOException e){
            System.out.println("File not found");
        }
    }
}