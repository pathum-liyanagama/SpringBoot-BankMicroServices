package com.pathum.cards.service.impl;

import com.pathum.cards.dto.CardDTO;
import com.pathum.cards.entity.Card;
import com.pathum.cards.exception.CardAlreadyExistException;
import com.pathum.cards.exception.ResourceNotFoundException;
import com.pathum.cards.mapper.CardMapper;
import com.pathum.cards.repository.CardRepository;
import com.pathum.cards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pathum.cards.util.Constants.CARD_ALREADY_EXIST_MSG;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;


    @Override
    public CardDTO getCard(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardNumber)
        );

        return CardMapper.mapCardToCardDto(card, new CardDTO());
    }

    @Override
    public void createCard(CardDTO cardDTO) {
        Optional<Card> optionalCard = cardRepository.findByCustomerIdAndCardType(cardDTO.getCustomerId(), cardDTO.getCardType());
        if(optionalCard.isPresent()){
            throw new CardAlreadyExistException(CARD_ALREADY_EXIST_MSG + cardDTO.getCardType());
        }

        Card card = CardMapper.mapCardDtoToCard(cardDTO, new Card());
        cardRepository.save(card);
    }

    @Override
    public void updateCard(CardDTO cardDTO) {
        Card card = CardMapper.mapCardDtoToCard(cardDTO, new Card());
        cardRepository.findById(card.getCardId()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Card Id", Long.toString(card.getCardId()))
        );
        cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Card Id", Long.toString(cardId))
        );
        cardRepository.deleteById(card.getCardId());
    }
}
