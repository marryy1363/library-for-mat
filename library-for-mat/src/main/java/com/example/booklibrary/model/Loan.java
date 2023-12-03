package com.example.booklibrary.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "loan_")
public class Loan {
    private Integer loanid;
    private Book book;
    private Users user;
    private Timestamp getTime;
    private Timestamp recieveTime;
    private boolean isReturn;

    public Loan() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    @ManyToOne
    @JoinColumn(name = "bookid", foreignKey = @ForeignKey(name = "book_id"))
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    @JoinColumn(name = "userid", foreignKey = @ForeignKey(name = "user_id"))
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    @Column
    public Timestamp getGetTime() {
        return getTime;
    }

    public void setGetTime(Timestamp getTime) {
        this.getTime = getTime;
    }
    @Column
    public Timestamp getRecieveTime() {
        return recieveTime;
    }

    public void setRecieveTime(Timestamp recieveTime) {
        this.recieveTime = recieveTime;
    }

    @Column
    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

}
