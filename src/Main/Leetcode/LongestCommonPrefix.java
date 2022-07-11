package Main.Leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // https://leetcode.com/problems/longest-common-prefix/

        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            String currentLetter = String.valueOf(strs[0].charAt(i));
            if (currentLetter.isEmpty()) return prefix.toString();

            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix + currentLetter)) {
                    return prefix.toString();
                }
            }
            prefix.append(currentLetter);
        }

        return prefix.toString();
    }
}
