package Read_Analyze_Java_Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedReaderExample {

    public static void main(String[] args) {

        try (BufferedReader reader =
                 new BufferedReader(
                     new FileReader(
                         "Read_Analyze_Java_Files/BankService.java",
                         StandardCharsets.UTF_8))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
