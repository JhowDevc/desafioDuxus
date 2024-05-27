package br.com.duxusdesafio.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import br.com.duxusdesafio.Controller.dto.TimeDto;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/times")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;


    @GetMapping
    public ResponseEntity<List<Time>> listAll() {
        List<Time> times = new ArrayList<>();
        times = timeRepository.findAll();
        return new ResponseEntity<>(times, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Time> findById(@PathVariable Long id) {
        Optional<Time> produto = timeRepository.findById(id);
        return produto
                .map(prod -> ResponseEntity.ok().body(prod))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<TimeDto>> listByNome(String q){
        List<Time> times = new ArrayList<>();
        times = timeRepository.findByNomeContainingIgnoreCase(q);
        return ResponseEntity.ok(TimeDto.converte(times));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return timeRepository.findById(id).map(prod -> {
            timeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}

