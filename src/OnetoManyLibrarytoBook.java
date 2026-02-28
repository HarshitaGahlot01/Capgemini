class Book{
    String title;
    Book(String title){
        this.title=title;
    }
}
class Library{
    String name;
    Book[] books;
    Library(String name,Book[] books){
        this.name=name;
        this.books=books;
    }
    void display(){
        System.out.println("name:"+name);
        for(Book b:books){
            System.out.println("title:"+b.title);
        }
    }
}
public class OnetoManyLibrarytoBook {
    public static void main(String[] args) {
    Book[] books={new Book("Java"),
            new Book("BB"),
            new Book("cc")
    };
    Library l=new Library("radheshyam",books);
    l.display();

}}

