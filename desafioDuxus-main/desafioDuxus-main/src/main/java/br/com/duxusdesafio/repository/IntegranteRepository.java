package br.com.duxusdesafio.repository;

import br.com.duxusdesafio.model.domain.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe para configuracao do repositorio da
 * entidade Integrante
 */
public interface IntegranteRepository extends JpaRepository<Integrante, Long> {
}
