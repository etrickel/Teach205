import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SongArrayListTest {
    private static final String TEST_INPUT_FILE = "./playlist1.txt";
    /**
     * This method tests the add() method of the SongArrayList class. It adds multiple songs
     * to the song list and verifies that the added songs are stored correctly. It also checks the
     * presence of a song from the test file and verifies the total size of the song list.
     * @throws FileNotFoundException if the test input file is not found.
     */
    @org.junit.jupiter.api.Test
    void add() throws FileNotFoundException {
        SongArrayList songList = new SongArrayList(TEST_INPUT_FILE);

        int nbrOfLoadedSongs = songList.size();

        // Test adding songs
        songList.add("Song A");
        songList.add("Song B");
        songList.add("Song C");
        songList.add("Song D");
        songList.add("Song E");
        songList.add("Song F");
        songList.add("Song G");
        songList.add("Song H");
        songList.add("Song I");
        songList.add("Song J");

        // Verify the added songs
        Assertions.assertEquals("Song A", songList.get(nbrOfLoadedSongs + 0));
        Assertions.assertEquals("Song B", songList.get(nbrOfLoadedSongs + 1));
        Assertions.assertEquals("Song C", songList.get(nbrOfLoadedSongs + 2));
        Assertions.assertEquals("All the Small Things", songList.get(0));  // this is from test file

        Assertions.assertEquals(songList.size(), 35);
    }

    /**
     * This method tests the set() method of the SongArrayList class. It changs the song at a
     * specific index and verifies that the correct song no exists.
     * @throws FileNotFoundException if the test input file is not found.
     */
    @org.junit.jupiter.api.Test
    void set() throws FileNotFoundException {
        SongArrayList songList = new SongArrayList(TEST_INPUT_FILE);
        songList.set(1, "1979");
        // Verify the change
        Assertions.assertEquals("1979", songList.get(1));
        // Verify the remaining songs
        Assertions.assertEquals("All the Small Things", songList.get(0));
        Assertions.assertEquals("Creep", songList.get(24));
    }

    /**
     * This method tests the delete() method of the SongArrayList class. It deletes a song at a
     * specific index and verifies that the correct song was deleted. It also checks the remaining songs
     * after the deletion.
     * @throws FileNotFoundException if the test input file is not found.
     */
    @org.junit.jupiter.api.Test
    void delete() throws FileNotFoundException {
        SongArrayList songList = new SongArrayList(TEST_INPUT_FILE);
        String deletedSong = songList.remove(1);

        // Verify that the correct song was deleted
        Assertions.assertEquals("Bitter Sweet Symphony", deletedSong);

        // Verify the remaining songs
        Assertions.assertEquals("All the Small Things", songList.get(0));
        Assertions.assertEquals("Creep", songList.get(23));
        //assertNull(songList.get(24));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            songList.get(24);
        });
    }

    /**
     * This method tests the scenario where more songs are deleted than the current size of the
     * song list. It deletes all songs from the list and verifies that the first and last indices are null.
     * @throws FileNotFoundException if the test input file is not found.
     */
    @org.junit.jupiter.api.Test
    void deleteTooMany() throws FileNotFoundException {
        SongArrayList songList = new SongArrayList(TEST_INPUT_FILE);
        int nbrOfSongs = songList.size();
        for (int i=0; i < nbrOfSongs; i++){
            songList.remove(0);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> {
            songList.remove(0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            songList.get(0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            songList.get(24);
        });
//        assertNull(songList.get(0));  // Verify that the first index is now null
//        assertNull(songList.get(24)); // Verify that the last index is still null

    }

    /**
     * This method tests the toString() method of the SongArrayList class. It checks if the string
     * representation of the song list contains specific songs, including the first, a middle, and the last song.
     * @throws FileNotFoundException if the test input file is not found.
     */
    @org.junit.jupiter.api.Test
    void testToString() throws FileNotFoundException {
        SongArrayList songList = new SongArrayList(TEST_INPUT_FILE);
        Assertions.assertTrue(songList.toString().contains("All the Small Things"));     // first song
        Assertions.assertTrue(songList.toString().contains("Smells Like Teen Spirit"));  // middle song
        Assertions.assertTrue(songList.toString().contains("Creep"));                    // last song
    }
}
