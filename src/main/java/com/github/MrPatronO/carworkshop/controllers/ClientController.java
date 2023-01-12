package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.ClientDto;
import com.github.MrPatronO.carworkshop.dtos.NewClientDto;
import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
class ClientController {

    @Autowired
    private final ClientService clientService;

    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    List<Client> readClients(Long clientId) {

        return clientService.findAll();
    }

    @PostMapping
    ClientDto newClient(@RequestBody @Validated NewClientDto newClientDto) {

        return  clientService.save(newClientDto);
    }

    @GetMapping("/{id}")
    Client readIdClients(@PathVariable("id") Long id) {

        return clientService.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<ClientDto> updateClient(@PathVariable("id") Long id, @RequestBody @Validated ClientDto clientDto) {
        return ResponseEntity.ok(clientService.update(clientDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteById(id);
    }
}
