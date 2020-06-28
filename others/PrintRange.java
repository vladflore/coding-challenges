import java.io.FileWriter;
import java.io.IOException;

public class PrintRange {
    public static void main(String[] args) {
        String filepath = "file.txt"; // relative path to the file
        printRangeToFile(filepath, false, 0, 10);
        printRangeToFile(filepath, true, 10, 20);
        printRangeToFile(filepath, false, 20, 30);
    }

    public static void printRangeToFile(String file, boolean append, int fromIncl, int toExcl) {
        try (FileWriter writer = new FileWriter(file, append)) {
            for (int i = fromIncl; i < toExcl; i++) {
                writer.write(i + " ");
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}