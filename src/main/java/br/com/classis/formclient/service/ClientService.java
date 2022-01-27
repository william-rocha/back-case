package br.com.classis.formclient.service;


import br.com.classis.formclient.model.Client;
import br.com.classis.formclient.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository taskRepository;

    public Client createTask (Client client){
        return taskRepository.save(client);
    }
    public List<Client> listAllTasks(){
        return taskRepository.findAll();
    }
    public ResponseEntity<Client> findTaskById(Long id){
        return  taskRepository.findById(id)
                .map(client -> ResponseEntity.ok().body(client))
                .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Client> updateTaskById(Client client, Long id){
        return taskRepository.findById(id)
                .map(clientUpdate ->{
                    clientUpdate.setName(client.getName());
                    clientUpdate.setTelPhone(client.getTelPhone());
                    clientUpdate.setCep(client.getCep());
                    clientUpdate.setCity(client.getCity());
                    clientUpdate.setCpf(client.getCpf());
                    clientUpdate.setDistrict(client.getDistrict());
                    clientUpdate.setEmail(client.getEmail());
                    clientUpdate.setEmailAlert(client.getEmailAlert());
                    clientUpdate.setUserEmailAlert(client.getUserEmailAlert());
                    clientUpdate.setLogo(client.getLogo());
                    clientUpdate.setNumber(client.getNumber());
                    clientUpdate.setState(client.getState());
                    clientUpdate.setStreet(client.getStreet());
                    clientUpdate.setDistrict(client.getDistrict());
                    Client updated = taskRepository.save(clientUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById (Long id){
        return taskRepository.findById(id)
                .map(taskToDelete ->{
                    taskRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());

    }
}
