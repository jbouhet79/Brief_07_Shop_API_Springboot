package fr.simplon.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello") // défini le chemin pour tous les Post et Get
public class HelloController {
    @GetMapping("/")
    public String helloworld() {
        return "Hello World !"; // affiche "Hello World !" dans http://localhost:8080/hello
    }

    @GetMapping("/{username}")
    public String helloUser (@PathVariable String username) { // @PathVariable => extrait et récupère dans username la valeur saisie dans l'url /{username}
        return "Hello, " + username + " !"; // affiche "Hello TOTO !" dans http://localhost:8080/hello/TOTO
    }

    
}
