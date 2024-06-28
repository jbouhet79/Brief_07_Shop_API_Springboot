package fr.simplon.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.api.models.Card;
import fr.simplon.api.models.ProductRow;

public interface ProductRowRepository extends JpaRepository<ProductRow, Integer>{

}
