package com.pathum.loans.mapper;

import com.pathum.loans.dto.LoanDTO;
import com.pathum.loans.entity.Loan;

public class LoanMapper {

    public static LoanDTO mapLoanEntityToLoanDto(Loan loan, LoanDTO loanDTO) {
        loanDTO.setLoanId(loan.getLoanId());
        loanDTO.setLoanNumber(loan.getLoanNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setTotalAmount(loan.getTotalAmount());
        loanDTO.setAmountPaid(loan.getAmountPaid());
        loanDTO.setOutstandingAmount(loan.getOutstandingAmount());

        return loanDTO;
    }

    public static Loan mapLoanDtoToLoanEntity(LoanDTO loanDTO, Loan loan) {
        loan.setLoanNumber(loanDTO.getLoanNumber());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setTotalAmount(loanDTO.getTotalAmount());
        loan.setAmountPaid(loanDTO.getAmountPaid());
        loan.setOutstandingAmount(loanDTO.getOutstandingAmount());

        return loan;
    }
}
