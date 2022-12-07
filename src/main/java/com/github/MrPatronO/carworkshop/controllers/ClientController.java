package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
class ClientController {

    @Autowired
    private final ClientService clientService;

    public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    ResponseEntity<Client> readClients(@PathVariable int clientId) {

        return clientService.findAll();
    }

    @PostMapping
    Client newClient(@RequestBody @Validated Client newClient) {

        return  clientService.save(newClient);
    }

    @GetMapping("/{id}")
    Client readIdClients(@PathVariable int clientId) {

        return clientService.findById(clientId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    Client updateClient(@PathVariable int clientId, @RequestBody @Validated Client newClient) {
        return clientService.findById(clientId)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setAddress(newClient.getAddress());
                    client.setEmail(newClient.getEmail());
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    client.setNip(newClient.getNip());

                    return clientService.save(client);
                })
                .orElseGet(() -> {
                    newClient.setClientId(clientId);
                    return clientService.save(newClient);
                })  ;

    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable int clientId) {
        clientService.deleteById(clientId);
    }
}
