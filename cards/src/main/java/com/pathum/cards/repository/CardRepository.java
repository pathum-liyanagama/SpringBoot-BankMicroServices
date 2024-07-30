package com.pathum.cards.repository;

import com.pathum.cards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByCustomerIdAndCardType(Long customerId, String cardType);

    Optional<Card> findByCardNumber(String cardNumber);
}
