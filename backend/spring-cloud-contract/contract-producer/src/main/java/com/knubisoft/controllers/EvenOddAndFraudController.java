package com.knubisoft.controllers;

import com.knubisoft.dao.LoanRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOddAndFraudController {

    private static final int MAX_VALUE = 10000;

    @GetMapping("/validate/prime-number")
    public String isNumberPrime(final @RequestParam("number") Integer number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    @PutMapping(value = "/fraudcheck", consumes = "application/json", produces = "application/json")
    public String check(final @RequestBody LoanRequest loanRequest) {
        if (loanRequest.getLoanAmount() > MAX_VALUE) {
            return "{fraudCheckStatus: FRAUD, rejection.reason: Amount too high}";
        } else {
            return "{fraudCheckStatus: OK, acceptance.reason: Amount OK}";
        }
    }
}
