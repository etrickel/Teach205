import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleSongArrayList {
    private static final int DEFAULT_ARRAY_SIZE = 10;   // This constant represents the default size of the array used to store the songs. It is set to 10, but can be modified as needed.
    String[] songs = null;                              // This instance variable is an array of strings that will store the songs.
    int currentSize = 0;                                // This instance variable keeps track of the current index in the songs array.

    /**
     * Method to add songs from the provided file path
     * @param filePath the path to the file containing playlist
     * @throws FileNotFoundException if the test input file is not found.
     */
    public void loadPlaylist(String filePath) throws FileNotFoundException {
        songs = new String[DEFAULT_ARRAY_SIZE];
        Scanner input = new Scanner(new File(filePath));
        while (input.hasNextLine()){
            String line = input.nextLine();
            add(line);
        }
    }

    /**
     * Method to add a song to the array
     * @param song the songs to be added to the list
     */
    public void add(String song){
        songs[currentSize] = song;
        currentSize++;
        if (currentSize % DEFAULT_ARRAY_SIZE == 0){
            // If the array is full, create a new array with increased size and copy the elements
            String[] newArray = new String[currentSize +DEFAULT_ARRAY_SIZE];
            System.arraycopy(songs, 0, newArray, 0, songs.length);
            songs = newArray;
        }
    }

    /**
     * Method to retrieve a song at a specific index
     * @param index the index to retrieve from the list
     * @return the selected song
     */
    public String get(int index) {
        return songs[index];
    }

}
