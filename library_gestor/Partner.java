package library_gestor;

import java.util.Scanner;
import java.util.ArrayList;

public class Partner {
    private Scanner input = new Scanner(System.in);

    private String id = " ", name = " ", dir = " ";
    private byte cant_books = 0;
    private boolean reliable = true;
    private ArrayList<String> books = new ArrayList<>();

    public Partner(String id, String name, String dir){
        this.id = id;
        this.name = name;
        this.dir = dir;
    }

    public byte cant_books(){
        return this.cant_books;
    }

    public String get_id(){
        return this.id;
    }

    public String get_book(byte index){
        try {
            return this.books.get(index);
        } catch (Exception e) {
            System.out.println("----------------------------");
            System.out.println("INDICE FUERA DEL RANGO");
            System.out.print(">Intente de nuevo: ");
            this.get_book(input.nextByte());
        }
        return " ";
    }

    public void set_reliable(){
        if(this.cant_books > 10){
            this.reliable = false;
        }else{
            this.reliable = true;
        }
    }

    public void add_booK(String signature){
        if(!this.reliable){
            System.out.println("-------------------------------------------------");
            System.out.println("ESTE SOCIO YA CUENTA CON MUCHOS LIBROS PRESTADOS");
        } else {
            this.books.add(signature);
    
            this.cant_books += 1;
            this.set_reliable();
        }
    }

    public void del_book(String signature){
        boolean aux = false;

        for (int i = 0; i <= this.books.size() - 1; i++){
            if (signature.equals(this.books.get(i))){
                this.books.remove(i);
                this.cant_books -= 1;

                aux = true;

                this.set_reliable();
            }
        }

        if (!aux){
            System.out.println("-----------------------------------------");
            System.out.println("EL LIBRO NO EXISTE EN ESTE REGISTRO");
            System.out.print("Intente de nuevo: ");
            this.del_book(this.input.nextLine());
        }
    }

    public void print_Partner(){
        String state = "";
        if (!this.reliable){
            state = "*";
        }else{
            state = " ";
        }

        System.out.println(state + " " + this.id + ", " + this.name + ", " + this.dir + ", " + this.cant_books);
    }
}
