package br.com.duxusdesafio.repository;


import java.util.List;

import br.com.duxusdesafio.model.ComposicaoTime;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ComposicaoTimeRepository extends JpaRepository<ComposicaoTime, Long>{

    List<ComposicaoTime> findByPosicaoId(Long idPosicao);

    List<ComposicaoTime> findByNomeContaining(String nome);

    List<ComposicaoTime> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM Composicao p where p.compiscao = :composicoes")
    List<ComposicaoTime> listaTodasComposicoes(@Param("nome") String nome);



}
