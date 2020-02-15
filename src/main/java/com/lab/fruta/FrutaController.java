package com.lab.fruta;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
public class FrutaController {

    private final FrutaMapper mapper;

    @Autowired
    public FrutaController(FrutaMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/fruta")
    public ResponseEntity<List<Fruta>> listarFrutas() {
        List<Fruta> listaFrutas = mapper.listaFrutas();
        if (listaFrutas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaFrutas);
    }

    @GetMapping("/fruta/{id}")
    public ResponseEntity<Fruta> detalhesFruta(@PathVariable("id") Long id) {
        Optional<Fruta> fruta = mapper.getFruta(id);
        if (!fruta.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fruta.get());
    }
}
