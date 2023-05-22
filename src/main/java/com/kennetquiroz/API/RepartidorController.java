package com.kennetquiroz.API;

import Classes.Repartidor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api/repartidores")
public class RepartidorController {
    private Queue<Repartidor> colaRepartidores;

    public RepartidorController(Queue<Repartidor> colaRepartidores) {
        this.colaRepartidores = colaRepartidores;
    }

    @PostMapping("/add")
    public ResponseEntity<String> agregarRepartidor(@RequestBody Repartidor repartidor) {
        colaRepartidores.add(repartidor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body("{\"message\": \"Repartidor agregado correctamente a la cola.\"}");
    }

    @GetMapping
    public ResponseEntity<List<Repartidor>> obtenerRepartidores() {
        if (colaRepartidores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<Repartidor> repartidores = new ArrayList<>(colaRepartidores);
        return ResponseEntity.ok(repartidores);
    }
}
