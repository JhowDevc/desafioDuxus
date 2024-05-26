package br.com.duxusdesafio.Controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Time;
import org.springframework.data.domain.Page;


public class TimeDto {

    public TimeDto(Time time) {
        this.id = time.getId();
        this.data = time.getData();
        this.composicaoTime = time.getComposicaoTime();
    }


    private Long id;


    private LocalDate data;


    private List<ComposicaoTime> composicaoTime;

    public static List<TimeDto> converte(List<Time> times){
        return times.stream().map(TimeDto::new).collect(Collectors.toList());
    }

    public static Page<TimeDto> converteToPage(Page<Time> times){
        return times.map(TimeDto::new);
    }
}
