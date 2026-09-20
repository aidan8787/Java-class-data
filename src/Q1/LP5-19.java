import java.io.*;
import java.util.*;
public class LP5-19
{
    public static void main(String[] args)
    {
        
        String str;
        int len;
        String remove;
        int index;
            Scanner input=new Scanner(System.in);
            System.out.println("Enter a sentence");
            str=input.nextLine();
            System.out.println("Enter a string to be removed");
            remove=input.next();
            len=remove.length();
            index=str.indexOf(remove);
            while(index>-1)
            {
                str=str.substring(0,index)+str.substring(index+len);
                index=str.indexOf(remove);
            }
        System.out.println(str);
    }
}
