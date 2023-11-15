package com.example.ParcialWeb.services;

import com.example.ParcialWeb.dtos.EquipoDTO;
import com.example.ParcialWeb.models.Equipo;
import com.example.ParcialWeb.repositories.EquipoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<EquipoDTO> getEquipos() {
        List<Equipo> equipos = (List<Equipo>) equipoRepository.findAll();
        return equipos.stream().map(EquipoDTO::new).toList();
    }

    public EquipoDTO getEquipoById(Long id) {
        Equipo equipo = equipoRepository.findById(id).orElse(null);
        if (equipo == null) return null;
        return new EquipoDTO(equipo);
    }

    public EquipoDTO postEquipo(Equipo equipo) {
        return new EquipoDTO(equipoRepository.save(equipo));
    }

    public EquipoDTO putEquipo(Long id, Equipo equipo) {
        Equipo equipoTemp = equipoRepository.findById(id).orElse(null);

        if (equipoTemp == null) return null;

        BeanUtils.copyProperties(equipo, equipoTemp);

        return new EquipoDTO(equipoRepository.save(equipo));
    }

    public EquipoDTO deleteEquipo(Long id) {
        Equipo equipoTemp = equipoRepository.findById(id).orElse(null);
        if (equipoTemp == null) return null;
        equipoRepository.deleteById(id);

        return new EquipoDTO(equipoTemp);
    }
}
