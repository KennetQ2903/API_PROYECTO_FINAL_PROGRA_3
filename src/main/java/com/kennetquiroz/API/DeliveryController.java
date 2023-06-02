package com.kennetquiroz.API;

import Classes.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    DeliveryList deliveryList;
    private Queue<Vehiculo> colaVehiculos;
    private Queue<Repartidor> colaRepartidores;

    private Stack<CajaDeProducto> pilaCajas;

    public DeliveryController(DeliveryList deliveryList, Queue<Vehiculo> colaVehiculos, Queue<Repartidor> colaRepartidores, Stack<CajaDeProducto> pilaCajas) {
        this.deliveryList = deliveryList;
        this.colaVehiculos = colaVehiculos;
        this.colaRepartidores = colaRepartidores;
        this.pilaCajas = pilaCajas;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody DeliveryRequest request) {
        try {
            if (!pilaCajas.isEmpty()) {
                if (!colaVehiculos.isEmpty()) {
                    if (!colaRepartidores.isEmpty()) {
                        Vehiculo foundVehicle = colaVehiculos.poll();
                        Repartidor foundRepartidor = colaRepartidores.poll();
                        CajaDeProducto producto = pilaCajas.pop();
                        Delivery delivery = new Delivery(request, deliveryList.getSize() + 1, foundVehicle, foundRepartidor, producto);
                        deliveryList.add(delivery);
                        return ResponseEntity.status(HttpStatus.CREATED)
                                .header("Content-Type", "application/json")
                                .body("{\"message\": \"Pedido agregado exitosamente.\"}");
                    } else {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .header("Content-Type", "application/json")
                                .body("{\"message\": \"No hay repartidores disponibles.\"}");
                    }

                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .header("Content-Type", "application/json")
                            .body("{\"message\": \"No hay vehículos disponibles.\"}");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("Content-Type", "application/json")
                        .body("{\"message\": \"No hay producto disponible en bodega.\"}");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Algo salio mal, Error: " + ex.getMessage() + "\"}");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Delivery>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(deliveryList.getAllDeliverys());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/completeDelivery")
    public ResponseEntity<Delivery> completeDelivery(@RequestBody DeliveryID deliveryID) {
        try {
            Delivery complete = deliveryList.completeDelivery(deliveryID.getID());
            if (complete != null) {
                return ResponseEntity.status(HttpStatus.OK)
                        .header("Content-Type", "application/json")
                        .body(complete);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Content-Type", "application/json")
                    .body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
