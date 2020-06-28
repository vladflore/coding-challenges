import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class WorldPopulation {
    public static void main(String[] args) throws IOException {
        NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
        LinkedHashMap<String, Long> data = Files.readAllLines(Paths.get("dataset_91069.txt")).stream().skip(1)
                .collect(Collectors.toMap(line -> line.split("\\t")[0], line -> {
                    try {
                        return format.parse(line.split("\\t")[1]).longValue();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return null;
                }, (v1, v2) -> v1, LinkedHashMap::new));

        List<String> years = new ArrayList<>(data.keySet());
        long currentMax = 0;
        int y = 0;
        for (int i = 0; i < years.size() - 1; i++) {
            long diff = data.get(years.get(i + 1)) - data.get(years.get(i));
            if (currentMax < diff) {
                currentMax = diff;
                y = Integer.parseInt(years.get(i + 1));
            }
        }
        System.out.println(y);
    }
}