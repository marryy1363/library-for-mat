package com.example.booklibrary.controller;

import com.example.booklibrary.model.Loan;
import com.example.booklibrary.model.Users;
import com.example.booklibrary.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    LoanService loanService;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<Loan> list() {
        return loanService.listAllLoan();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> get(@PathVariable Integer id) {
        try {
            Loan loan = loanService.getLoan(id);
            return new ResponseEntity<Loan>(loan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Loan loan) throws Exception {

        loanService.saveLoan(loan);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Loan loan, @PathVariable Integer id) {
        try {
            Loan existLoan = loanService.getLoan(id);
            loan.setLoanid(id);
            loanService.saveLoan(loan);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        loanService.deleteLoan(id);
    }

    @GetMapping("/delayloans")
    public List<Loan> loanListOfNotReaturnedMorThanTwoWeek(){
       return loanService.listAllLoanLates();
    }
}
