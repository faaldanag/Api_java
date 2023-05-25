package com.example.reto3.Repository;

import com.example.reto3.Repository.CRUD.ClientCrudRepository;
import com.example.reto3.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private  ClientCrudRepository ClientCrudRepository;

    public List<Client> findAll(){
        return (List<Client>) ClientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return ClientCrudRepository.findById(id);
    }
    public Client save(Client client){
        return ClientCrudRepository.save(client);
    }
    public void delete(Client client){
        ClientCrudRepository.delete(client);
    }
}
