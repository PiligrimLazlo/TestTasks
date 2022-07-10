package Main.Leetcode;

public class IntegerToRoman {
    public static void main(String[] args) {
        //https://leetcode.com/problems/integer-to-roman/

        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(60));

    }

    //  1 <= num <= 3999
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        //
        //  1994/1000=1 M
        //  1994 - (1000 * 1)= 994
        //  994%100=9 CM
        //  994-(100 * 9) =94
        //  94/10 = 9 XC
        //  94-(10*9) = 4 IV
        //
        //

        //тысячи
        int amount = num / 1000; // 1
        result.append(repeatAppend(amount, "M"));

        //сотни
        num = num - amount * 1000; // 1994 - (1 * 1000)= 994
        amount = num / 100; // 994 % 100 = 9

        if (amount == 4) {
            result.append("CD");
        } else if (amount == 9) {
            result.append("CM");
        } else {
            if (amount < 5) {
                result.append(repeatAppend(amount, "C"));
            } else {
                result.append("D");
                result.append(repeatAppend(amount - 5, "C"));
            }
        }


        //десятки
        num = num - amount * 100; // 994-(9 * 100) =94
        amount = num / 10; // 94/10 = 9 XC

        if (amount == 4) {
            result.append("XL");
        } else if (amount == 9) {
            result.append("XC");
        } else {
            if (amount < 5) {
                result.append(repeatAppend(amount, "X"));
            } else {
                result.append("L");
                result.append(repeatAppend(amount - 5, "X"));
            }
        }


        //единицы
        num = num - amount * 10; // 94-(9 * 10) = 4
        amount = num;

        if (amount == 4) {
            result.append("IV");
        } else if (amount == 9) {
            result.append("IX");
        } else {
            if (amount < 5) {
                result.append(repeatAppend(amount, "I"));
            } else {
                result.append("V");
                result.append(repeatAppend(amount - 5, "I"));
            }
        }


        return result.toString();
    }

    private String repeatAppend(int count, String symbol) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < count; i++) {
            res.append(symbol);
        }
        return res.toString();
    }
}
