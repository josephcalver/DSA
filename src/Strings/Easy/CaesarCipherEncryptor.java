package Strings.Easy;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {

        String original = "xyz";

        String encrypted = encrypt(original, 2);

        System.out.println(encrypted);

    }

    public static String encrypt(String str, int key) {

        StringBuilder sb = new StringBuilder(str.length());

        int position;
        char letter;

        for (char c : str.toCharArray()) {

            position = c - 'a';
            position = (position + key) % 26;

            letter = (char) (position + 'a');

            sb.append(letter);

        }

        return sb.toString();

    }

}
