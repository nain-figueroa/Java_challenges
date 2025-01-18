package palindromo;

import java.util.Scanner;;

public class Is_palindromo {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String word = "", reversed_word = "", word_no_spaces = "";
        System.out.println("===Palindromos===");
        System.out.print("Palabra: ");
        word = input.nextLine();

        for (int i = 0; i <= word.length() - 1; i++) {
            if (word.charAt(i) != ' ') {
                word_no_spaces += word.charAt(i);
            }
        }
        for (int i = word_no_spaces.length() - 1; i >= 0; i--) {
            if (word_no_spaces.charAt(i) != ' ') {
                reversed_word += word_no_spaces.charAt(i);
            }
        }

        word_no_spaces = word_no_spaces.toLowerCase();
        reversed_word = reversed_word.toLowerCase();

        if (!word_no_spaces.equals(reversed_word)) {
            System.out.println(word + " NO es un palindromo");
        } else {
            System.out.println(word + " Es un palindromo");
        }
    }
}
