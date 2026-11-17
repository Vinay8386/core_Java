package Read_Analyze_Java_Files;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReaderExample {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader(
                "Read_Analyze_Java_Files/BankService.java",
                StandardCharsets.UTF_8)) {

            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
