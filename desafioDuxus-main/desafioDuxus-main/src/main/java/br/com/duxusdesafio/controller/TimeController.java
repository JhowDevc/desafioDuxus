package br.com.duxusdesafio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="/times")
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;


    @GetMapping
    public ResponseEntity<List<Time>> listAll(){
        List<Time> times = new ArrayList<>();
        times = timeRepository.findAll();
        return ResponseEntity.ok(times);
    }

//    @GetMapping
//    @Cacheable(value = "listaTimes")
//    public ResponseEntity<Page<Time>> listar(Pageable pageable){
//        var times = timeRepository;
//        return new ResponseEntity<>(times, HttpStatus.OK);
//    }

//    @PostMapping
//    @CacheEvict(value = "listaTimes")
//    public ResponseEntity<Time> create(@Valid @RequestBody Time time){
//        timeRepository.save(time);
//        return new ResponseEntity<>(time, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Time> findById(@PathVariable Long id) {
//        Optional<Time> time = timeRepository.findById(id);
//        return time
//                .map(prod -> ResponseEntity.ok().body(prod))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//
//    @GetMapping("/buscarPorNome")
//    public ResponseEntity<List<TimeDto>> listByNome(String q){
//        List<Time> times = new ArrayList<>();
//        times = timeRepository.findByNomeContainingIgnoreCase(q);
//        return ResponseEntity.ok(TimeDto.converte(times));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Time time) {
//        return timeRepository.findById(id).map(tim -> {
//
//            tim.setNome(time.getNome());
//
//
//
//            Time timeAtualizado = timeRepository.save(time);
//            return ResponseEntity.status(HttpStatus.OK).body(timeAtualizado);
//
//        }).orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteById(@PathVariable Long id) {
//        return timeRepository.findById(id).map(prod -> {
//            timeRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        }).orElse(ResponseEntity.notFound().build());
//    }

}