package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.ClientDto;
import com.github.MrPatronO.carworkshop.dtos.NewClientDto;
import com.github.MrPatronO.carworkshop.models.Client;
import com.github.MrPatronO.carworkshop.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Optional<Client> findById(Long clientId) {
        return clientRepository.findById(clientId);
    }


    public ClientDto save(NewClientDto newClientDto) {
        Client client = new Client();
        client.setName(newClientDto.getName());
        client.setAddress(newClientDto.getAddress());
        client.setEmail(newClientDto.getEmail());
        client.setNip(newClientDto.getNip());
        client.setPhoneNumber(newClientDto.getPhoneNumber());

        Client newClient = clientRepository.save(client);

        return mapToClientDto(newClient);
    }


    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }



    public ClientDto update(ClientDto clientDto, Long clientId) {
        Client updatedOrCreatedClient = clientRepository.findById(clientId)
                .map(client -> {

                    mapToClient(client, clientDto);
                    return  clientRepository.save(client);
                })
                .orElseGet(() -> {
                    Client client = new Client();
                    client.setClientId(clientDto.getClientId());
                    mapToClient(client, clientDto);

                    return clientRepository.save(client);
                })  ;

        return mapToClientDto(updatedOrCreatedClient);
    }


    private ClientDto mapToClientDto(Client client){

        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setName(client.getName());
        clientDto.setAddress(client.getAddress());
        clientDto.setEmail(client.getEmail());
        clientDto.setNip(client.getNip());
        clientDto.setPhoneNumber(client.getPhoneNumber());

        return clientDto;
    }

    private void mapToClient(Client client, ClientDto clientDto){
        client.setNip(clientDto.getNip());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setEmail(clientDto.getEmail());
        client.setAddress(clientDto.getAddress());
        client.setName(clientDto.getName());
    }
}
