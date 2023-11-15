package com.example.ParcialWeb.services;

import com.example.ParcialWeb.dtos.JugadorDTO;
import com.example.ParcialWeb.models.Jugador;
import com.example.ParcialWeb.repositories.JugadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<JugadorDTO> getJugadores() {
        List<Jugador> jugadores = (List<Jugador>) jugadorRepository.findAll();

        return jugadores.stream().map(JugadorDTO::new).toList();
    }

    public JugadorDTO getJugadorById(Long id) {
        Jugador jugadorTemp = jugadorRepository.findById(id).orElse(null);

        if (jugadorTemp == null) return null;

        return new JugadorDTO(jugadorTemp);
    }

    public JugadorDTO postJugador(Jugador jugador) {
        return new JugadorDTO(jugadorRepository.save(jugador));
    }

    public JugadorDTO putJugador(Long id, Jugador jugador) {
        Jugador jugadorTemp = jugadorRepository.findById(id).orElse(null);

        if (jugadorTemp == null) return null;

        BeanUtils.copyProperties(jugador, jugadorTemp);

        return new JugadorDTO(jugadorRepository.save(jugador));
    }

    public JugadorDTO deleteJugador(Long id) {
        Jugador jugadorTemp = jugadorRepository.findById(id).orElse(null);

        if (jugadorTemp == null) return null;

        jugadorRepository.deleteById(id);

        return new JugadorDTO(jugadorTemp);
    }
}
