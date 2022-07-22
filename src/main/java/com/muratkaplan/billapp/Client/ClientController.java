package com.muratkaplan.billapp.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
@RequestScope
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    //liste yöntemi Musteri ekleme

    @GetMapping("/getAllClients")
    public List<Client> getClient(){
        return clientService.getClient();
    }
    //postman kullanılarak Musteri kayıt etme(ekleme)
    //http://localhost:8080/api/v1/client/addNewClient adresinden post edildi.
    @PostMapping("/addNewClient")
    public void registerNewClient(@RequestBody List<Client> client){
        clientService.addClient(client);
    }
    @DeleteMapping("{clientId}")
    public void deleteClient(@PathVariable("clientId") int clientId){
        clientService.deleteClient(clientId);}
    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("{clientId}") int clientId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName){
                clientService.updateClient(clientId,firstName,lastName);
    }

}
