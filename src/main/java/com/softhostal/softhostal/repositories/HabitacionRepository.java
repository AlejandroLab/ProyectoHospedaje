/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.repositories;

import com.softhostal.softhostal.models.Habitacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maria
 */
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion>findByPiso(String piso);
}
