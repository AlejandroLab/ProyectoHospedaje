package com.softhostal.softhostal.api;

import com.softhostal.softhostal.models.Usuario;
import com.softhostal.softhostal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:8081")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findByNombreuserAndContrasena(
                usuario.getNombreuser(), usuario.getContrasena()
        );
        if (user.isPresent()) {
            return ResponseEntity.ok("Acceso permitido. Bienvenido, " + user.get().getNombreuser());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
        }
    }
}
