package fr.simplon.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.models.User;
import fr.simplon.api.repositories.UserRepository;

@RestController // @RestController remplace @Controller puis un @ResponseBody
@RequestMapping("/api/users") // défini le chemin pour les Posts et Get
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll(); // récupère (renvoie) tous les utilisateurs
    }

    @GetMapping("/{userId}")
    public Optional<User> getOneUsers(@PathVariable Integer userId) {
        return userRepository.findById(userId); // récupère (renvoie) un utilisateur (un Optionnal qui gère
                                                // automatiquement l'erreur) pour lequel d'id récupéré est en base de
                                                // donnée
    }

    @PostMapping
    public User createUser(@ModelAttribute User user) { // @RequestBody => le user est dans le body de la requête
        // return new User(); // pour importer @RequestBody => ctrl + espace après
        // @RequestBody
        User newUser = new User(user.getUsername());
        return userRepository.save(newUser);
    }

    // @PostMapping("/")
    // public User createUser(@RequestBody User user) {
    // User newUser = new User(user.getUsername());
    // return userRepository.save(newUser);
    // }
}