import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        grades.forEach(g -> {
            if (g < 38) {
                roundedGrades.add(g);
            } else {
                int nextMultipleGreaterThan = nextMultipleGreaterThan(g, 5);
                if (nextMultipleGreaterThan - g < 3) {
                    roundedGrades.add(nextMultipleGreaterThan);
                } else {
                    roundedGrades.add(g);
                }
            }
        });
        return roundedGrades;
    }

    private static int nextMultipleGreaterThan(int base, int multipleOf) {
        int start = 0;
        while ((start = start + 5) <= base) {
        }
        return start;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
