package com.luv2code.springboot.cruddemo.rest;

import tools.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.cruddemo.entity.Futbolista;
import com.luv2code.springboot.cruddemo.service.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CantanteRestController {

    private FutbolistaService cantanteService;
    private JsonMapper jsonMapper;

    @Autowired
    public CantanteRestController(FutbolistaService theCantanteService, JsonMapper theJsonMapper) {
        cantanteService = theCantanteService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/cantantes")
    public List<Futbolista> findAll() {
        return cantanteService.findAll();
    }

    @GetMapping("/cantantes/{cantanteId}")
    public Futbolista getCantante(@PathVariable String cantanteId) {
        Futbolista elCantante = cantanteService.findById(cantanteId);

        if (elCantante == null) {
            throw new RuntimeException("Cantante id no encontrado - " + cantanteId);
        }

        return elCantante;
    }

    @PostMapping("/cantantes")
    public Futbolista addCantante(@RequestBody Futbolista elCantante) {
        elCantante.setId(null);
        return cantanteService.save(elCantante);
    }

    @PutMapping("/cantantes")
    public Futbolista updateCantante(@RequestBody Futbolista elCantante) {
        return cantanteService.save(elCantante);
    }

    @PatchMapping("/cantantes/{cantanteId}")
    public Futbolista patchCantante(@PathVariable String cantanteId,
            @RequestBody Map<String, Object> patchPayload) {

        Futbolista tempCantante = cantanteService.findById(cantanteId);

        if (tempCantante == null) {
            throw new RuntimeException("Cantante id no encontrado - " + cantanteId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("El id del cantante no puede ser modificado. Quita 'id' del request body.");
        }

        Futbolista patchedCantante = jsonMapper.updateValue(tempCantante, patchPayload);
        return cantanteService.save(patchedCantante);
    }

    @DeleteMapping("/cantantes/{cantanteId}")
    public String deleteCantante(@PathVariable String cantanteId) {
        Futbolista tempCantante = cantanteService.findById(cantanteId);

        if (tempCantante == null) {
            throw new RuntimeException("Cantante id no encontrado - " + cantanteId);
        }

        cantanteService.deleteById(cantanteId);
        return "Cantante eliminado con id - " + cantanteId;
    }
}