package Main.problems;

public class Cypher {
    public static void main(String[] args) {

        // вход:
        // abcd - исходная строка
        // *d%# - ключ
        // abacabadaba - зашифровать
        // #*%*d*% - зашифровать
        // выход должен быть:
        // *d*%*d*#*d*
        // dacabac

        String result = invoke("abcd", "*d%#", "abacabadaba", "#*%*d*%");
        System.out.println(result);

    }

    public static String invoke(String text, String keys, String toEncrypt, String toDecrypt) {

        char[] textArray = text.toCharArray();
        char[] keysArray = keys.toCharArray();

        char[] toEncryptArray = toEncrypt.toCharArray();
        char[] toDecryptArray = toDecrypt.toCharArray();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < toEncryptArray.length; i++) {
            char currentChar = toEncryptArray[i];
            for (int j = 0; j < textArray.length; j++) {
                char currentKey = textArray[j];
                if (currentChar == currentKey) {
                    result.append(keysArray[j]);
                    break;
                }
            }
        }
        result.append("\n");
        for (int i = 0; i < toDecryptArray.length; i++) {
            char currentChar = toDecryptArray[i];
            for (int j = 0; j < keysArray.length; j++) {
                char currentKey = keysArray[j];
                if (currentChar == currentKey) {
                    result.append(textArray[j]);
                    break;
                }
            }
        }

        return result.toString();
    }
}
