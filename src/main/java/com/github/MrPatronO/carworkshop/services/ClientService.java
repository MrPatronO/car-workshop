package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.ClientDto;
import com.github.MrPatronO.carworkshop.dtos.NewClientDto;
import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.repositories.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDto save(NewClientDto newClientDto) {
        Client client = new Client();
        client.setName(newClientDto.getName());
        client.setAddress(newClientDto.getAddress());
        client.setEmail(newClientDto.getEmail());
        client.setNip(newClientDto.getNip());
        client.setPhoneNumber(newClientDto.getPhoneNumber());

        Client newClient = clientRepository.save(client);

        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(newClient.getClientId());
        clientDto.setName(newClient.getName());
        clientDto.setAddress(newClient.getAddress());
        clientDto.setEmail(newClient.getEmail());
        clientDto.setNip(newClient.getNip());
        clientDto.setPhoneNumber(newClient.getPhoneNumber());

        return clientDto;
    }


    public ResponseEntity<Client> findAll() {
        return null;
    }


    public void deleteById(int clientId) {
    }

    public Optional<Client> findById(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }
    public boolean exists(Integer clientId) {
        return clientRepository.existsById(clientId);
    }

    public ClientDto update(ClientDto clientDto, Integer clientId) {
        Client updatedOrCreatedClient = clientRepository.findById(clientId)
                .map(client -> {
                    client.setNip(clientDto.getNip());
                    client.setPhoneNumber(clientDto.getPhoneNumber());
                    client.setEmail(clientDto.getEmail());
                    client.setAddress(clientDto.getAddress());
                    client.setName(clientDto.getName());
                    return clientRepository.save(client);
                })
                .orElseGet(() -> {
                    Client client = new Client();
                    client.setClientId(clientDto.getClientId());
                    client.setNip(clientDto.getNip());
                    client.setPhoneNumber(clientDto.getPhoneNumber());
                    client.setEmail(clientDto.getEmail());
                    client.setAddress(clientDto.getAddress());
                    client.setName(clientDto.getName());

                    return clientRepository.save(client);
                })  ;
        ClientDto newClientDto = new ClientDto();
        newClientDto.setClientId(updatedOrCreatedClient.getClientId());
        newClientDto.setNip(updatedOrCreatedClient.getNip());
        newClientDto.setPhoneNumber(updatedOrCreatedClient.getPhoneNumber());
        newClientDto.setEmail(updatedOrCreatedClient.getEmail());
        newClientDto.setAddress(updatedOrCreatedClient.getAddress());
        newClientDto.setName(updatedOrCreatedClient.getName());

        return newClientDto;
    }

}
