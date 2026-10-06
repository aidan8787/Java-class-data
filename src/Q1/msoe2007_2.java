package Q1;

import java.util.Scanner;

public class msoe2007_2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a line");
        String sentence=input.nextLine();
        int cnta=0;
        String tempa=sentence;
        tempa=tempa.toLowerCase();
        int indexa=tempa.indexOf("a");
        while(indexa>-1){
            cnta++;
            tempa=tempa.substring(0,indexa)+tempa.substring(indexa+1);
            indexa=tempa.indexOf("a");
        }
        String tempi=sentence;
        tempi=tempi.toLowerCase();
        int indexi=tempi.indexOf("i");
        int cnti=0;
        while(indexi>-1){
            cnti++;
            tempi=tempi.substring(0,indexi)+tempi.substring(indexi+1);
            indexi=tempi.indexOf("i");
        }
        String tempo=sentence;
        tempo=tempo.toLowerCase();
        int indexo=tempo.indexOf("o");
        int cnto=0;
        while(indexo>-1){
            cnto++;
            tempo=tempo.substring(0,indexo)+tempo.substring(indexo+1);
            indexo=tempo.indexOf("o");
        }
        String tempe=sentence;
        tempe=tempe.toLowerCase();
        int indexe=tempe.indexOf("e");
        int cnte=0;
        while(indexe>-1){
            cnte++;
            tempe=tempe.substring(0,indexe)+tempe.substring(indexe+1);
            indexe=tempe.indexOf("e");
        }
        String tempu=sentence;
        tempu=tempu.toLowerCase();
        int indexu=tempu.indexOf("u");
        int cntu=0;
        while(indexu>-1){
            cntu++;
            tempu=tempu.substring(0,indexu)+tempu.substring(indexu+1);
            indexu=tempu.indexOf("u");
        }
        int total=cnta+cnte+cnti+cnto+cntu;
        System.out.println("The total number of vowels is "+total);
    }
}
// Enter a line
// Enter A Line               a
// The total number of vowels is 6