package com.kennetquiroz.API;

import Classes.ListaUsuario;
import Classes.Repartidor;
import Classes.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Queue;

@RestController
@RequestMapping("/api/users")
public class UserController {
    ListaUsuario listaUsuario;

    public UserController(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @PostMapping("/add")
    ResponseEntity<String> Add(@RequestBody Usuario usuario) {
        try {
            Usuario newUsuario = usuario;
            listaUsuario.agregar(newUsuario);
            listaUsuario.imprimir();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Usuario agregado exitosamente.\"}");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Algo sucedio al tratar de agregar al usuario, Error: " + ex.getMessage() + ".\"}");
        }
    }

    @GetMapping
    public ArrayList<Usuario> obtenerUsuarios() {
        return listaUsuario.obtenerUsuarios();
    }
}
