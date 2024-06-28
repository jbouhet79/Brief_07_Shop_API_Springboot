package fr.simplon.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.api.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
