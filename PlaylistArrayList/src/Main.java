import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("My Playlist App V2\n");
        try {
            SongArrayList sal = new SongArrayList("./playlist1.txt");
            System.out.println(sal.toString());
            System.out.println(sal.get(5));
            System.out.println(sal.remove(5));
            System.out.println(sal.toString());
            Collections.sort(sal);
            System.out.println(sal.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}