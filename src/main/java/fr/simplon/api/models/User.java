package fr.simplon.api.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//L'ensemble du code :
// @Entity
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Integer id;
//   
//     @Column(nullable = false, unique = true)
//     @NonNull
//     private String username;......................................

// Remplace :
//
// CREATE TABLE User (
//     id SERIAL PRIMARY KEY,
//     username VARCHAR(255) NOT NULL UNIQUE,
//     name VARCHAR(255),
//     password VARCHAR(255)
// )


@Entity // crée la bdd, sauvegarde les données en bdd
@Data // génère automatiquement des getters, setters, toString, equals avec Lombok (Assurez-vous que Lombok est ajouté à votre projet en tant que dépendance dans votre pom.xml (si vous utilisez Maven) ou dans votre build.gradle (si vous utilisez Gradle).
@RequiredArgsConstructor() // génére automatiquement un require avec tout ce qui est nécessaire (avec tous les arguments obligatoires)
@Table(name="users") // pour renommer la table,  gérer le mot clé user réservé
public class User { // génère les colonnes dans la table en créant : id et username
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false, unique = true)
    @NonNull
    private String username;

    private String name;
    private String email;
    @JsonIgnore // ignore le champ mot de passe (juste la ligne suivante)
    private String password;

    @OneToOne
    private Card card;

    @OneToMany
    private List<Order> order;

    public User(){}
}

