package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        //in: a10b4c3
        //out: aaaaaaaaaabbbbccc
        System.out.println(new Main().descriptString("a10b4c3"));
    }

    private String descriptString(String input) {
        String regexp = "[A-Za-z]";

        StringBuilder stringBuilder = new StringBuilder();

        char[] chars = input.toCharArray(); //[a, 1, 0, b, 4, c, 3]
        String currentLetter = "";
        String currentNumber = "";
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).matches(regexp)) {
                if (currentLetter.isBlank())
                    currentLetter = String.valueOf(chars[i]);

                if (!currentNumber.isBlank()) {
                    int count = Integer.parseInt(currentNumber);
                    for (int j = 0; j < count; j++) {
                        stringBuilder.append(currentLetter);
                    }
                    currentNumber = "";
                    currentLetter = String.valueOf(chars[i]);
                }
            } else {
                currentNumber += String.valueOf(chars[i]);
            }

            if (i == chars.length - 1) {
                int count = Integer.parseInt(currentNumber);
                for (int j = 0; j < count; j++) {
                    stringBuilder.append(currentLetter);
                }
            }
        }
        return stringBuilder.toString();
    }
}
