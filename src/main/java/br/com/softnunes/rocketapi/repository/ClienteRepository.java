package br.com.softnunes.rocketapi.repository;

import br.com.softnunes.rocketapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
