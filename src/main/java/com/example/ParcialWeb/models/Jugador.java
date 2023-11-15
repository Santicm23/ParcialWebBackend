package com.example.ParcialWeb.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private Long numero;
    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    private Equipo equipo;
}
