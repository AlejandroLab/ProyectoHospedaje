package com.softhostal.softhostal.repositories;

import com.softhostal.softhostal.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreuserAndContrasena(String nombreuser, String contrasena);
}
