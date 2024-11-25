package com.example.aura.Aura_Project2.Controller;

import com.example.aura.Aura_Project2.domain.Client;
import com.example.aura.Aura_Project2.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientrepository;
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public ResponseEntity<List <Client>> getAllClient(){
        return ResponseEntity.ok(clientrepository.findAll());
    }
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientrepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client newClient = clientrepository.save(client);
        return ResponseEntity.ok(newClient);
    }
    @CrossOrigin(origins = "", allowedHeaders = "")
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Optional<Client> clientOptional = clientrepository.findById(id);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(updatedClient.getName());
            client.setEmail(updatedClient.getEmail());
            client.setTel(updatedClient.getTel());

            Client savedClient = clientrepository.save(client);
            return ResponseEntity.ok(savedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "", allowedHeaders = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        Optional<Client> clientOptional = clientrepository.findById(id);

        if (clientOptional.isPresent()) {
            clientrepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
