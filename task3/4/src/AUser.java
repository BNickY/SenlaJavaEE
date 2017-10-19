import java.util.Arrays;

public abstract class AUser {
    private int id;
    private String name;
    private String phoneNumber;
    private Book[] userBooks;
    private Library library;

    public AUser(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        userBooks = new Book[0];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book[] getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(Book[] userBooks) {
        this.userBooks = userBooks;
    }

    public void showUserBooks(){
        for(Book i : userBooks) System.out.println(i);
    }

    @Override
    public String toString() {
        return "User id: " + id + ", name: " + name + ", phone: " + phoneNumber;
    }
}
