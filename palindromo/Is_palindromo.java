package palindromo;

import java.util.Scanner;;

public class Is_palindromo {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String word = "", reversed_word = "";
        System.out.println("===Palindromos===");
        System.out.print("Palabra: ");
        word = input.nextLine();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed_word += word.charAt(i);
        }

        word = word.toLowerCase();
        reversed_word = reversed_word.toLowerCase();

        if (!word.equals(reversed_word)) {
            System.out.println(word + " NO es un palindromo");
        } else {
            System.out.println(word + " Es un palindromo");
        }
    }
}
