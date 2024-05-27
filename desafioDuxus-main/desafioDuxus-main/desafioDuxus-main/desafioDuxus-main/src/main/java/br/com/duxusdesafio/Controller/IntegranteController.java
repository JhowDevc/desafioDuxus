package br.com.duxusdesafio.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import br.com.duxusdesafio.Controller.dto.IntegranteDto;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;
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
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;


    @GetMapping
    public ResponseEntity<List<Integrante>> listAll() {
        List<Integrante> integrantes = new ArrayList<>();
        integrantes = integranteRepository.findAll();
        return new ResponseEntity<>(integrantes, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Integrante> findById(@PathVariable Long id) {
        Optional<Integrante> integrante = integranteRepository.findById(id);
        return integrante
                .map(prod -> ResponseEntity.ok().body(prod))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<IntegranteDto>> listByNome(String q){
        List<Integrante> integrantes = new ArrayList<>();
        integrantes = integranteRepository.findByNomeContainingIgnoreCase(q);
        return ResponseEntity.ok(IntegranteDto.converte(integrantes));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return integranteRepository.findById(id).map(prod -> {
            integranteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}

