package fr.simplon.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.api.models.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
