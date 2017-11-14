package com.senla.bookshop.api.entities;

import com.senla.bookshop.api.entities.requeststatus.RequestStatus;
import java.time.LocalDate;

public interface IRequest extends IEntity{

    LocalDate getRequestDate();

    void setRequestDate(LocalDate requestDate);

    RequestStatus getRequestStatus();

    void setRequestStatus(RequestStatus requestStatus);

    long getBookId();

    void setBookId(long bookId);
}
