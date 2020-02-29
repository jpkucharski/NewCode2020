package jpk.com.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Replacer {

    private static final String FILE_PATH = "/home/peter/Desktop/file.txt";
    private static final String REPLACE_ALL= "&";
    private static final String REPLACE_WITH = " ";

    public static void main(String[] args) {
        try{
            Path path = Paths.get(FILE_PATH);
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines
                    .map(line -> line.replaceAll(REPLACE_ALL,REPLACE_WITH))
                    .collect(Collectors.toList());
            Files.write(path,replaced);
            lines.close();
            System.out.println("Success!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}



