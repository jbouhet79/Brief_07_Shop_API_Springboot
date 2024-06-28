package fr.simplon.api.messagesDto; // DTO : Data Transfer Object

import lombok.Getter;

@Getter
public class MessageCreateCard {
    private Integer user; // id de l'user
    private Integer product; // id du product
}
