package Q1;
import DataStructures.DoublyLinkedList;
public class TestDListRandom {
    public static void main(String[] args) {
        var list= new DoublyLinkedList<Integer>();
        for(int i=0;i<20;i++){
            int x=(int)(Math.random()*100);
            list.addsorted(x);
        }
        list.print();
        list.printbackward();
        list.remove(1);
        System.out.println("Removed index 1");
        list.print();
        list.printbackward();
        System.out.println("Pop");
        System.out.println(list.pop());
        list.print();
        list.printbackward();
        System.out.println("Get index 0");
        System.out.println(list.get(0));
        list.print();
        list.printbackward();
        System.out.println("set index 0 to 87");
        list.set(0,87);
        list.print();
        list.printbackward();
        System.out.println("insert 88 at index 0");
        list.insert(0, 88);
        list.print();
        list.printbackward();
    }
}
//0 14 18 22 26 27 33 43 52 56 57 61 61 69 70 79 79 85 91 93 
//93 91 85 79 79 70 69 61 61 57 56 52 43 33 27 26 22 18 14 0 
//Removed index 1
//0 18 22 26 27 33 43 52 56 57 61 61 69 70 79 79 85 91 93 
//93 91 85 79 79 70 69 61 61 57 56 52 43 33 27 26 22 18 0 
//Pop
//93
//0 18 22 26 27 33 43 52 56 57 61 61 69 70 79 79 85 91 
//91 85 79 79 70 69 61 61 57 56 52 43 33 27 26 22 18 0 
//Get index 0
//0
//0 18 22 26 27 33 43 52 56 57 61 61 69 70 79 79 85 91 
//91 85 79 79 70 69 61 61 57 56 52 43 33 27 26 22 18 0 
//set index 0 to 87
//87 18 22 26 27 33 43 52 56 57 61 61 69 70 79 79 85 91 
//91 85 79 79 70 69 61 61 57 56 52 43 33 27 26 22 18 87 
//insert 88 at index 0
//88 87 18 22 26 27 33 43 52 56 57 61 61 69 70 79 79 85 91 
//91 85 79 79 70 69 61 61 57 56 52 43 33 27 26 22 18 87 88