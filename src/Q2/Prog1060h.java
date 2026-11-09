package Q2;
import java.io.*;
import java.util.*;

public class Prog1060h {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/invntory.dat"));
            var file2 = new Scanner(new File("Langdat/rates.dat"));
            var file3 = new Scanner(new File("Langdat/transact.dat"));
            Queue<cars> queue=new LinkedList<>();
             Queue<cars> rentqueue =new LinkedList<>();
             var cararray= new Queue[5];
             var rentedarray= new Queue[5];
            String name;
            String temp;
            Double perday=0.0;
            var rates=new rate[5];
            Double milage;
            while (file.hasNext()) {
                name=file.next();
                temp=name.substring(0,1);
                milage=file.nextDouble();
                name=name.substring(1);
                cars car=new cars(name, milage);
                if(temp.equalsIgnoreCase("s")){
                    var s=cararray[0];
                    if(s!=null)
                    {
                    s.add(car);
                    cararray[0]=s;
                    }else{
                        queue.add(car);
                        cararray[0]=queue;
                    }
                }else if(temp.equalsIgnoreCase("c")){
                    var c =cararray[1];
                    if(c!=null)
                    {
                    c.add(car);
                    cararray[1]=c;
                    }else{
                        queue.add(car);
                        cararray[1]=queue;
                    }
                  }else if(temp.equalsIgnoreCase("m")){
                    var m =cararray[2];
                    if(m!=null)
                    {
                    m.add(car);
                    cararray[2]=m;
                    }else{
                        queue.add(car);
                        cararray[2]=queue;
                    }
                  }else if(temp.equalsIgnoreCase("w")){
                    var w =cararray[3];
                     if(w!=null)
                    {
                    w.add(car);
                    cararray[3]=w;
                    }else{
                        queue.add(car);
                        cararray[3]=queue;
                    }
                  }else if(temp.equalsIgnoreCase("l")){
                    var l =cararray[4];
                    if(l!=null)
                    {
                    l.add(car);
                    cararray[4]=l;
                    }else{
                        queue.add(car);
                        cararray[4]=queue;
                    }
                  }
            }
            file.close();
            while (file2.hasNext()) {
                temp=file2.next();
                perday=file2.nextDouble();
                milage=file2.nextDouble();
                var r=new rate(perday, milage);
                if(temp.equalsIgnoreCase("s")){
                    rates[0]=r;
                }else if(temp.equalsIgnoreCase("c")){
                    rates[1]=r;
                  }else if(temp.equalsIgnoreCase("m")){
                    rates[2]=r;
                  }else if(temp.equalsIgnoreCase("w")){
                    rates[3]=r;
                  }else if(temp.equalsIgnoreCase("l")){
                    rates[4]=r;
                  }
            }
            file2.close();
            while (file3.hasNext()) {
                temp=file3.next();
                  if(temp.equalsIgnoreCase("C")){
                    for(int i=0;i<5;i++)
                    {
                        queue=rentedarray[i];
                        while(!queue.isEmpty())
                     {
                        System.out.println(queue.remove().toString());
                     }
                    }
                  }else if(temp.equalsIgnoreCase("A")){
                     temp=file3.next();
                     int days=file.nextInt();
                     milage=file3.nextDouble();
                     String target=file3.next();
                     int cnt=0;
                     if(temp.equalsIgnoreCase("s")){
                       queue=cararray[0];
                       rentqueue=rentedarray[0];
                     }else if(temp.equalsIgnoreCase("c")){
                       queue=cararray[1];
                       rentqueue=rentedarray[1];
                       cnt=1;
                     }else if(temp.equalsIgnoreCase("m")){
                      queue=cararray[2];
                      rentqueue=rentedarray[2];
                      cnt=2;
                     }else if(temp.equalsIgnoreCase("w")){
                      queue=cararray[3];
                      rentqueue=rentedarray[3];
                      cnt=3;
                     }else if(temp.equalsIgnoreCase("l")){
                      queue=cararray[4];
                      rentqueue=rentedarray[4];
                      cnt=4;
                     }
                     double totalmilage=milage;
                     String current="";
                     var rented= rentqueue.remove();
                     current=rented.getname();
                     while(!rentqueue.isEmpty()&&!target.equals(current)){
                       rented= rentqueue.remove();
                       current=rented.getname();
                     }
                     totalmilage-=rented.getmiles();
                     double cost=totalmilage*(rates[cnt].getmile());
                     cost+=days*rates[cnt].getday();
                     System.out.println("Days : "+days);
                     System.out.println("Cost Per Day : "+rates[cnt].getday());
                     System.out.println("Miles : "+totalmilage);
                     System.out.println("Cost Per Mile: "+rates[cnt].getmile());
                     System.out.println("Total : "+cost);
                  }else if(temp.equalsIgnoreCase("R")){
                    temp=file3.next();
                     if(temp.equalsIgnoreCase("s")){
                       queue=cararray[0];
                       if(queue.isEmpty())
                       {
                        temp="c";
                       }else{
                         rentqueue=rentedarray[0];
                         rentqueue.add(queue.remove());
                         rentedarray[0]=rentqueue;
                         cararray[0]=queue;
                       }
                     }else if(temp.equalsIgnoreCase("c")){
                       queue=cararray[1];
                       if(queue.isEmpty())
                       {
                        temp="m";
                       }else{
                         rentqueue=rentedarray[1];
                         rentqueue.add(queue.remove());
                         rentedarray[1]=rentqueue;
                         cararray[1]=queue;
                       }
                     }else if(temp.equalsIgnoreCase("m")){
                      queue=cararray[2];
                      if(queue.isEmpty())
                       {
                        temp="w";
                       }else{
                         rentqueue=rentedarray[2];
                         rentqueue.add(queue.remove());
                         rentedarray[2]=rentqueue;
                         cararray[2]=queue;
                       }
                     }else if(temp.equalsIgnoreCase("w")){
                      queue=cararray[3];
                      if(queue.isEmpty())
                       {
                        temp="l";
                       }else{
                         rentqueue=rentedarray[3];
                         rentqueue.add(queue.remove());
                         rentedarray[3]=rentqueue;
                         cararray[3]=queue;
                       }
                     }else if(temp.equalsIgnoreCase("l")){
                      queue=cararray[4];
                      if(queue.isEmpty())
                       {
                        
                       }else{
                         rentqueue=rentedarray[4];
                         rentqueue.add(queue.remove());
                         rentedarray[4]=rentqueue;
                         cararray[4]=queue;
                       }
                     }
                  }else if(temp.equalsIgnoreCase("L")){
                    temp=file3.next();
                     if(temp.equalsIgnoreCase("s")){
                       queue=cararray[0];
                     }else if(temp.equalsIgnoreCase("c")){
                       queue=cararray[1];
                     }else if(temp.equalsIgnoreCase("m")){
                      queue=cararray[2];
                     }else if(temp.equalsIgnoreCase("w")){
                      queue=cararray[3];
                     }else if(temp.equalsIgnoreCase("l")){
                      queue=cararray[4];
                     }
                     while(!queue.isEmpty())
                     {
                        System.out.println(queue.remove().toString());
                     }
                  }
            }
            file3.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
class cars{
    private Double miles;
    private String carname;
    public cars(String name,Double milage){
        carname=name;
        miles=milage;
    }
    public void updatemiles(Double milage){
        miles+=milage;
    }
    public String getname(){
        return carname;
    }
    public Double getmiles(){
        return miles;
    }
    public String toString(){
        return carname+"\t"+miles;
    }
}
class rate{
    private Double day;
    private Double mile;
    public rate(Double perday,Double permile){
        day=perday;
        mile=permile;
    }
    public Double getday(){
        return day;
    }
    public Double getmile(){
        return mile;
    }
}
