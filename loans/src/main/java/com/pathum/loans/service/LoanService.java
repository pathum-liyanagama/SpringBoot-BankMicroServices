package com.pathum.loans.service;

import com.pathum.loans.dto.LoanDTO;

public interface LoanService {
    void createLoan(LoanDTO loanDTO);

    LoanDTO getLoan(Long loanId);

    void updateLoan(Long loanId, LoanDTO loanDTO);

    void deleteLoan(Long loanId);
}
