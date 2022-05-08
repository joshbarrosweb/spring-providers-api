package com.joshbarros.springproviders.entities.email;

public interface EmailSender {

    void send(String to, String email);
}
