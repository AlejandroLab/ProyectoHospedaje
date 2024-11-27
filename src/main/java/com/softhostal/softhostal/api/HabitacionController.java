/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.api;

import com.softhostal.softhostal.models.Habitacion;
import com.softhostal.softhostal.repositories.HabitacionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author maria
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class HabitacionController {

    @Autowired
    HabitacionRepository repository;

    @GetMapping("/habitacion")
    public ResponseEntity<List<Habitacion>> getAll(@RequestParam(required = false) String piso) {
        try {
            List<Habitacion> lista = new ArrayList<Habitacion>();
            if(piso==""){
            repository.findAll().forEach(lista::add);
            }else{
                repository.findByPiso(piso).forEach(lista::add);
            }if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/habitacion/{id}")
    public ResponseEntity<Habitacion> getById(@PathVariable("id") Long id) {
        Optional<Habitacion> entidad = repository.findById(id);
        if (entidad.isPresent()) {
            return new ResponseEntity<>(entidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/habitacion")
    public ResponseEntity<Habitacion> create(@RequestBody Habitacion entidad) {
        try {
            Habitacion _entidad = repository.save(new Habitacion(null, entidad.getPiso(),entidad.getNumdehab(), entidad.getTipo(),entidad.getCaracteristica(), entidad.getPrecio(),entidad.getDisponibilidad()));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/habitacion/{id}")
    public ResponseEntity<Habitacion> update(@PathVariable("id") Long id, @RequestBody Habitacion entidad) {
        Habitacion _entidad = repository.findById(id).orElse(null);
        if (_entidad != null) {
            _entidad.setPiso(entidad.getPiso());
            _entidad.setNumdehab(entidad.getNumdehab());
            _entidad.setTipo(entidad.getTipo());
            _entidad.setCaracteristica(entidad.getCaracteristica());
            _entidad.setPrecio(entidad.getPrecio());
            _entidad.setDisponibilidad(entidad.getDisponibilidad());
            return new ResponseEntity<>(repository.save(_entidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
