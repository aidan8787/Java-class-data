package Q1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class prog705x {
    public static void main(String[] args) {
        ArrayList<ArrayList<String[]>> poemlines = new ArrayList<>();
        try {
            var filecode = new Scanner(new File("Langdat/prog705x.txt"));
            var file = new Scanner(new File("Langdat/prog512h.dat"));
            while (file.hasNext()) {
                ArrayList<String[]> words = new ArrayList<>();
                String line = file.nextLine();
                String[] temp = line.split(" ");
                for (var word : temp) {
                    String[] chars = word.split("");
                    words.add(chars);
                }
                poemlines.add(words);
            }
            file.close();
            String codeword = "";
            while (filecode.hasNextLine()) {
                String lines = filecode.nextLine();
                String part1 = lines.substring(0, 2);
                lines = lines.substring(2);
                String part2 = lines.substring(0, 1);
                lines = lines.substring(1);
                String part3 = lines;
                lines = part1 + part2 + part3;
                int numlines = (Integer.parseInt(part1)) - 1;
                int numword = (Integer.parseInt(part2)) - 1;
                int letter = (Integer.parseInt(part3)) - 1;
                System.out.println("Line:" + numlines);
                System.out.println("Word:" + numword);
                System.out.println("char:" + letter);
                System.out.println("Code:   " + lines);
                ArrayList<String[]> w = poemlines.get(numlines);
                String[] temp = w.get(numword);
                String str = "";
                for (var t : temp) {
                    str += t;
                }
                System.out.println(str);
                String codeletter = "";
                codeletter = temp[letter];
                codeword = codeword + codeletter;
                System.out.println("Code:   " + lines + "   Letter: " + codeletter);
            }
            System.out.println("Code Word: " + codeword);
            filecode.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/* 
 Line:7
Word:2
char:0
Code:   0831
clouds
Code:   0831   Letter: c
Line:0
Word:0
char:1
Code:   0112
Good
Code:   0112   Letter: o
Line:6
Word:1
char:1
Code:   0722
to
Code:   0722   Letter: o
Line:8
Word:0
char:3
Code:   0914
Hail
Code:   0914   Letter: l
Line:7
Word:1
char:0
Code:   0821
bright
Code:   0821   Letter: b
Line:11
Word:3
char:2
Code:   1243
fields
Code:   1243   Letter: e
Line:14
Word:4
char:0
Code:   1551
as
Code:   1551   Letter: a
Line:16
Word:1
char:3
Code:   1724
morning
Code:   1724   Letter: n
Line:17
Word:0
char:5
Code:   1816
Things
Code:   1816   Letter: s
Code Word: coolbeans
*/