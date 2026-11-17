package Read_Analyze_Java_Files;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;

public class ASTExample {

    public static void main(String[] args) {

        String sourceCode = """
            class BankService {
                void deposit() {}
            }

            class PaymentService {
                void transfer() {}
            }
            """;

        CompilationUnit cu = StaticJavaParser.parse(sourceCode);

        System.out.println("Direct Children: "
                + cu.getChildNodes().size());

        for (Node node : cu.getChildNodes()) {
            System.out.println(node.getClass().getSimpleName());
        }
    }
}
