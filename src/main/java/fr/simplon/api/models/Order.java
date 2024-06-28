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
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
// @RequiredArgsConstructor()
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private LocalDateTime creationDate;

    @OneToMany
    private List<ProductRow> products;

    @ManyToOne
    private User user;


    public Order() {}


}
