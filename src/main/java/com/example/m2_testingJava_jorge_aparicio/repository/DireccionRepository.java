package com.example.m2_testingJava_jorge_aparicio.repository;

import com.example.m2_testingJava_jorge_aparicio.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository <Direccion, Long> {

    List<Direccion> findByCodigoPostal (String codigoPostal);

}

