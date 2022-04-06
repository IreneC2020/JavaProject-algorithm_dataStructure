package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ListFileTest {

    public static void read(String location, List<String> list, List<List<String>> newList)
                                                                    throws FileNotFoundException {
        File    file            = new File(location);
        Scanner input           = new Scanner(file);

        while(input.hasNextLine()) {
            list.add(input.nextLine());
        }

        for (String s : list) {
            String[] wordsArray = s.split(" ");
            List<String> innerList = Arrays.asList(wordsArray);
            // add the arraylist back to the 2 dimensional arraylist,
            newList.add(innerList);
        }

        for (int i = 0; i< list.size(); i++) {
            Collections.reverse(newList.get(i));
        }
        input.close();
    }

    public static void write(String location, List<List<String>> list) throws FileNotFoundException{
        PrintStream output      = new PrintStream(location);
        StringBuilder builder   = new StringBuilder();

        for (List<String> strings : list) {
            for (String data : strings) {           // get each data in each line
                builder.append(data).append(" ");   // add space
            }
            builder.append("\n");                   // go to next line
        }
        output.print(builder);
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation    = "." + File.separator + "data"
                                      + File.separator + "words.txt";
        String outputLocation   = "." + File.separator + "results"
                                      + File.separator + "reverse_words.txt";
        List<String>        list     = new ArrayList<>();
        List<List<String>>  newList  = new ArrayList<>();
        read(inputLocation, list, newList);

        write(outputLocation, newList);
    }
}
