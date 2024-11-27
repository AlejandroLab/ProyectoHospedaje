/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.api;

import com.softhostal.softhostal.models.Recepcion;
import com.softhostal.softhostal.repositories.RecepcionRepository;
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
public class RecepcionController {

    @Autowired
    RecepcionRepository repository;

    @GetMapping("/recepcion")
    public ResponseEntity<List<Recepcion>> getAll(@RequestParam(required = false) String title) {
        try {
            List<Recepcion> lista = new ArrayList<Recepcion>();
            repository.findAll().forEach(lista::add);
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recepcion/{id}")
    public ResponseEntity<Recepcion> getById(@PathVariable("id") Long id) {
        Optional<Recepcion> entidad = repository.findById(id);
        if (entidad.isPresent()) {
            return new ResponseEntity<>(entidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/recepcion")
    public ResponseEntity<Recepcion> create(@RequestBody Recepcion entidad) {
        try {
            Recepcion _entidad = repository.save(new Recepcion(null, entidad.getEstado(),entidad.getFechaentra(),entidad.getFechasalida(),entidad.getProducto(),entidad.getCliente()));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/recepcion/{id}")
    public ResponseEntity<Recepcion> update(@PathVariable("id") Long id, @RequestBody Recepcion entidad) {
        Recepcion _entidad = repository.findById(id).orElse(null);
        if (_entidad != null) {
            _entidad.setEstado(entidad.getEstado());
            _entidad.setFechaentra(entidad.getFechaentra());
            _entidad.setFechasalida(entidad.getFechasalida());
            _entidad.setProducto(entidad.getProducto());
            _entidad.setCliente(entidad.getCliente());
            return new ResponseEntity<>(repository.save(_entidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/recepcion/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
