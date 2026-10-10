package Q1;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import DataStructures.DynamicArray;
public class bigbucks {
    public static void main(String[] args) {
        var list=new DynamicArray<bucks>();
        Scanner input=new Scanner(System.in);
        String str="";
        Double money;
        while(str!="exit"){
            System.out.println("Please enter the account name(Exit to leave)"); 
            str=input.next();
            while(str.equals("")){
                str=input.next();
            }
            if(str.equalsIgnoreCase("exit")){
                break;
            }else{
                System.out.println("Enter a amount to be deposited");
                money=input.nextDouble();
                bucks dollars=new bucks(money,str);
                if(list.contains(dollars)){
                    int index=list.indexOf(dollars);
                    dollars=list.get(index);
                    Double temp=dollars.getcost();
                    bucks newmoney=new bucks(temp+money, str);
                    list.set(index,newmoney);
                }else{
                    list.add(dollars);
                }
            }
        }
        list.sort();
        input.close();
        bucks most=list.get(0);
        System.out.println("The Acount with the most money is "+most.getname());
        NumberFormat formater=new DecimalFormat("$#,###.##");
         System.out.println("The Acount with the most money has "+formater.format(most.getcost()));
    }
}
    class bucks implements Comparable<bucks>{
        private String name="";
        private Double amount; 
        public bucks(Double current,String names){
            name=names;
            amount=current;
        }
        public int compareTo(bucks o)
        {
            if(name.compareTo(o.getname())==0)
            {
                return name.compareTo(o.getname());
            }
            return amount.compareTo(o.getcost());
        }
        public Double getcost(){
            return amount;
        }
        public String getname(){
            return name;
        }
    }
