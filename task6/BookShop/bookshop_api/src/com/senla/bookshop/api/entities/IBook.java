package com.senla.bookshop.api.entities;

import java.time.LocalDate;

public interface IBook extends IEntity{

    String getTitle();

    void setTitle(String title);

    String getAuthor();

    void setAuthor(String author);

    double getPrice();

    void setPrice(double price);

    Boolean getInStoke();

    void setInStoke(Boolean inStoke);

    LocalDate getPublishDate();

    void setPublishDate(LocalDate publishDate);

    LocalDate getReceiptDate();

    void setReceiptDate(LocalDate receiptDate);
}
