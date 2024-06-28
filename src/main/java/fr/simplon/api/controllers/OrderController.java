package fr.simplon.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.messagesDto.MessageSendCard;
import fr.simplon.api.models.Card;
import fr.simplon.api.models.Order;
import fr.simplon.api.models.Product;
import fr.simplon.api.models.ProductRow;
import fr.simplon.api.repositories.CardRepository;
import fr.simplon.api.repositories.OrderRepository;
import fr.simplon.api.repositories.ProductRowRepository;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired // remplace le constructeur
    private OrderRepository orderRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ProductRowRepository productRowRepository;

    @PostMapping
    private Order createOrder(@RequestBody MessageSendCard order) {
        Card card = cardRepository.findById(order.getCard()).get();
        Order newOrder = new Order();
        newOrder.setUser(card.getUser());

        List<ProductRow> productRows = new ArrayList<>();
        for (Product product : card.getProducts()) { // foreach
            ProductRow row = new ProductRow();
            row.setProduct(product);
            row.setPrice(product.getPrice());
            row.setQuantity(1);
            productRows.add(row);
        }

        productRowRepository.saveAll(productRows);
        newOrder.setProducts(productRows);
        newOrder.setCreationDate(card.getCreationDate());
        return orderRepository.save(newOrder);
    }

}
