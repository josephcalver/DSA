package Strings.Easy;

public class RunLengthEncoding {

    public static void main(String[] args) {

        String original = "abbCCC2!!!$$AABBBccccDDeF";

        String compressed = runLengthEncoding(original);

        System.out.println(compressed);

    }

//    O(n) time | O(n) space

    public static String runLengthEncoding(String string) {

        StringBuilder sb = new StringBuilder();

        int index = 0, runner = 0, count = 0;

        char current;

        while (index < string.length() && runner < string.length()) {

            current = string.charAt(index);

            if (current != string.charAt(runner) || count == 9) {

                sb.append(count);
                sb.append(current);

                count = 0;
                index = runner;

            } else {

                count++;
                runner++;

            }

        }

        if (runner >= string.length()) {

            sb.append(count);
            sb.append(string.charAt(index));

        }

        return sb.toString();

    }

}
