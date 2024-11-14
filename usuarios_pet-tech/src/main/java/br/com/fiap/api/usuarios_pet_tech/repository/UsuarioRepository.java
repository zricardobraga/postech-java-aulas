package br.com.fiap.api.usuarios_pet_tech.repository;


import br.com.fiap.api.usuarios_pet_tech.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
