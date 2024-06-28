package fr.simplon.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import java.time.LocalDateTime;
import java.util.List;



@Entity
@Data
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private LocalDateTime creationDate;

    @NonNull
    @ManyToMany // Many en 2ème mot => une Liste dans le private
    private List<Product> products;

    @NonNull
    @OneToOne // One en 2eme mot => un seul elt dans le private qui suit
    private User user;

    public Card(){}

}
