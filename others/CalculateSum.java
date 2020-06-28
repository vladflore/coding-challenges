import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CalculateSum {
    public static void main(String[] args) throws IOException {
        Path dataset = Paths.get("dataset_91033.txt");
        System.out.println(Files.readAllLines(dataset).stream().mapToInt(Integer::valueOf).sum());
    }
}