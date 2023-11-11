package br.com.softnunes.rocketapi.repository;

import java.util.Optional;

import br.com.softnunes.rocketapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByUsername(String username);

	boolean existsByUsername(String username);

}
