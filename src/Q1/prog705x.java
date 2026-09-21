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
               int lines=Integer.parseInt(line.substring(0,2));
               int word=Integer.parseInt(line.substring(2, 3));
               int letter=Integer.parseInt(line.substring(3));
               lines--;
               word--;
               letter--;
               var w=poemlines.get(lines);
               var temp=w.get(word);
               String codeletter=temp[letter];
                codeword+=codeletter;
               System.out.println("Code:   "+line+"   Letter: "+codeletter);
            }
            System.out.println("Code Word: "+codeword);
            filecode.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
