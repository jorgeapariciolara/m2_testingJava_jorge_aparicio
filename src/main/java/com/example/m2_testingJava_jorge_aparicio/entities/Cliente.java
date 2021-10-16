package com.example.m2_testingJava_jorge_aparicio.entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String [] nombreCompleto;
    @OneToOne
    private Direccion direccionPostal;
    private String email;
    private String dni;
    private String [] telefono;
    private Integer edad;
    private Boolean carnetSocio;

    public Cliente () {}

    public Cliente(Long id,
                   String[] nombreCompleto,
                   Direccion direccionPostal,
                   String email,
                   String dni,
                   String[] telefono,
                   Integer edad,
                   Boolean carnetSocio) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.direccionPostal = direccionPostal;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.edad = edad;
        this.carnetSocio = carnetSocio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String[] getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String[] nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public Direccion getDireccionPostal() { return direccionPostal; }
    public void setDireccionPostal(Direccion direccionPostal) { this.direccionPostal = direccionPostal; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String[] getTelefono() { return telefono; }
    public void setTelefono(String[] telefono) { this.telefono = telefono; }
    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }
    public Boolean getCarnetSocio() { return carnetSocio; }
    public void setCarnetSocio(Boolean carnetSocio) { this.carnetSocio = carnetSocio; }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombreCompleto=" + Arrays.toString(nombreCompleto) +
                ", direccionPostal=" + direccionPostal +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono=" + Arrays.toString(telefono) +
                ", edad=" + edad +
                ", carnetSocio=" + carnetSocio +
                '}';
    }
}
