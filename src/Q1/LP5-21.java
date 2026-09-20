import java.util.*;
public class LP5-21
{
    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String first=input.next();
        System.out.println("Enter Last Name:  ");
        String second=input.next();
        String letter=second.substring(0,1);
        letter=letter.toLowerCase();
        String group="";
        String part1="abcdefghi";
        String part2="jklmnopqrs";
        String part3="tuvwxyz";
        if(part1.contains(letter))
        {
            group="group 1";
        }else if(part2.contains(letter))
        {
            group="group 2";
        }else{
            group="group 3";
        }
        System.out.println(firstname+" "+lastname+" is assinged to "+group);
    }
}
