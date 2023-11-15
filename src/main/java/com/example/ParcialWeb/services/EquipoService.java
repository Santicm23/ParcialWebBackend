package com.example.ParcialWeb.services;

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

    public List<Equipo> getEquipos() {
        return (List<Equipo>) equipoRepository.findAll();
    }

    public Equipo getEquipoById(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo postEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo putEquipo(Long id, Equipo equipo) {
        Equipo equipoTemp = getEquipoById(id);

        if (equipoTemp == null) return null;

        BeanUtils.copyProperties(equipo, equipoTemp);

        return equipoRepository.save(equipo);
    }

    public Equipo deleteEquipo(Long id) {
        Equipo equipoTemp = getEquipoById(id);
        equipoRepository.deleteById(id);

        return equipoTemp;
    }
}
