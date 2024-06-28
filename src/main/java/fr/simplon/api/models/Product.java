package fr.simplon.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
// @RequiredArgsConstructor()
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // @Column(nullable = false, unique = true)
    @NonNull
    private String name;

    @NonNull
    private Float price;

    private Integer quantity;

    // @ManyToMany          => pas vue du côté produit (sur une page produit, on ne peut pas voir tous les paniers)
    // private List<Card> card;

    public Product(){}
    
}
