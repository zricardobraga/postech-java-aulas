package br.com.fiap.api.usuarios_pet_tech.service.validation;

import br.com.fiap.api.usuarios_pet_tech.dto.UsuarioDTO;
import br.com.fiap.api.usuarios_pet_tech.entities.Usuario;
import br.com.fiap.api.usuarios_pet_tech.repository.UsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class CriacaoUsuarioValidator implements ConstraintValidator<CriacaoUsuarioValid, UsuarioDTO> {

    private UsuarioRepository usuarioRepository;

    //optei por fazer a injeção de dependencia pelo construtor, mas poderia fazer por anotação, usando o @Autowired
    public CriacaoUsuarioValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void initialize(CriacaoUsuarioValid annotations) { }

    @Override
    public boolean isValid(UsuarioDTO usuarioDTO, ConstraintValidatorContext context) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDTO.email());
        return usuario.isEmpty();
    }
}