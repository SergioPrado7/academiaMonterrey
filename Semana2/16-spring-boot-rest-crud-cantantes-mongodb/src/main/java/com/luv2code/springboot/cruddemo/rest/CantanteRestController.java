package com.luv2code.springboot.cruddemo.rest;

import tools.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.cruddemo.entity.Cantante;
import com.luv2code.springboot.cruddemo.service.CantanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CantanteRestController {

    private CantanteService cantanteService;
    private JsonMapper jsonMapper;

    @Autowired
    public CantanteRestController(CantanteService theCantanteService, JsonMapper theJsonMapper) {
        cantanteService = theCantanteService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/cantantes")
    public List<Cantante> findAll() {
        return cantanteService.findAll();
    }

    @GetMapping("/cantantes/{cantanteId}")
    public Cantante getCantante(@PathVariable String cantanteId) {
        Cantante elCantante = cantanteService.findById(cantanteId);

        if (elCantante == null) {
            throw new RuntimeException("Cantante id no encontrado - " + cantanteId);
        }

        return elCantante;
    }

    @PostMapping("/cantantes")
    public Cantante addCantante(@RequestBody Cantante elCantante) {
        elCantante.setId(null);
        return cantanteService.save(elCantante);
    }

    @PutMapping("/cantantes")
    public Cantante updateCantante(@RequestBody Cantante elCantante) {
        return cantanteService.save(elCantante);
    }

    @PatchMapping("/cantantes/{cantanteId}")
    public Cantante patchCantante(@PathVariable String cantanteId,
            @RequestBody Map<String, Object> patchPayload) {

        Cantante tempCantante = cantanteService.findById(cantanteId);

        if (tempCantante == null) {
            throw new RuntimeException("Cantante id no encontrado - " + cantanteId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("El id del cantante no puede ser modificado. Quita 'id' del request body.");
        }

        Cantante patchedCantante = jsonMapper.updateValue(tempCantante, patchPayload);
        return cantanteService.save(patchedCantante);
    }

    @DeleteMapping("/cantantes/{cantanteId}")
    public String deleteCantante(@PathVariable String cantanteId) {
        Cantante tempCantante = cantanteService.findById(cantanteId);

        if (tempCantante == null) {
            throw new RuntimeException("Cantante id no encontrado - " + cantanteId);
        }

        cantanteService.deleteById(cantanteId);
        return "Cantante eliminado con id - " + cantanteId;
    }
}