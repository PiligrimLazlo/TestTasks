package Main.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidParentheses {
    public static void main(String[] args) {
        //https://leetcode.com/problems/valid-parentheses/

        System.out.println(new ValidParentheses().isValid("[({])}"));
        ;
    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) return false;

        for (int i = 0; i < chars.length; i++) {
            char first = chars[i];
            switch (first) {
                case '(' -> {
                    boolean er = true;
                    for (int j = chars.length - 1; j > i; j--) {
                        if (chars[j] == ')') {
                            if ((i + j) % 2 == 0) return false;
                            chars[i] = '-';
                            chars[j] = '-';
                            er = false;
                            break;
                        }
                    }
                    if (er) return false;
                }
                case '{' -> {
                    boolean er = true;
                    for (int j = chars.length - 1; j > i; j--) {
                        if (chars[j] == '}') {
                            if ((i + j) % 2 == 0) return false;
                            chars[i] = '-';
                            chars[j] = '-';
                            er = false;
                            break;
                        }
                    }
                    if (er) return false;
                }
                case '[' -> {
                    boolean er = true;
                    for (int j = chars.length - 1; j > i; j--) {
                        if (chars[j] == ']') {
                            if ((i + j) % 2 == 0) return false;
                            chars[i] = '-';
                            chars[j] = '-';
                            er = false;
                            break;
                        }
                    }
                    if (er) return false;
                }
            }
        }
        for (char c: chars) {
            if (c != '-') return false;
        }
        return true;
    }
}
