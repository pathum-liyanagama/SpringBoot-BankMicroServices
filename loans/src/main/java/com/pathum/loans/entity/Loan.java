package com.pathum.loans.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long loanId;

    @Column
    private String loanNumber;

    @Column
    private String loanType;

    @Column
    private int totalAmount;

    @Column
    private int amountPaid;

    @Column
    private int outstandingAmount;
}
