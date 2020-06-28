import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get("file.txt"))));
    }

}