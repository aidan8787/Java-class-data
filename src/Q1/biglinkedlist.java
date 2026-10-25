package Q1;
import DataStructures.IntLinkedList;
public class biglinkedlist {
 public static void main(String[] args) {
    var list=new IntLinkedList();
    for(int i=0;i<10;i++)
    {
        list.addfront((int)(Math.random()*100+1));
    }
    var iter=list.iterator();
    while(iter.hasNext())
        System.out.print(iter.next()+" ");
    System.out.println();
    list.addlast(10);
    System.out.println("Length of list: "+list.getcount());
    list.addspot(8,(int)(Math.random()*200+1));
    System.out.println("Added 10 to the final index and a random number at index 8");
    list.print();
    System.out.println("Is empty: "+list.isempty());
    System.out.println("First element: "+list.getFirst()+"\n Last element: "+list.getLast());
    System.out.print("Get index 87: "+list.get(8));
    System.out.println("Remove First Last and 1 indexes");
    list.remove(1);
    list.removefirst();
    list.removelast();
    list.print();
    System.out.println("Sort List and print list backward");
    list.sort();
    list.print();
    var temp=list.getreverse();
    temp.print();
    System.out.println("The list has a max of "+list.max()+" a min of "+list.min()+" the maximum index is "+list.indexofmax()+" the last maximum index is "+list.lastindexofmax());
    System.out.println("Total amount of even numbers: "+list.countEvens()+"\n Total amount of numbers under 10: "+list.countLess10());
    System.out.println(" Remove all odd numbers and 58s");
    list.removeodd();
    System.out.println("Number of 58s removed: "+list.lose58());
    list.print();
    System.out.println("Contains 87: "+list.contains(87));
    System.out.println("The avrage is: "+list.avg());
    System.out.println(" No more list ");
    list.clear();
    list.print();
 }   
}
