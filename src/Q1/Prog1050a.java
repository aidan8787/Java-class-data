import java.io.*;
import java.util.*;
import java.text.*;

public class Template {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/REPLACE.dat"));

            while (file.hasNext()) {

            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
