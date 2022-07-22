package com.muratkaplan.billapp.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void updateClient(int id, String firstName,String lastName) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()->new IllegalStateException(id+" does not exist"));
        if(firstName!=null&&firstName.length()>0 && !Objects.equals(client.getFirstName(),firstName)){
            Optional<Client> clientOptional= clientRepository.findClientByFirstName(firstName);
            if(clientOptional.isPresent()){
                throw new IllegalStateException(firstName+" is used");
            }
            client.setFirstName(firstName);
        }
        if(lastName!=null&&lastName.length()>0 && !Objects.equals(client.getLastName(),lastName)){
            Optional<Client> clientOptional= clientRepository.findClientByLastName(lastName);
            if(clientOptional.isPresent()){
                throw new IllegalStateException(lastName+" is used");
            }
            client.setLastName(lastName);
        }
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    public void addClient(List<Client> client) {

        clientRepository.saveAll(client);
    }

    public void deleteClient(int id) {
        boolean exist= clientRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException(id+" does not exist");
        }
        clientRepository.deleteById(id);
    }
}
