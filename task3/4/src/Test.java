public class Test {
    public static void main(String[] args) {
        Book book1 = new Book("Pushkin", "Evgeni Onegin", 1831);
        Book book2 = new Book("Pushkin", "Poltava", 1829);
        Book book3 = new Book("Lermontov", "Borodino", 1837);
        Book book4 = new Book("Lermontov", "Fatalist", 1839);
        Book book5 = new Book("Bikov", "Stuzha", 1969);


        Library library = new Library("Niva","Sovetskay 13");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        library.showBooks();

        Teacher teacher = new Teacher(1,"Oksana","111","2015-1");
        Philistine philistine = new Philistine(2,"Artem","222","KH4122");
        Student student = new Student(3,"Pavel","333","2015-422");

        library.addUser(teacher);
        library.addUser(philistine);
        library.addUser(student);

        System.out.println();
        library.showUsers();

        library.recordBook(teacher,book1);
        library.recordBook(teacher,book2);

        System.out.println();
        library.showUserBooks(teacher);

        library.unsubscribeBook(teacher,book2);
        System.out.println();
        library.showUserBooks(teacher);

        System.out.println();
        library.showUserByBook(book1);

    }
}
