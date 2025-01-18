package units_converter;

import java.util.Scanner;

public class Seconds_converter {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("|===Convertidor de segundos===|");
        System.out.println("(1)Dias\n(2)Horas\n(3)minutos");
        switch (input.nextInt()) {
            case 1: {
                System.out.println(">>Segundos a Dias");
                System.out.print("Segundos: ");
                int seconds = input.nextInt();

                System.out.println("Dias: " + (seconds / 86400));
                break;
            }
            case 2: {
                System.out.println(">>Segundos a Horas");
                System.out.print("Segundos: ");
                int seconds = input.nextInt();

                System.out.println("Horas: " + (seconds / 3600));
                break;
            }
            case 3: {
                System.out.println(">>Segundos a Minutos");
                System.out.print("Segundos: ");
                int seconds = input.nextInt();

                System.out.println("Minutos: " + (seconds / 60));
                break;
            }
            default:
                System.out.println("Opcion no disponible");
                break;
        }
    }
}
