package com.kennetquiroz.API;

import Classes.Repartidor;
import Classes.Vehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    private Queue<Vehiculo> colaVehiculos;

    public VehiculoController(Queue<Vehiculo> colaVehiculos) {
        this.colaVehiculos = colaVehiculos;
    }

    @PostMapping("/add")
    public ResponseEntity<String> agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        colaVehiculos.add(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body("{\"message\": \"Vehiculo agregado correctamente a la cola.\"}");
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> obtenerRepartidores() {
        if (colaVehiculos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<Vehiculo> vehiculos = new ArrayList<>(colaVehiculos);
        return ResponseEntity.ok(vehiculos);
    }
}
