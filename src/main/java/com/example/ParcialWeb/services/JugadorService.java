package com.example.ParcialWeb.services;

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

    public List<Jugador> getJugadores() {
        return (List<Jugador>) jugadorRepository.findAll();
    }

    public Jugador getJugadorById(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador postJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador putJugador(Long id, Jugador jugador) {
        Jugador jugadorTemp = getJugadorById(id);

        if (jugadorTemp == null) return null;

        BeanUtils.copyProperties(jugador, jugadorTemp);

        return jugadorRepository.save(jugador);
    }

    public Jugador deleteJugador(Long id) {
        Jugador jugadorTemp = getJugadorById(id);
        jugadorRepository.deleteById(id);

        return jugadorTemp;
    }
}
