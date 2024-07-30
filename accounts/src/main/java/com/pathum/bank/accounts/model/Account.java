package com.pathum.bank.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Account")
@Getter // @Data not used because it could create issues HashCode generation methods in Spring Data JPA
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends BaseEntity {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

}
