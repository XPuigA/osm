package base;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Utils {

    public static String getResourceFileAsString(String fileName) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        String path = ".\\src\\test\\resources\\" + fileName;
        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            throw e;
        }
        return contentBuilder.toString();
    }
}
