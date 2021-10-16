package com.example.m2_testingJava_jorge_aparicio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direccion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String tipoDeVia;
    String nombreVia;
    Integer numVia;
    String portal;
    String escalera;
    Integer piso;
    String puerta;
    String codigoPostal;
    String ciudad;
    String pais;

    public Direccion () {}

    public Direccion(Long id,
                     String tipoDeVia,
                     String nombreVia,
                     Integer numVia,
                     String portal,
                     String escalera,
                     Integer piso,
                     String puerta,
                     String codigoPostal,
                     String ciudad,
                     String pais) {
        this.id = id;
        this.tipoDeVia = tipoDeVia;
        this.nombreVia = nombreVia;
        this.numVia = numVia;
        this.portal = portal;
        this.escalera = escalera;
        this.piso = piso;
        this.puerta = puerta;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}
    public String getTipoDeVia() {return tipoDeVia;}
    public void setTipoDeVia(String tipoDeVia) {this.tipoDeVia = tipoDeVia;}
    public String getNombreVia() {return nombreVia;}
    public void setNombreVia(String nombreVia) {this.nombreVia = nombreVia;}
    public Integer getNumVia() {return numVia;}
    public void setNumVia(Integer numVia) {this.numVia = numVia;}
    public String getPortal() {return portal;}
    public void setPortal(String portal) {this.portal = portal;}
    public String getEscalera() {return escalera;}
    public void setEscalera(String escalera) {this.escalera = escalera;}
    public Integer getPiso() {return piso;}
    public void setPiso(Integer piso) {this.piso = piso;}
    public String getPuerta() {return puerta;}
    public void setPuerta(String puerta) {this.puerta = puerta;}
    public String getCodigoPostal() {return codigoPostal;}
    public void setCodigoPostal(String codigoPostal) {this.codigoPostal = codigoPostal;}
    public String getCiudad() {return ciudad;}
    public void setCiudad(String ciudad) {this.ciudad = ciudad;}
    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", tipoDeVia='" + tipoDeVia + '\'' +
                ", nombreVia='" + nombreVia + '\'' +
                ", numVia=" + numVia +
                ", portal=" + portal +
                ", escalera='" + escalera + '\'' +
                ", piso=" + piso +
                ", puerta='" + puerta + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
