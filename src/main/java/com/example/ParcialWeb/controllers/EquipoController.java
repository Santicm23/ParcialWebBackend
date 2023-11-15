package com.example.ParcialWeb.controllers;

import com.example.ParcialWeb.dtos.EquipoDTO;
import com.example.ParcialWeb.models.Equipo;
import com.example.ParcialWeb.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @GetMapping(value = "/equipos", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<EquipoDTO> getCanciones() {
        return equipoService.getEquipos();
    }

    @GetMapping(value = "/equipo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public EquipoDTO getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }

    @PostMapping(value = "/equipo", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public EquipoDTO postEquipo(@RequestBody Equipo equipo) {
        return equipoService.postEquipo(equipo);
    }

    @PutMapping(value = "/equipo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public EquipoDTO putEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.putEquipo(id, equipo);
    }

    @DeleteMapping(value = "/equipo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public EquipoDTO deleteEquipo(@PathVariable Long id) {
        return equipoService.deleteEquipo(id);
    }
}
