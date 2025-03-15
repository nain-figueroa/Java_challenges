package library_gestor;

import java.util.Scanner;

public class Book {
    private Scanner input = new Scanner(System.in);

    private String title = " ", author = " ", place = " ", signature = " ";
    private boolean available = true;

    public Book(String title, String author, String place){
        this.title = title;
        this.author = author;
        this.place = place;

        this.set_signature();
    }
    
    public String get_place(){
        return this.place;
    }

    public boolean get_available(){
        return this.available;
    }
    
    public String get_signature(){
        return this.signature;
    }

    public void change_place(){
        System.out.print("Nuevo lugar: ");
        this.place = input.nextLine();

        this.set_signature();
    }

    public void set_signature(){
        this.signature = this.place.substring(0,2).toUpperCase() + this.author.substring(0,2).toUpperCase() + this.title.substring(0,2).toUpperCase(); 
    }

    public void set_available(){
        this.available = !this.available;
    }

    public void print_book(){
        String state = "";

        if (!this.available){
            state = "*";
        }else{
            state = " ";
        }

        System.out.println(state + " " + this.signature + ", "+ this.author + ", " + this.title + ", " + this.place);
    }
}
