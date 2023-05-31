import java.io.FileNotFoundException;
import java.util.StringJoiner;

public class Main {
    private static final String TEST_INPUT_FILE = "./playlist1.txt";
    /**
     * Method to convert the SimpleSongArrayList to a string representation
     * @return String
     */
    private static String listToString(SimpleSongArrayList sal){
        StringJoiner stringJoiner = new StringJoiner(",");
        for (int i=0; i < sal.currentSize; i++){ // for-each example
            stringJoiner.add(sal.get(i));
        }
        return stringJoiner.toString();
    }
    public static void main(String[] args) {
        System.out.println("My Playlist App\n");
        try {
            SimpleSongArrayList sal = new SimpleSongArrayList();
            sal.loadPlaylist(TEST_INPUT_FILE);
            sal.add("1979"); // adds to end of list
            String output = listToString(sal);
            System.out.println(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}