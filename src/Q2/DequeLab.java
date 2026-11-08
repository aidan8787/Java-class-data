package Q2;
import DataStructures.Deque;
public class DequeLab {
    public static void main(String[] args){
        var deq= new Deque<Integer>();
        for(int i=0;i<10;i++){
            deq.enqueFront(i);
        }
        for(int i=10;i<20;i++){
            deq.enqueRear(i);
        }
        System.out.println(deq.size());
        System.out.println(deq.peekFront());
        System.out.println(deq.peekRear());
        System.out.println(deq.dequeFront());
        System.out.println(deq.dequeRear());
        System.out.println(deq.size());
        var rand= new java.util.Random(42);
          for(int i=0;i<50;i++){
            deq.enqueFront(rand.nextInt(50));
        }
        for(int i=0;i<48;i++){
            deq.dequeFront();
        }
        System.out.println("New Size: "+deq.size());
        System.out.println(deq.peekFront());
        System.out.println(deq.peekRear());
    }
}
