package br.com.duxusdesafio.Controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.data.domain.Page;

import javax.persistence.*;


public class ComposicaoTimeDto {

    public ComposicaoTimeDto(ComposicaoTime composicaoTime) {
        this.id = composicaoTime.getId();
        this.time = composicaoTime.getTime();
        this.integrante = composicaoTime.getIntegrante();

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Time time;

    @ManyToOne
    private Integrante integrante;




    public static List<IntegranteDto> converte(List<Integrante> integrantes){
        return integrantes.stream().map(IntegranteDto::new).collect(Collectors.toList());
    }

    public static Page<IntegranteDto> converteToPage(Page<Integrante> integrantes){
        return integrantes.map(IntegranteDto::new);
    }
}
