package br.com.duxusdesafio.repository;

import java.math.BigDecimal;
import java.util.List;

import br.com.duxusdesafio.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface TimeRepository extends JpaRepository<Time, Long>{
	
	List<Time> findByCategoriaId(Long idCategoria);
	
	List<Time> findByNomeContaining(String nome);
	
	List<Time> findByNomeContainingIgnoreCase(String nome);
	
	@Query("SELECT p FROM Time p where p.nome = :nome")
	List<Time> listaTodosPorNome(@Param("nome") String nome);
	


	
}
