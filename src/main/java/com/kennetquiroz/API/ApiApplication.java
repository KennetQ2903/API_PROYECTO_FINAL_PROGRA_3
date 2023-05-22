package com.kennetquiroz.API;

import Classes.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
import java.util.Queue;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public AVLTreeClient avlTree() {
        return new AVLTreeClient();
    }
    @Bean
    public Queue<Repartidor> colaRepartidores() {
        return new LinkedList<>();
    }

    @Bean
    public Queue<Vehiculo> colaVehiculos() {
        return new LinkedList<>();
    }

    @Bean
    public ListaUsuario listaUsuario() {
        return new ListaUsuario();
    }
    @Bean
    public ListaCajasPorPedido listaCajasPorPedido() {
        return new ListaCajasPorPedido();
    }

}
