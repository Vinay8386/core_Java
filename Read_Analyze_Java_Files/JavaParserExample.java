package Read_Analyze_Java_Files;

import java.io.File;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class JavaParserExample {

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser.parse(
            new File("Read_Analyze_Java_Files/BankService.java")
        );

        // Identify classes
        cu.findAll(ClassOrInterfaceDeclaration.class)
          .forEach(cls -> {
              System.out.println(
                  "Class: " + cls.getNameAsString()
              );
          });

        // Identify methods
        cu.findAll(MethodDeclaration.class)
          .forEach(method -> {
              System.out.println(
                  "Method: " + method.getNameAsString()
              );
          });
    }
}
