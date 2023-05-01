package ua.lviv.iot.algo.part2.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveWordsWithNumbers {
    public String removeWordsWithNumbers(String text, int minDigits) {
        String regex = "\\b[A-Za-z]+[\\d-]{" + minDigits + ",}[A-Za-z]+\\b";
        Pattern wordsWithNumbers = Pattern.compile(regex);
        Matcher matcher = wordsWithNumbers.matcher(text);
        var result = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(result, "");
        }
        matcher.appendTail(result);
        return result.toString();
    }

    public static void main(String[] args) {
        RemoveWordsWithNumbers remover = new RemoveWordsWithNumbers();

        if (args.length == 2) {
            String scannedText = args[0];
            int minDigits = Integer.parseInt(args[1]);
            String secondResult = remover.removeWordsWithNumbers(scannedText, minDigits);
            System.out.println(secondResult);
        } else {
            System.out.println("no args");
        }
    }
}
