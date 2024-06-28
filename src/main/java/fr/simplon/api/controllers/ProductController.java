package fr.simplon.api.controllers;

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

import fr.simplon.api.messagesDto.MessageUpdateCard;
import fr.simplon.api.messagesDto.MessageUpdateProduct;
import fr.simplon.api.models.Card;
import fr.simplon.api.models.Product;
import fr.simplon.api.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product) { // @RequestBody => le produit est dans le body de la requête (format json)
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // récupère (renvoie) tous les produits
    }

    @GetMapping("/{productId}")
    public Optional<Product> getOneProducts(@PathVariable Integer productId) {
        return productRepository.findById(productId); // récupère (renvoie) un produit (un Optionnal qui gère
                                                // automatiquement l'erreur) pour lequel d'id récupéré est en base de
                                                // donnée
    }

    @PutMapping("/{productId}") 
        public Product updateCard(@PathVariable Integer productId, @RequestBody MessageUpdateProduct updateProduct) {
            Product product = productRepository.findById(productId).get();
            var quantity = product.getQuantity() + updateProduct.getQuantity();
            product.setQuantity(quantity); 
            // product.setQuantity(product.getQuantity() + updateProduct.getQuantity()); // Supposant que getQuantity() retourne un int ou Integer
            return productRepository.save(product); 
    }
}

    

