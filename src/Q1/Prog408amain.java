package Q1;
import java.util.*;
import java.io.*;
public class Prog408amain
{
    public static void main(String[] args)
    {
        
        try{
            int id;
            int val;
            int cnt;
            int target;
            int num;
            ArrayList<Integer> temp=new ArrayList<Integer>();
            ArrayList<match> list=new ArrayList<match>();
            ArrayList<match> finallist=new ArrayList<match>();
            Scanner input=new Scanner(new File("input.txt"));
            while(input.hasNextInt()){
                id=input.nextInt();
                val=input.nextInt();
                temp.add(val);
                match pair=new match(id,val);
                list.add(pair);
            }
            temp.sort(null);
            for(int lcv=0;lcv<temp.size();lcv++){
                cnt=0;
                target=temp.get(lcv);
                match m=list.get(cnt);
                num=m.getval();
                if(num!=target)
                {
                   cnt++; 
                }else{
                    finallist.add(m);
                }
                while(num!=target)
                {
                m=list.get(cnt);
                num=m.getval();
                if(num!=target)
                {
                   cnt++; 
                }else{
                    finallist.add(m);
                }
                }
            }
            System.out.println("ID      Value");
            for(int lcv=finallist.size()-1;lcv>0;lcv--){
                match pair=finallist.get(lcv);
                System.out.println(pair.toString());
            }
            input.close();
        }catch(IOException e){
            System.out.println("File not found");
        }
    }
}
