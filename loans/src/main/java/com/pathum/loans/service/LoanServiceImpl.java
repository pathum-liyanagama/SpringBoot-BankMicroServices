package com.pathum.loans.service;

import com.pathum.loans.dto.LoanDTO;
import com.pathum.loans.entity.Loan;
import com.pathum.loans.exception.ResourceNotFoundException;
import com.pathum.loans.mapper.LoanMapper;
import com.pathum.loans.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoanServiceImpl implements LoanService{

    LoanRepository loanRepository;
    @Override
    public void createLoan(LoanDTO loanDTO) {
        Loan loan = LoanMapper.mapLoanDtoToLoanEntity(loanDTO, new Loan());
        loanRepository.save(loan);
    }

    @Override
    public LoanDTO getLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(()-> new ResourceNotFoundException("Loan", "loanId", loanId.toString()));

        return LoanMapper.mapLoanEntityToLoanDto(loan, new LoanDTO());

    }

    @Override
    public void updateLoan(Long loanId, LoanDTO loanDTO) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "loanId", loanId.toString())
        );

        LoanMapper.mapLoanDtoToLoanEntity(loanDTO, loan);


        loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "loanId", loanId.toString())
        );

        loanRepository.delete(loan);
    }


}
