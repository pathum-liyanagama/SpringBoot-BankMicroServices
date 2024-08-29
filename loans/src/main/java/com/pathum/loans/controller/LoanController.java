package com.pathum.loans.controller;

import com.pathum.loans.dto.LoanDTO;
import com.pathum.loans.dto.ResponseDTO;
import com.pathum.loans.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.pathum.loans.util.Constants.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/loans", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoanController {

    private LoanService loanService;

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanDTO> getLoan(@PathVariable Long loanId) {
        return ResponseEntity
                .ok()
                .body(loanService.getLoan(loanId));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createLoan(@Valid @RequestBody LoanDTO loanDTO){
        loanService.createLoan(loanDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), LOAN_CREATED));
    }

    @PutMapping("/{loanId}")
    public ResponseEntity<ResponseDTO> updateLoan(@PathVariable Long loanId, @Valid @RequestBody LoanDTO loanDTO){
        loanService.updateLoan(loanId, loanDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), LOAN_UPDATED));
    }

    @DeleteMapping("/{loanId}")
    public ResponseEntity<ResponseDTO> deleteLoan(@PathVariable Long loanId) {
        loanService.deleteLoan(loanId);
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK.value(), LOAN_DELETED));
    }
}
