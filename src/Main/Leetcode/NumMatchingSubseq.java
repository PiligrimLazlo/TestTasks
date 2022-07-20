package Main.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumMatchingSubseq {
    public static void main(String[] args) {
        //https://leetcode.com/problems/number-of-matching-subsequences/

        NumMatchingSubseq calc = new NumMatchingSubseq();
        int counter = calc.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"});
        System.out.println(counter);
    }

    //работает, но медленно
    public int numMatchingSubseq(String s, String[] words) {
        int resultCount = 0;
        Set<String> passedWords = new HashSet<>();
        Set<String> notAllowedLetters = new HashSet<>();

        //по всем словам
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];

            if (passedWords.contains(currentWord)) {
                resultCount++;
                continue;
            }

            //по всем буквам слова из массива
            int letterPosition = 0;
            int countLength = 0;
            for (int j = 0; j < currentWord.length(); j++) {
                String curLetterOfCurWord = String.valueOf(currentWord.charAt(j));

                if (notAllowedLetters.contains(curLetterOfCurWord)) continue;

                if (!s.contains(curLetterOfCurWord)) {
                    notAllowedLetters.add(curLetterOfCurWord);
                    continue;
                }

                //по всем буквам начального слова
                for (int k = letterPosition; k < s.length(); k++) {

                    if (curLetterOfCurWord.equals(String.valueOf(s.charAt(k)))) {
                        letterPosition = k + 1;
                        countLength++;
                        break;
                    }
                }
            }
            if (countLength == currentWord.length()) {
                passedWords.add(currentWord);
                resultCount++;
            }
        }
        return resultCount;
    }
}
