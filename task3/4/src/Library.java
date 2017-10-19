import java.util.Arrays;

public class Library implements IExpansible, IShowable{
    private String name;
    private String place;

    private Book[] books;
    private AUser[] users;


    public Library(String name, String place) {
        this.name = name;
        this.place = place;
        books = new Book[0];
        users = new AUser[0];
    }

    public Library(String name, String place, Book[] books) {
        this.name = name;
        this.place = place;
        this.books = books;
        users = new AUser[0];
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Book[] getBooks() {
        return books;
    }

    public AUser[] getUsers() {
        return users;
    }


    @Override
    public void showUsers() {
        for(AUser i : users) System.out.println(i);
    }

    @Override
    public void showBooks() {
        for(int i = 0; i < books.length; i++){
            System.out.println(books[i] + " place: " + books[i].getReader());
        }
    }

    @Override
    public void showUserByBook(Book book) {
        for(int i = 0; i < books.length; i++){
            if(books[i].equals(book)){
                System.out.println(books[i].getReader());
            }
        }
    }

    @Override
    public void showUserBooks(AUser user) {
        user.showUserBooks();
    }

    @Override
    public void addBook(Book book) {
        int size = books.length;
        books = Arrays.copyOf(books, size + 1);
        books[size] = book;
        book.setReader(this.toString());
    }

    @Override
    public void addUser(AUser user) {
        int size = users.length;
        users = Arrays.copyOf(users, size + 1);
        users[size] = user;
        user.setLibrary(this);
    }

    @Override
    public void recordBook(AUser user, Book book) {
        if(!book.getIsReading()) {
            Book[] userBooks = user.getUserBooks();
            int size = userBooks.length;
            userBooks = Arrays.copyOf(userBooks, size + 1);
            book.setIsReading(true);
            userBooks[size] = book;
            user.setUserBooks(userBooks);
            book.setReader(user.toString());
        }
    }

    @Override
    public void unsubscribeBook(AUser user, Book book) {
        Book[] userBooks = user.getUserBooks();
        int size = userBooks.length;

        for(int i = 0; i < size; i++){
            if(userBooks[i].equals(book)){
                userBooks[i].setIsReading(false);
                for(int j = i; j < size - 1; j++){
                    userBooks[j] = userBooks[j+1];
                }
                Book[] userBooksCopy = new Book[size - 1];
                System.arraycopy(userBooks,0,userBooksCopy,0,size - 1);
                user.setUserBooks(userBooksCopy);
                book.setReader(this.toString());
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "Library name: " + name + ", place: " + place;
    }
}
