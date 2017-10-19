public interface IExpansible {
    void addBook(Book book);
    void addUser(AUser user);
    void recordBook(AUser user, Book book);
    void unsubscribeBook(AUser user, Book book);
}
