package com.kennetquiroz.API;

import Classes.CajaDeProducto;
import Classes.CajaDeProductoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/api/boxes")
public class BoxesController {
    Stack<CajaDeProducto> pilaCajas;

    public BoxesController() {
        pilaCajas = new Stack<>();
    }

    @PostMapping("/add")
    public ResponseEntity<String> agregarCaja(@RequestBody CajaDeProductoRequest nuevaCaja) {
        try{
            LocalDateTime fechaIngreso = LocalDateTime.now();
            CajaDeProducto cajaNueva = new CajaDeProducto(fechaIngreso, nuevaCaja.getDescription());
            pilaCajas.push(cajaNueva);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Caja agregada exitosamente.\"}");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Algo salio mal, Error: "+ex.getMessage()+"\"}");
        }
    }

    @GetMapping("/getUnit")
    public ResponseEntity<CajaDeProducto> sacarCaja() {
        if (pilaCajas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        CajaDeProducto caja = pilaCajas.pop();
        return ResponseEntity.ok(caja);
    }

    @GetMapping("/stock")
    public ResponseEntity<List<CajaDeProducto>> obtenerTodasLasCajas() {
        if (pilaCajas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CajaDeProducto> todasLasCajas = new ArrayList<>(pilaCajas);
        return ResponseEntity.ok(todasLasCajas);
    }

}
