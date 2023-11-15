package com.example.ParcialWeb.controllers;

import com.example.ParcialWeb.dtos.JugadorDTO;
import com.example.ParcialWeb.models.Jugador;
import com.example.ParcialWeb.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    @GetMapping(value = "/jugadores", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<JugadorDTO> getJugadores() {
        return jugadorService.getJugadores();
    }

    @GetMapping(value = "/jugador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public JugadorDTO getJugadorById(@PathVariable Long id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping(value = "/jugador", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public JugadorDTO postJugador(@RequestBody Jugador jugador) {
        return jugadorService.postJugador(jugador);
    }

    @PutMapping(value = "/jugador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public JugadorDTO putJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        return jugadorService.putJugador(id, jugador);
    }

    @DeleteMapping(value = "/jugador/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public JugadorDTO deleteJugador(@PathVariable Long id) {
        return jugadorService.deleteJugador(id);
    }
}
