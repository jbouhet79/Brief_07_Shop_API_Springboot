package fr.simplon.api.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.messagesDto.MessageCreateCard;
import fr.simplon.api.messagesDto.MessageSendCard;
import fr.simplon.api.messagesDto.MessageUpdateCard;
import fr.simplon.api.models.Card;
import fr.simplon.api.models.Order;
import fr.simplon.api.models.Product;
import fr.simplon.api.models.ProductRow;
import fr.simplon.api.models.User;
import fr.simplon.api.repositories.CardRepository;
import fr.simplon.api.repositories.ProductRepository;
import fr.simplon.api.repositories.ProductRowRepository;
import fr.simplon.api.repositories.UserRepository;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository; // pour faire les requêtes sql

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Card createCard(@RequestBody MessageCreateCard card) { // DTO  -> récupération des infos du user et du produit à partir de leurs id via MessageCreateCard
        Card newCard = new Card();
        User user = userRepository.findById(card.getUser()).get();
        newCard.setUser(user);
        Product product = productRepository.findById(card.getProduct()).get();
        List<Product> listProduit = new ArrayList<>();
        listProduit.add(product);
        newCard.setProducts(listProduit);
        newCard.setCreationDate(LocalDateTime.now());
        return cardRepository.save(newCard);
    }

    @GetMapping("/{cardId}")
    public Optional<Card> getCard(@PathVariable Integer cardId) {
    return cardRepository.findById(cardId);
    }

    @PutMapping("/{cardId}")
    public Card updateCard(@PathVariable Integer cardId, @RequestBody MessageUpdateCard updateCard) {
        Card card = cardRepository.findById(cardId).get();
        Product newProduct = productRepository.findById(updateCard.getProduct()).get();

        card.getProducts().add(newProduct); // ajoute le nouveau produit (avec toutes les infos grâce à son id et le dto) a la liste des produits : getProducts() du panier (card)
        
        return  cardRepository.save(card);
    }

}
