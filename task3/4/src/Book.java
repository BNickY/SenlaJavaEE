public class Book {
    private String author;
    private String title;
    private int year;
    private boolean isReading;
    private String reader;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
        isReading = false;
        reader = null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean getIsReading() {
        return isReading;
    }

    public void setIsReading(boolean isReading) {
        this.isReading = isReading;
    }

    public boolean isReading() {
        return isReading;
    }

    public void setReading(boolean reading) {
        isReading = reading;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", author: " + author + ", year: " + year;
    }
}
