package guess_number;

import java.util.Scanner;
import java.util.Random;

public class Guess_number {
    public static void main(String[] args) {
        byte lives = 3;
        try (Scanner input = new Scanner(System.in)) {
            Random random_num = new Random();
            int number = random_num.nextInt(10) + 1, usr_number;

            System.out.println("<====Adivina el numero del 1 al 10====>");
            do {
                System.out.println("Vidas: " + lives);
                System.out.print(">: ");
                usr_number = input.nextInt();

                if (usr_number == number) {
                    System.out.println("Has acertado!!");
                    System.exit(0);
                } else {
                    if (lives != 1) {
                        lives -= 1;
                        System.out.println("Respues incorrecta intenta otra vez");
                    } else {
                        lives = 0;
                        System.out.println("Respuesta incorrecta, fin del juego");
                    }
                }
            } while (lives != 0);
        }
    }
}
