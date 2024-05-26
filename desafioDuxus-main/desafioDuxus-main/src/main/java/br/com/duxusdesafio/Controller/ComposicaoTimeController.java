package br.com.duxusdesafio.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/ComposicaoTime")
public class ComposicaoTimeController {

    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;


    @GetMapping
    public ResponseEntity<List<ComposicaoTime>> listAll() {
        List<ComposicaoTime> composicaoTimes = new ArrayList<>();
        composicaoTimes = composicaoTimeRepository.findAll();
        return new ResponseEntity<>(composicaoTimes, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<ComposicaoTime> findById(@PathVariable Long id) {
        Optional<ComposicaoTime> composicaoTime = composicaoTimeRepository.findById(id);
        return composicaoTime
                .map(prod -> ResponseEntity.ok().body(prod))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return composicaoTimeRepository.findById(id).map(prod -> {
            composicaoTimeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}

