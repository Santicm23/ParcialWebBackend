package com.example.ParcialWeb.dtos;

import com.example.ParcialWeb.models.Jugador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JugadorDTO {
    private String nombres;
    private String apellidos;
    private Long numero;
    private String equipo;

    public JugadorDTO() {}

    public JugadorDTO(Jugador jugador) {
        this.nombres = jugador.getNombres();
        this.apellidos = jugador.getApellidos();
        this.numero = jugador.getNumero();
        this.equipo = jugador.getEquipo().getNombre();
    }
}
