package fr.simplon.api.controllers;

import java.util.InputMismatchException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.Exceptions.InvalidCredentialException;
import fr.simplon.api.models.User;
import fr.simplon.api.repositories.UserRepository;

@RestController
public class LoginController {

    // @Autowired // peut remplacer public LoginController(...)
    private UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public User createUser(
        @ModelAttribute("username") String username,
        @ModelAttribute("password") String password
     ) throws InvalidCredentialException {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(()->new InvalidCredentialException("Check your credential"));
    }

    @PostMapping("/register") // réception lors de la requête api et création d'un user
    public User createUser(
        @ModelAttribute("username") String username,
        @ModelAttribute("password") String password,
        @ModelAttribute("passwordConfirm") String passwordConfirm,
        @ModelAttribute("email") String email
    ) {
        if (password.equals(passwordConfirm)) {
            User user = new User(username); // création d'un user
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        } else {
            throw new InputMismatchException("Passwords didn't match");
        }
    }

}
