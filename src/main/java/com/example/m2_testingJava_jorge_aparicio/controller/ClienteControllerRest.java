package com.example.m2_testingJava_jorge_aparicio.controller;

import com.example.m2_testingJava_jorge_aparicio.entities.Cliente;
import com.example.m2_testingJava_jorge_aparicio.entities.Direccion;
import com.example.m2_testingJava_jorge_aparicio.repository.ClienteRepository;
import com.example.m2_testingJava_jorge_aparicio.repository.DireccionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteControllerRest {

    private ClienteRepository clienteRepository;
    public ClienteControllerRest(ClienteRepository clienteRepository) {}

    private DireccionRepository direccionRepository;
    public ClienteControllerRest (DireccionRepository direccionRepository) {}

    // MÉTODOS
    // CREAR REGISTROS DE PRUEBA
    @GetMapping ("/clientes/data")
    public void demoData () {
        // Cliente 1
        String[] nombreCompleto1 = new String[3];
        nombreCompleto1[0] = "Jesús";
        nombreCompleto1[1] = "Bonilla";
        nombreCompleto1[2] = "Pérez";
        String[] telefono1 = new String[3];
        telefono1[0] = "915951595";
        telefono1[1] = "656951595";
        telefono1[2] = "656951888";
        clienteRepository.save(new Cliente(null, nombreCompleto1, direccionRepository.save(new Direccion(null,
                "Calle", "Argüeso", 21, "D", null, 4,
                "Derecha", "28025", "Madrid", "España")),
                "jesus.bonilla@gmail.com", "99999999Z", telefono1, 27, true));

        // Cliente 2
        String[] nombreCompleto2 = new String[3];
        nombreCompleto2[0] = "Patricia";
        nombreCompleto2[1] = "Merino";
        nombreCompleto2[2] = "Pelaez";
        String[] telefono2 = new String[3];
        telefono2[0] = "915251577";
        telefono2[1] = "656951444";
        telefono2[2] = "656951235";
        clienteRepository.save(new Cliente(null, nombreCompleto2, direccionRepository.save(new Direccion(null,
                "Plaza", "Elíptica", 1, null, "Central", 7,
                "F", "28025", "Madrid", "España")), "patri.chula@hotmail.com",
                "88888888Y", telefono2, 27, true));

        // Cliente 3
        String[] nombreCompleto3 = new String[3];
        nombreCompleto3[0] = "Mª Jesús";
        nombreCompleto3[1] = "Bermúdez";
        nombreCompleto3[2] = "Pérez";
        String[] telefono3 = new String[3];
        telefono1[0] = "911011595";
        telefono1[1] = "665487595";
        telefono1[2] = "698989898";
        clienteRepository.save(new Cliente(null, nombreCompleto3, direccionRepository.save(new Direccion(null,
                "Calle", "Radio", 51, "3", "Izquierda", 3,
                "D", "28019", "Madrid", "España")), "chusabermudez@gmail.com",
                "77777777X", telefono3, 27, true));

    }
    // CONSULTAR TODOS LOS REGISTROS
    @GetMapping ("/clientes")
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
    // CONSULTAR UN REGISTRO POR ID
    @GetMapping ("/clientes/{id}")
    public Cliente findById(@PathVariable Long id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            return clienteOpt.get();
        } else {
            return null;
        }
    }
    // CONSULTAR UN REGISTRO POR DNI
    @GetMapping ("/clientes/{dni}")
    public List<Cliente> findByDni (@PathVariable String dni) {
        return clienteRepository.findByDni(dni);
    }
    // CREAR UN REGISTRO
    @PostMapping ("/clientes")
    public void create(@RequestBody Cliente cliente){
        if (cliente.getId() == null)
            clienteRepository.save(cliente);
    }
    // ACTUALIZAR UN REGISTRO
    @PutMapping("/clientes")
    public void update(@RequestBody Cliente cliente){
        if(cliente.getId() != null && clienteRepository.existsById(cliente.getId()))
            clienteRepository.save(cliente);
    }
    // BORRAR UN REGISTRO
    @DeleteMapping("/clientes/{id}")
    public void deleteById(@PathVariable Long id){
        if (clienteRepository.existsById(id))
            clienteRepository.deleteById(id);
    }

}
