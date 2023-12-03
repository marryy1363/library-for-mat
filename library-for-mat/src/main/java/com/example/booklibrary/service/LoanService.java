package com.example.booklibrary.service;

import com.example.booklibrary.model.Loan;
import com.example.booklibrary.model.Users;
import com.example.booklibrary.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Service
@Transactional
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    public List<Loan> listAllLoan() {
        return loanRepository.findAll();
    }

    public Loan saveLoan(Loan loan) throws Exception {
        try {
            if (!loan.getBook().equals(null)&&loan.getBook().getBookCount()>0)
                loan.getBook().setBookCount(loan.getBook().getBookCount()-1);
        }
        catch (Exception e){e.printStackTrace();}
        bookService.saveBook(loan.getBook());
        Users user = loan.getUser();
        Users userById = userService.findUserById(loan.getUser().getId());
        if (userById!=null){
        Integer userCount1 = userById.getUserCount();
        if (userCount1!=null){
        int userCount = userCount1 - 1;
        if (userCount>0){
            user.setUserCount(userCount);}}
        else {throw new Exception("each person only can loan 3 book");}
        userService.saveUser(user);
        return loanRepository.save(loan);}
        return null;
    }

    public Loan getLoan(Integer id) {
        return loanRepository.findById(id).get();
    }

    public void deleteLoan(Integer id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> listAllLoanLates() {
        List<Loan> byGetTimeAndRecieveTime = loanRepository.findAll();
        List<Loan>loans=new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();

        for (Loan l:byGetTimeAndRecieveTime) {
            LocalDateTime recieveLocalDateTime = l.getRecieveTime().toLocalDateTime();
            LocalDateTime  getLocalDateTime= l.getGetTime().toLocalDateTime();
            LocalDateTime next2Week = getLocalDateTime.plus(2, ChronoUnit.WEEKS);
            if (recieveLocalDateTime.isAfter(next2Week)){
            loans.add(l);
        }
        }
        return loans;
    }
}
