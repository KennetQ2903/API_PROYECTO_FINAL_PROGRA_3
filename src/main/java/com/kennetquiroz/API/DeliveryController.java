package com.kennetquiroz.API;

import Classes.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    DeliveryList deliveryList;
    private Queue<Vehiculo> colaVehiculos;

    public DeliveryController(DeliveryList deliveryList, Queue<Vehiculo> colaVehiculos) {
        this.deliveryList = deliveryList;
        this.colaVehiculos = colaVehiculos;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody DeliveryRequest request) {
        try {
            Vehiculo foundVehicle = colaVehiculos.poll();
            if(foundVehicle != null){
                Delivery delivery = new Delivery(request, deliveryList.getSize()+1, foundVehicle);
                deliveryList.add(delivery);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .header("Content-Type", "application/json")
                        .body("{\"message\": \"Pedido agregado exitosamente.\"}");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"No hay vehículos disponibles.\"}");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Algo salio mal, Error: "+ex.getMessage()+"\"}");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Delivery>> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(deliveryList.getAllDeliverys());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/completeDelivery")
    public ResponseEntity<Delivery> completeDelivery(@RequestBody DeliveryID deliveryID){
        try {
            Delivery complete = deliveryList.completeDelivery(deliveryID.getID());
            if(complete != null){
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
