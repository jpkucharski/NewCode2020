package jpk.com.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Replacer {

    //    file path - File Should be placed in main folder of the project next to src folder
    private static final String FILE_PATH = "file.txt";

    public static void main(String[] args) {
        try {
            Path path = Paths.get(FILE_PATH);
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines
                    .map(
                            line -> line
                                    .replaceAll("&nbsp;", "")
                                    .replaceAll("<br>", "")
                                    .replaceAll("&gt;", ">")
                                    .replaceAll("&lt;", "<")
                    )
                    .collect(Collectors.toList());
            Files.write(path, replaced);
            lines.close();
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}