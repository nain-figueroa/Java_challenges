/*
 * Desarrollar un programa que sea una versión reducida y simplificada de una administración de bibioteca
 * El programa constará de un sistema de administración de los socios:
 *  -Datos: numero de socio, nombre, dirección, cantidad de libros prestados.
 *  -Si un socio tiene un registros de más de 10 libros prestados, será tachado como "No fiable"
 * También constará con la gestión de los libros:
 *  -Datos: codigo del libro, título, autor, si está disponible o no, localización y signatura
 *  -Los libros se prestan a los socios, por lo tal abrá una noción de libros prestados:
 *      -codigo del libro, numero del socio, fecha del prestamo.
 */

package library_gestor;

import java.util.ArrayList;
import java.util.Scanner;

public class Library_gestor {
    private Scanner input = new Scanner(System.in);

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Partner> partners = new ArrayList<>();

    public Library_gestor(){
        this.books.add(new Book("Dragon Ball Z", "Akira Toriyama", "Mangas"));
        this.books.add(new Book("Maze Runner", "James algo", "Ciencia ficcion"));
        this.books.add(new Book("Harry Potter", "Una seño", "Fantasia"));
    }

    public void lend_books(){
        String partner, signature;
        boolean aux = false, aux2 = false;

        this.view_partners();

        System.out.println("ID del Socio: ");
        partner = this.input.nextLine();

        for (Partner prtrnr : this.partners) {
            if (partner.equals(prtrnr.get_id())){
                this.view_books();
                System.out.println("Signatura de libro: ");
                signature = this.input.nextLine();

                aux = true;

                for (Book book : this.books) {
                    if (signature.equals(book.get_signature())){
                        prtrnr.add_booK(signature);
                        book.set_available();

                        aux2 = true;
                    }
                }

                if(!aux2){
                    this.no_signature();

                    lend_books();
                }
            }
        }

        if(!aux){
            this.no_id();
            System.out.println(">Agregrar nuevo socio? si(1)/No(2): ");

            if (this.input.nextByte() == 1){
                this.input.nextLine();

                add_partner();
                lend_books();
            }
        }
    }

    public void receive_book(){
        String signature;
        boolean aux = false;

        System.out.println("Signatura: ");
        signature = this.input.nextLine();

        for (Book book : books) {
            if (signature.equals(book.get_signature())){
                book.set_available();
                System.out.println("Libro devuelto con exito");

                aux = true;
            }
        }

        if(!aux){
            this.no_signature();
            view_books();

            receive_book();
        }

    }

    public void add_book(){
        String author, title, place;

        System.out.println(">Titulo: ");
        title = this.input.nextLine();
        System.out.println(">Autor: ");
        author = this.input.nextLine();
        System.out.println(">Lugar: ");
        place = this.input.nextLine();

        this.books.add(new Book(title, author, place));
    }

    public void del_book(){
        String signature = " ";
        boolean aux = false;
        
        this.view_books();
        
        System.out.println("----------------------");
        System.out.println("Signatura: ");
        signature = this.input.nextLine();

        for (Book book : this.books) {
            if (signature.equals(book.get_signature())){
                this.books.remove(book);

                aux = true;
            }
        }

        if(!aux){
            this.no_signature();

            del_book();
        }
    }

    public void view_books(){
        for (Book book : this.books) {
            book.print_book();
        }
    }

    public void add_partner(){
        String id, name, dir;

        System.out.println("ID: ");
        id = this.input.nextLine();
        System.out.println("Name: ");
        name = this.input.nextLine();
        System.out.println("Direccion: ");
        dir = this.input.nextLine();

        this.partners.add(new Partner(id, name, dir));
    }

    public void del_partner(){
        String id = " ";
        boolean aux = false;

        this.view_partners();

        System.out.println("----------------");
        System.out.println("ID: ");
        id = this.input.nextLine();

        for (Partner partner : this.partners) {
            if(id.equals(partner.get_id())){
                this.partners.remove(partner);

                aux = true;
            }
        }

        if (!aux){
            this.no_id();

            del_partner();
        }
    }

    public void view_partners(){
        for (Partner partner : this.partners) {
            partner.print_Partner();
        }
    }

    public void no_id(){
        System.out.println("--------------------------------");
        System.out.println("LA ID NO EXISTE EN EL REGISTRO");
    }

    public void no_signature(){
        System.out.println("---------------------------------------");
        System.out.println("LA SIGNATURA NO EXISTE EN EL REGISTRO");
    }
}
