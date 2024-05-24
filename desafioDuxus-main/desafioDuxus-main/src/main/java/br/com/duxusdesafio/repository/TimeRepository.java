package br.com.duxusdesafio.repository;

import br.com.duxusdesafio.model.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe para configuracao do repositorio da
 * entidade Time
 */
public interface TimeRepository extends JpaRepository<Time, Long> {
}
