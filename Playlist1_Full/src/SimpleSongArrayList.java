import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class SimpleSongArrayList {
    private static final int DEFAULT_ARRAY_SIZE = 10;   // This constant represents the default size of the array used to store the songs. It is set to 10, but can be modified as needed.
    String[] songs = null;                              // This instance variable is an array of strings that will store the songs.
    int currentSize = 0;                                // This instance variable keeps track of the current index in the songs array.

    /**
     * Constructor that takes an input file and uses the default starting size
     * @param inputFile the path to the file containing songs
     * @throws FileNotFoundException if the test input file is not found.
     */
    public SimpleSongArrayList(String inputFile) throws FileNotFoundException {
        this(inputFile, DEFAULT_ARRAY_SIZE);
    }

    /**
     * Constructor that takes an input file and a starting size
     * @param inputFile the path to the file containing songs
     * @param startingSize the initial size of the array
     * @throws FileNotFoundException if the test input file is not found.
     */
    public SimpleSongArrayList(String inputFile, int startingSize) throws FileNotFoundException {
        songs = new String[startingSize];
        Scanner input = new Scanner(new File(inputFile));
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
     * @throws IndexOutOfBoundsException if the index is less than 0 or larger than the current list
     */
    public String get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + currentSize);
        }
        return songs[index];
    }

    /**
     * Method to change a song at a specific index
     * @param index the index to change
     * @param value the new value
     * @throws IndexOutOfBoundsException if the index is less than 0 or larger than the current list
     */
    public void set(int index, String value) throws IndexOutOfBoundsException {
        songs[index] = value;
    }

    /**
     * Method to delete a song at a specific index
     * @param index the index to remove
     * @return the element that was deleted
     * @throws IndexOutOfBoundsException if the index is less than 0 or larger than the current list
     */
    public String remove(int index) throws IndexOutOfBoundsException{
        String tbdElement = get(index);
        for (int i = index; i < (currentSize-1); i++){ // for-loop example, with currentSize - 1 b/c we use i + 1 below
            // Shift the elements to fill the gap left by the deleted song
            set(i, get(i+1));
        }
        currentSize--;
        return tbdElement;
    }

    /**
     * Method to get the current number of items loaded in the array, not the actual array size
     * @return int
     */
    //
    public int size(){
        return currentSize;
    }

    /**
     * Method to convert the SongArrayList to a string representation
     * @return String
     */
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(",");
        for (String s: songs){ // for-each example
            stringJoiner.add(s);
        }
        return stringJoiner.toString();
    }
}
