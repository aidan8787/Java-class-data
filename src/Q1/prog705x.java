package Q1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prog705x {
    public static void main(String[] args) {
        ArrayList<ArrayList<String[]>> poemlines= new ArrayList<>();
        ArrayList<String[]> words= new ArrayList<>();
        try {
            var filecode = new Scanner(new File("Langdat/prog705x.txt"));
            var file = new Scanner(new File("Langdat/prog512h.dat"));
            while (file.hasNext()) {
               String line = file.next();
               String[] temp=line.split(" ");
               for(var word:temp){
                String[] chars=word.split("");
                words.add(chars);
               }
               poemlines.add(words);
            }
            file.close();
            String codeword="";
            while (filecode.hasNextLine()) {
               String lines = filecode.nextLine();
               String part1=lines.substring(0,2);
               lines=lines.substring(2);
               String part2=lines.substring(0, 1);
               lines=lines.substring(1);
               String part3=lines;
               lines=part1+part2+part3;
               int numlines=(Integer.parseInt(part1))-1;
               int numword=(Integer.parseInt(part2))-1;
               int letter=(Integer.parseInt(part3))-1;
                System.out.println("Line:"+numlines);
                System.out.println("Word:"+numword);
                System.out.println("char:"+letter);
                System.out.println("Code:   "+lines);
               ArrayList<String[]> w=poemlines.get(numlines);
              String[] temp=w.get(numword);
              String str="";
               for(var t:temp){
                 str+=t;
              }
              System.out.println(str);
                String codeletter="";
                  codeletter=temp[letter];
                codeword=codeword+codeletter;
               System.out.println("Code:   "+lines+"   Letter: "+codeletter);
            }
            System.out.println("Code Word: "+codeword);
            filecode.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
