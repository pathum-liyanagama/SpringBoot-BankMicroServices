package com.pathum.cards.service;

import com.pathum.cards.dto.CardDTO;

public interface CardService {

    CardDTO getCard(String cardNumber);

    void createCard(CardDTO cardDTO);

    void updateCard(CardDTO cardDTO);

    void deleteCard(Long cardId);
}
