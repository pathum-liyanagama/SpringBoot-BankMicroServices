package com.pathum.cards.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long cardId;

    @Column
    private String cardNumber;

    @Column
    private Long customerId;

    @Column
    private String cardType;

    @Column
    private int totalLimit;

    @Column
    private int amountUsed;

    @Column
    private int availableAmount;
}
