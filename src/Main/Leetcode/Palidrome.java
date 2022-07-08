package Main.Leetcode;

public class Palidrome {
    public static void main(String[] args) {
        Palidrome leetcode = new Palidrome();
        System.out.println(leetcode.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {

        String startString = String.valueOf(x);
        char[] s = startString.toCharArray();
        char[] snew = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            snew[i] = s[s.length - i - 1];
        }

        String resultString = "";
        for (int i = 0; i < snew.length; i++) {
            resultString += String.valueOf(snew[i]);
        }

        return startString.equals(resultString);
    }
}
