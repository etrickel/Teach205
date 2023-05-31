import java.io.FileNotFoundException;
import java.util.Collections;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("My Playlist App\n");
        try {
            SimpleSongArrayList sal = new SimpleSongArrayList("./playlist1.txt");
            System.out.println(sal.toString());
            System.out.println(sal.get(5));
            sal.set(1, "1979");
            System.out.println(sal.remove(5));
            System.out.println(sal.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}