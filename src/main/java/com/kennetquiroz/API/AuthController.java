package com.kennetquiroz.API;

import Classes.Auth;
import Classes.ListaUsuario;
import Classes.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final ListaUsuario listaUsuario;
    public AuthController(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @PostMapping
    public ResponseEntity<Auth> login(@RequestBody Usuario request) {
        Auth response = new Auth();
        String nombre = request.getNombre();
        String contraseña = request.getPassword();

        Usuario usuario = listaUsuario.obtenerUsuarioPorNombre(nombre);
        if (usuario != null && usuario.getPassword().equals(contraseña)) {
            response.setAuth(true);
            // Autenticación exitosa
//            String token = "HUASYF79Y9A7YNC9Y9FAYCFYDICHAUHDUIAYD79AHD79AHDN9A9D8A9D8AUS80";
//            Map<String, String> response = new HashMap<>();
//            response.put("token", token);
//            return response;
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(response);
        } else {
            response.setAuth(false);
            // Autenticación fallida
//            throw new IllegalArgumentException("Nombre de usuario o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("Content-Type", "application/json")
                    .body(response);
        }
    }
}
