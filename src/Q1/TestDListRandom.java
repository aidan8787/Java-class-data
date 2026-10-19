package Q1;
import DataStructures.DoublyLinkedList;
public class TestDListRandom {
    public static void main(String[] args) {
        var list= new DoublyLinkedList<Integer>();
        for(int i=0;i<20;i++){
            list.addsorted((int)(Math.random()*100));
        }
        list.print();
        list.printbackward();
        list.addsorted((int)(Math.random()*100));
        list.print();
        list.printbackward();
        list.remove(1);
        System.out.println("Removed index 1");
        list.print();
        list.printbackward();
    }
}
