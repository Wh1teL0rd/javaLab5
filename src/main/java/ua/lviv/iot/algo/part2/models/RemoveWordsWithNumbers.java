package ua.lviv.iot.algo.part2.models;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveWordsWithNumbers {
    public String removeWordsWithNumbers(String text, int minDigits) {
        String regex = "\\b[A-Za-z]+[\\d-]{" + minDigits + ",}[A-Za-z]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "test text: a12i, a1234b, a12345b, 123a, a123, a12-345b, 12345b, a12345";
        RemoveWordsWithNumbers remover = new RemoveWordsWithNumbers();
        String result = remover.removeWordsWithNumbers(text,5);
        System.out.println(result);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String scannedText = scanner.nextLine();

        System.out.print("Enter the minimum number of digits: ");
        int minDigits = scanner.nextInt();

        scanner.close();

        String secondResult = remover.removeWordsWithNumbers(scannedText, minDigits);
        System.out.println(secondResult);
    }
}
