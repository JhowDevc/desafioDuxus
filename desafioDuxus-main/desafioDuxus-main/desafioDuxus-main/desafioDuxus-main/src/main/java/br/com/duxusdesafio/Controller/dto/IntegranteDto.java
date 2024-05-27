package br.com.duxusdesafio.Controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


public class IntegranteDto {

    public IntegranteDto(Integrante integrante) {
        this.id = integrante.getId();
        this.franquia = integrante.getFranquia();
        this.nome = integrante.getNome();
        this.funcao = integrante.getFuncao();
    }


    private long id;

    @NotNull
    @Column
    private String franquia;

    @NotNull
    @Column
    private String nome;

    @NotNull
    @Column
    private String funcao;

    @OneToMany(mappedBy = "integrante")
    private List<ComposicaoTime> composicaoTime;



    public static List<IntegranteDto> converte(List<Integrante> integrantes){
        return integrantes.stream().map(IntegranteDto::new).collect(Collectors.toList());
    }

    public static Page<IntegranteDto> converteToPage(Page<Integrante> integrantes){
        return integrantes.map(IntegranteDto::new);
    }
}
