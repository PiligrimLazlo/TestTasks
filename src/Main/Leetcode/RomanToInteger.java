package Main.Leetcode;

public class RomanToInteger {
    public static void main(String[] args) {
        //https://leetcode.com/problems/roman-to-integer/

        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));

    }

    public int romanToInt(String s) {
        char[] symbols = s.toCharArray();
        int result = 0;

        for (int i = 0; i < symbols.length; i++) {
            switch (symbols[i]) {
                case 'M' -> {
                    result += 1000;
                }
                case 'D' -> {
                    result += 500;
                }
                case 'C' -> {
                    if ((i != symbols.length - 1) && symbols[i + 1] == 'D') {
                        result += 400;
                        i++;
                    } else if ((i != symbols.length - 1) && symbols[i + 1] == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                }
                case 'L' -> {
                    result += 50;
                }
                case 'X' -> {
                    if ((i != symbols.length - 1) && symbols[i + 1] == 'L') {
                        result += 40;
                        i++;
                    } else if ((i != symbols.length - 1) && symbols[i + 1] == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                }
                case 'V' -> {
                    result += 5;
                }
                case 'I' -> {
                    if ((i != symbols.length - 1) && symbols[i + 1] == 'V') {
                        result += 4;
                        i++;
                    } else if ((i != symbols.length - 1) && symbols[i + 1] == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
}
