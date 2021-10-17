package com.example.m2_testingJava_jorge_aparicio.repository;

import com.example.m2_testingJava_jorge_aparicio.entities.Cliente;
import com.example.m2_testingJava_jorge_aparicio.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    List<Cliente> findByNombreCompleto (String[] nombre);

    List<Cliente> findByDni (String dni);

    List<Cliente> findByDireccionPostal (Direccion direccion);

}
