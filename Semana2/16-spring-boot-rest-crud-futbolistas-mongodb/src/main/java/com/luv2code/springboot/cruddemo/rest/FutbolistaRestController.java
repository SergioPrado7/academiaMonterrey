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
public class FutbolistaRestController {

    private FutbolistaService futbolistaService;
    private JsonMapper jsonMapper;

    @Autowired
    public FutbolistaRestController(FutbolistaService theFutbolistaService, JsonMapper theJsonMapper) {
        futbolistaService = theFutbolistaService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/futbolistas")
    public List<Futbolista> findAll() {
        return futbolistaService.findAll();
    }

    @GetMapping("/futbolistas/{futbolistaId}")
    public Futbolista getFutbolista(@PathVariable String futbolistaId) {
        Futbolista elFutbolista = futbolistaService.findById(futbolistaId);

        if (elFutbolista == null) {
            throw new RuntimeException("Futbolista id no encontrado - " + futbolistaId);
        }
        return elFutbolista;
    }

    @PostMapping("/futbolistas")
    public Futbolista addFutbolista(@RequestBody Futbolista elFutbolista) {
        elFutbolista.setId(null); 
        return futbolistaService.save(elFutbolista);
    }

    @PutMapping("/futbolistas")
    public Futbolista updateFutbolista(@RequestBody Futbolista elFutbolista) {
        return futbolistaService.save(elFutbolista);
    }

    @PatchMapping("/futbolistas/{futbolistaId}")
    public Futbolista patchFutbolista(@PathVariable String futbolistaId,
            @RequestBody Map<String, Object> patchPayload) {

        Futbolista tempFutbolista = futbolistaService.findById(futbolistaId);

        if (tempFutbolista == null) {
            throw new RuntimeException("Futbolista id no encontrado - " + futbolistaId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("El id del futbolista no puede ser modificado.");
        }

        Futbolista patchedFutbolista = jsonMapper.updateValue(tempFutbolista, patchPayload);
        return futbolistaService.save(patchedFutbolista);
    }

    @DeleteMapping("/futbolistas/{futbolistaId}")
    public String deleteFutbolista(@PathVariable String futbolistaId) {
        Futbolista tempFutbolista = futbolistaService.findById(futbolistaId);

        if (tempFutbolista == null) {
            throw new RuntimeException("Futbolista id no encontrado - " + futbolistaId);
        }

        futbolistaService.deleteById(futbolistaId);
        return "Futbolista eliminado con id - " + futbolistaId;
    }
}