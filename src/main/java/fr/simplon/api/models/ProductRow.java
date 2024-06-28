package fr.simplon.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class ProductRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    @ManyToOne
    private Product product;

    @NonNull
    private Integer quantity;

    @NonNull
    private Float price;

    private Float discount;

    public ProductRow(){};
}
