import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SongArrayList extends ArrayList<String> {
    /**
     * Constructor that takes an input file and a starting size
     * @param inputFile the path to the playlist file
     * @throws FileNotFoundException if the test input file is not found.
     */
    public SongArrayList(java.lang.String inputFile) throws FileNotFoundException {
        Scanner input = new Scanner(new File(inputFile));
        while (input.hasNextLine()){
            String line = input.nextLine();
            this.add(line);
        }
    }
}
