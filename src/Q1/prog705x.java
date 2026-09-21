package Q1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prog705x {
    public static void main(String[] args) {
        ArrayList<String[]> poemlines= new ArrayList<>();
        try {
            var file = new Scanner(new File("Langdat/prog705x.txt"));
            var filecode = new Scanner(new File("Langdat/prog512h.dat"));
            while (file.hasNext()) {
               String line = file.nextLine();
               String[] chars=line.split("");
               poemlines.add(chars);
            }
            file.close();
            String codeword="";
            while (filecode.hasNext()) {
               String line = filecode.nextLine();
               int lines=Integer.parseInt(line.substring(1,3));
               int letter=Integer.parseInt(line.substring(3,line.length()));
               var temp=poemlines.get(lines);
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
