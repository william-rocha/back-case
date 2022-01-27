package br.com.classis.formclient.controller;

import br.com.classis.formclient.model.Client;
import br.com.classis.formclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ClientController {
     @Autowired
     ClientService taskService;

     @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)

    public Client createTask (@RequestBody Client client){
         return taskService.createTask(client);
     }

     @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllTasks() {
         return taskService.listAllTasks();
     }

     @GetMapping("/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> getTaskById(@PathVariable (value = "id")Long id) {
         return taskService.findTaskById(id);
     }

    @PutMapping("/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Client client) {
        return taskService.updateTaskById(client,id);
    }

    @DeleteMapping("/client/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id) {
        return taskService.deleteById(id);
    }
}
