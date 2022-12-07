package com.github.MrPatronO.carworkshop.services.interfaces;

import com.github.MrPatronO.carworkshop.models.Client;
import org.springframework.http.ResponseEntity;

public interface ClientInterface {

    public abstract Client save(Client client);

    ResponseEntity<Client> findAll();

    void deleteById(int clientId);
}
