package com.kennetquiroz.API;

import Classes.AVLTreeClient;
import Classes.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private AVLTreeClient avlTree;

    @Autowired
    public ClientController(AVLTreeClient avlTree) {
        this.avlTree = avlTree;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addCliente(@RequestBody Cliente cliente) {
        avlTree.insert(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body("{\"message\": \"Cliente agregado exitosamente.\"}");
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = avlTree.getClientes();
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(clientes);
    }
}
