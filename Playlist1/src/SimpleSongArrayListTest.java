import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;

class SimpleSimpleSongArrayListTest {
    private static final String TEST_INPUT_FILE = "./playlist1.txt";
    /**
     * This method tests the add() method of the SimpleSongArrayList class. It adds multiple songs
     * to the song list and verifies that the added songs are stored correctly. It also checks the
     * presence of a song from the test file and verifies the total size of the song list.
     * @throws FileNotFoundException if the test input file is not found.
     */
    @org.junit.jupiter.api.Test
    void add() throws FileNotFoundException {
        SimpleSongArrayList songList = new SimpleSongArrayList();

        songList.loadPlaylist(TEST_INPUT_FILE);
        int nbrOfLoadedSongs = 25;

        // Test adding songs
        songList.add("Song A");
        songList.add("Song B");
        songList.add("Song C");

        // Verify the added songs
        Assertions.assertEquals("Song A", songList.get(nbrOfLoadedSongs));
        Assertions.assertEquals("Song B", songList.get(nbrOfLoadedSongs + 1));
        Assertions.assertEquals("Song C", songList.get(nbrOfLoadedSongs + 2));
        Assertions.assertEquals("All the Small Things", songList.get(0));  // this is from test file

    }

}