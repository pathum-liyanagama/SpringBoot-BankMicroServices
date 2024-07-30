package com.pathum.cards.mapper;

import com.pathum.cards.dto.CardDTO;
import com.pathum.cards.entity.Card;

public class CardMapper {

    public static CardDTO mapCardToCardDto(Card card, CardDTO cardDTO){
        cardDTO.setCardId(card.getCardId());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setCustomerId(card.getCustomerId());
        cardDTO.setCardType(card.getCardType());
        cardDTO.setTotalLimit(card.getTotalLimit());
        cardDTO.setAmountUsed(card.getAmountUsed());
        cardDTO.setAvailableAmount(card.getAvailableAmount());

        return cardDTO;
    }

    public static Card mapCardDtoToCard(CardDTO cardDTO, Card card){
        card.setCardId(cardDTO.getCardId());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCustomerId(cardDTO.getCustomerId());
        card.setCardType(cardDTO.getCardType());
        card.setTotalLimit(cardDTO.getTotalLimit());
        card.setAmountUsed(cardDTO.getAmountUsed());
        card.setAvailableAmount(cardDTO.getAvailableAmount());

        return card;
    }
}
