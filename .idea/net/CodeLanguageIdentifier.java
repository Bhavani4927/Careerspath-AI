package org.Careerspath.net;

import java.util.Scanner;

public class CodeLanguageIdentifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your code snippet:");
        String codeSnippet = scanner.nextLine();

        String language = identifyLanguage(codeSnippet);
        System.out.println("Identified language: " + language);

        scanner.close();
    }

    public static String identifyLanguage(String code) {
        // Check for specific keywords, patterns, or syntax to identify the language
        if (code.contains("public class") || code.contains("public static void main")) {
            return "Java";
        } else if (code.contains("def ") || code.contains("print(") || code.contains("import ")) {
            return "Python";
        } else if (code.contains("function") || code.contains("console.log")) {
            return "JavaScript";
        } else if (code.contains("<html>") || code.contains("<body>") || code.contains("<head>")) {
            return "HTML";
        } else if (code.contains("#include") || code.contains("int main")) {
            return "C/C++";
        } else if (code.contains("struct") || code.contains("typedef")) {
            return "C/C++";
        } else {
            return "Unknown"; // If no match is found
        }
    }
}