/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.api;

import com.softhostal.softhostal.models.Empleado;
import com.softhostal.softhostal.repositories.EmpleadoRepository;
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
public class EmpleadoController {
    
    @Autowired
    EmpleadoRepository repository;


    @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>> getAll(@RequestParam(required = false) String title) {
        try {
            List<Empleado> lista = new ArrayList<Empleado>();
            repository.findAll().forEach(lista::add);
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/empleado/{idempleado}")
    public ResponseEntity<Empleado> getById(@PathVariable("idempleado") Long id) {
        Optional<Empleado> entidad = repository.findById(id);
        if (entidad.isPresent()) {
            return new ResponseEntity<>(entidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<Empleado> create(@RequestBody Empleado entidad) {
        try {
            Empleado _entidad = repository.save(new Empleado(null, entidad.getIdpersona(), entidad.getSalario(),entidad.getCorreo(),entidad.getCargo(),entidad.getNumerotelefonico()));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<Empleado> update(@PathVariable("id") Long id, @RequestBody Empleado entidad) {
        Empleado _entidad = repository.findById(id).orElse(null);
        if (_entidad != null) {
            _entidad.setIdpersona(entidad.getIdpersona());
            _entidad.setSalario(entidad.getSalario());
            _entidad.setCorreo(entidad.getCorreo());
            _entidad.setCargo(entidad.getCargo());
            _entidad.setNumerotelefonico(entidad.getNumerotelefonico());
            return new ResponseEntity<>(repository.save(_entidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
