package Q1;
import java.util.*;

public class prog1060b {
    public static void main(String[]args)
    {
        Queue<String> queue=new LinkedList<>();
        Queue<String> backup=new LinkedList<>();
        String com="";
        String num="";
        Scanner input=new Scanner(System.in);
        while(!com.equals("E"))
        {
        System.out.println("Enter Task A)add D)delete and E) exit");
        com=input.next();
        if(com.equalsIgnoreCase("A")||com.equalsIgnoreCase("D"))
        {
            System.out.println("Enter a number:");
            num=input.next();
        if(com.equalsIgnoreCase("A"))
        {
            queue.add(num);
        }else{
            while(!queue.isEmpty()){
                var temp=queue.poll();
                if(!temp.equalsIgnoreCase(num))
                {
                    backup.add(temp);
                }else{
                    break;
                }
            }
                queue.addAll(backup);
        }
    }
    System.out.println("The new list is "+queue);
    }
}
}
