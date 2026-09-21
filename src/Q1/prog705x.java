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
            var file = new Scanner(new File("Langdat/prog512h.txt"));
            while (file.hasNext()) {
               String line = file.nextLine();
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
               String line = filecode.nextLine();
               var part1=line.substring(0,2);
               var part2=line.substring(2, 3);
               var part3=line.substring(3,4);
               int lines=Integer.parseInt(part1);
               int word=Integer.parseInt(part2);
               int letter=Integer.parseInt(part3);
                System.out.println("Line:"+lines);
                System.out.println("Word:"+word);
                System.out.println("char:"+letter);
                System.out.println("Code:   "+line);
               ArrayList<String[]> w=poemlines.get(lines-1);
              String[] temp=w.get(word-1);
               String codeletter=temp[letter-1];
                codeword=codeword+codeletter;
               System.out.println("Code:   "+line+"   Letter: "+codeletter);
            }
            System.out.println("Code Word: "+codeword);
            filecode.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
