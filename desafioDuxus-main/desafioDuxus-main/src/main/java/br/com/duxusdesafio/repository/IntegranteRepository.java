package br.com.duxusdesafio.repository;


import java.util.List;

import br.com.duxusdesafio.model.Integrante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IntegranteRepository extends JpaRepository<Integrante, Long>{

    List<Integrante> findByPosicaoId(Long idPosicao);

    List<Integrante> findByNomeContaining(String nome);

    List<Integrante> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM Integrante p where p.nome = :nome")
    List<Integrante> listaTodosPorNome(@Param("nome") String nome);



}
