package com.kennetquiroz.API;

import Classes.CajaDeProducto;
import Classes.ListaCajasPorPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/boxPerDelivery")
public class BoxPerDeliveryController {
    ListaCajasPorPedido listaCajasPorPedido;

    public BoxPerDeliveryController(ListaCajasPorPedido listaCajasPorPedido) {
        this.listaCajasPorPedido = listaCajasPorPedido;
    }

    @PostMapping("/add")
    ResponseEntity<String> Add(@RequestBody CajaDeProducto caja) {
        try {
            CajaDeProducto newcaja = caja;
            listaCajasPorPedido.agregar(newcaja);
//            listaCajasPorPedido.imprimir();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Caja asignada al pedido exitosamente.\"}");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Algo sucedio al tratar de agregar la caja al pedido, Error: " + ex.getMessage() + ".\"}");
        }
    }

    @GetMapping
    public ArrayList<CajaDeProducto> obtenerCajas() {
        return listaCajasPorPedido.obtenerCajasPorPedido();
    }
}
