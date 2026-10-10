package Q1;
import DataStructures.Linkedlist;
public class TestLinkedList {
    public static void main(String[] args) {
        var list=new Linkedlist<Double>();
        for(double x: new double[]{1.,2.,3.,4.,5.})
            list.add(x);
        list.print();
        list.remove(2);
        list.print();
        list.remove(0);
        list.print();
        list.remove(1);
        list.print();
    }
}
