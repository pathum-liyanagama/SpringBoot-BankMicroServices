package com.pathum.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    private Long cardId;
    private String cardNumber;
    private Long customerId;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
