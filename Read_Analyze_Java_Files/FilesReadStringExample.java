package Read_Analyze_Java_Files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class FilesReadStringExample {

    public static void main(String[] args) {

        try {

            Path path = Path.of("Read_Analyze_Java_Files/BankService.java");

            String sourceCode = Files.readString(path);

            System.out.println(sourceCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
