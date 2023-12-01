package org.Careerspath.net;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder codeInput = new StringBuilder();
        System.out.println("Enter the code snippet to analyze (Press Enter twice to finish):");

        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            codeInput.append(line).append("\n");
        }

        String analysis = summarizeCode(codeInput.toString());
        System.out.println(analysis);

        scanner.close();
    }

    public static String summarizeCode(String code) {
        StringBuilder explanation = new StringBuilder();

        // Pattern to extract relevant information from the code
        Pattern pattern = Pattern.compile("(import .*?;)\\s*|([A-Za-z0-9]+\\s*=\\s*new\\s+[A-Za-z0-9]+\\(.*?\\))\\s*|((String|URL|HttpURLConnection|BufferedReader|InputStreamReader)\\s+[A-Za-z0-9]+\\s*=\\s*.*?;)\\s*|((connection\\..*?;)\\s*)|((System\\..*?;)\\s*)|((try\\s*\\{)|(} catch \\(.*?\\) \\{)|(e.printStackTrace\\(\\);))");

        Matcher matcher = pattern.matcher(code);

        explanation.append("Code Summary:\n");

        while (matcher.find()) {
            String matched = matcher.group();

            if (matched != null) {
                // Analyzing different parts of the code and providing summarized explanations
                if (matched.startsWith("import")) {
                    explanation.append("- Imports a package.\n");
                } else if (matched.contains("=")) {
                    explanation.append("- Initializes or assigns a variable.\n");
                } else if (matched.startsWith("connection")) {
                    explanation.append("- Uses a connection method.\n");
                } else if (matched.startsWith("System")) {
                    explanation.append("- Uses System methods.\n");
                } else if (matched.startsWith("try")) {
                    explanation.append("- Starts a try block for exception handling.\n");
                } else if (matched.startsWith("} catch")) {
                    explanation.append("- Handles exceptions.\n");
                } else if (matched.startsWith("e.printStackTrace")) {
                    explanation.append("- Prints the stack trace of an exception.\n");
                }
            }
        }

        return explanation.toString();
    }
}
