package br.com.fiap.api.usuarios_pet_tech.repository;


import br.com.fiap.api.usuarios_pet_tech.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
