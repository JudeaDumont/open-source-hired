package z.util.FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileAsString {
    public static String readFileAsString(String pathname) throws FileNotFoundException {
        StringBuilder readContents = new StringBuilder();
        try {
            File myObj = new File(
                    pathname);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readContents.append(data).append("\n");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
        return readContents.toString();
    }
}
