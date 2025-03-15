package library_gestor;

import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);
    private Library_gestor gestor = new Library_gestor();
    public static void main(String[] args){
        Main main = new Main();

        main.main_menu();
    }

    public void clear(){
        System.out.println("\033[H\033[2J"); // Código ANSI para limpiar
        System.out.flush();
    }

    public int main_menu(){
        byte loop = 1;

        do {
            this.clear();

            System.out.println("-------------------------");
            System.out.println("Menu");
            System.out.println("(1)Prestar libro\n(2)Recibir libro\n(3)Libros\n(4)Socios\n(5)Salir");
    
            switch (this.input.nextByte()) {
                case 1:
                    this.clear();

                    this.gestor.lend_books();
                    this.input.nextLine();
                    break;
                case 2:
                    this.clear();

                    this.gestor.receive_book();
                    this.input.nextLine();
                    break;
                case 3:
                    this.clear();

                    this.books();
                    break;
                case 4:
                    this.clear();

                    this.partners();
                    break;
                case 5:
                    return 0;
                default:
                    System.out.println("OPCION NO DISPONIBLE");
                    break;
            }
            System.out.println("Para continuar con el menu introduzca cualquier numero diferente de 0");
            loop = this.input.nextByte();
        } while (loop != 0);

        return 0;
    }

    public void books(){
        byte loop = 1;

        do {
            System.out.println("(1)Agregar libro\n(2)Eliminar libro\n(3)Ver libros\n(4)Volver");
            switch (this.input.nextByte()) {
                case 1:
                    this.clear();

                    this.gestor.add_book();
                    break;
                case 2:
                    this.clear();

                    this.gestor.del_book();
                    break;
                case 3:
                    this.clear();

                    this.gestor.view_books();
                    break;
                case 4:
                    loop = 0;
                    break;
                default:
                    System.out.println("OPCION NO DISPONIBLE");
                    break;
                }
            System.out.println("Para continuar introduzca cualquier numero diferente de 0");
            loop = this.input.nextByte();
        } while (loop != 0);
    }
    
    public void partners(){
        byte loop = 1;
    
        do {
            System.out.println("(1)Agregar Socio\n(2)Eliminar Socio\n(3)Ver Socios\n(4)Volver");
            switch (this.input.nextByte()) {
                case 1:
                    this.clear();

                    this.gestor.add_partner();
                    break;
                case 2:
                    this.clear();

                    this.gestor.del_partner();
                    break;
                case 3:
                    this.clear();

                    this.gestor.view_partners();
                    break;
                case 4:
                    loop = 0;
                    break;
                default:
                    System.out.println("OPCION NO DISPONIBLE");
                    break;
                }
            System.out.println("Para continuar introduzca cualquier numero diferente de 0");
            loop = this.input.nextByte();
        } while (loop != 0);

    }
}
