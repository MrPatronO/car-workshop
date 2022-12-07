package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.repositories.ClientRepository;
import com.github.MrPatronO.carworkshop.services.interfaces.ClientInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements ClientInterface {

    final ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public ResponseEntity<Client> findAll() {
        return null;
    }

    @Override
    public void deleteById(int clientId) {

    }

    public Optional<Client> findById(Integer integer) {
        return clientRepository.findById(integer);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }
    public boolean existsByClientId(Integer integer) {
        return clientRepository.existsById(integer);
    }
}
