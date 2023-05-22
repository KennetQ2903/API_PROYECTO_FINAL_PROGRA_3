package com.kennetquiroz.API;

import Classes.CajaDeProducto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
    public ResponseEntity<String> agregarCaja() {
        CajaDeProducto nuevaCaja = new CajaDeProducto(LocalDateTime.now());
        pilaCajas.push(nuevaCaja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body("{\"message\": \"Caja agregada exitosamente.\"}");
    }

    @GetMapping
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
