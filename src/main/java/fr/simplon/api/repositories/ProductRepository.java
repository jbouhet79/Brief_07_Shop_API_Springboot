package fr.simplon.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.api.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
