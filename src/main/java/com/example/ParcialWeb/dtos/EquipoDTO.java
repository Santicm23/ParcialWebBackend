package com.example.ParcialWeb.dtos;

import com.example.ParcialWeb.models.Equipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipoDTO {
    private String nombre;
    private String ciudad;
    private Long cantidadCopasInternacionales;

    public EquipoDTO() {}

    public EquipoDTO(Equipo equipo) {
        this.nombre = equipo.getNombre();
        this.ciudad = equipo.getCiudad();
        this.cantidadCopasInternacionales = equipo.getCantidadCopasInternacionales();
    }
}
