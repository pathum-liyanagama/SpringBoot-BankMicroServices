package com.pathum.cards.controller;


import com.pathum.cards.dto.CardDTO;
import com.pathum.cards.dto.ResponseDTO;
import com.pathum.cards.service.CardService;
import com.pathum.cards.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.pathum.cards.util.Constants.CARD_DELETED;
import static com.pathum.cards.util.Constants.CARD_UPDATED;

@AllArgsConstructor
@RestController
@RequestMapping(path="/api/v1/cards", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardsController {

    private CardService cardService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createCard(@RequestBody CardDTO cardDTO) {

        cardService.createCard(cardDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), Constants.CARD_CREATED));
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<CardDTO> getCard(@PathVariable String cardNumber) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardService.getCard(cardNumber));
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateCard(@RequestBody CardDTO cardDTO) {
        cardService.updateCard(cardDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), CARD_UPDATED));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<ResponseDTO> deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseDTO(HttpStatus.CREATED.value(), CARD_DELETED));
    }

}
