package com.example.m2_testingJava_jorge_aparicio.controller;

import com.example.m2_testingJava_jorge_aparicio.entities.Cliente;
import com.example.m2_testingJava_jorge_aparicio.entities.Direccion;
import com.example.m2_testingJava_jorge_aparicio.repository.ClienteRepository;
import com.example.m2_testingJava_jorge_aparicio.repository.DireccionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteControllerMvc {

    private ClienteRepository clienteRepository;
    public ClienteControllerMvc(ClienteRepository clienteRepository) {}

    private DireccionRepository direccionRepository;
    public ClienteControllerMvc (DireccionRepository direccionRepository) {}


    // MÉTODOS
    // CREAR REGISTROS DE PRUEBA
    @GetMapping("/clientes/data")
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
        Direccion direccionPostal1 = new Direccion (null, "Calle", "Argüeso", 21, "D", null, 4,
                "Derecha", "28025", "Madrid", "España");
        Cliente cliente1 = new Cliente(null, nombreCompleto1, direccionPostal1,
                "jesus.bonilla@gmail.com", "99999999Z", telefono1, 27, true);
        // Cliente 2
        String[] nombreCompleto2 = new String[3];
        nombreCompleto2[0] = "Patricia";
        nombreCompleto2[1] = "Merino";
        nombreCompleto2[2] = "Pelaez";
        String[] telefono2 = new String[3];
        telefono2[0] = "915251577";
        telefono2[1] = "656951444";
        telefono2[2] = "656951235";
        Direccion direccionPostal2 = new Direccion (null, "Plaza", "Elíptica", 1, null, "Central", 7,
                "F", "28025", "Madrid", "España");
        Cliente cliente2 = new Cliente(null, nombreCompleto2, direccionPostal2, "patri.chula@hotmail.com",
                "88888888Y", telefono2, 27, true);
        // Cliente 3
        String[] nombreCompleto3 = new String[3];
        nombreCompleto3[0] = "Mª Jesús";
        nombreCompleto3[1] = "Bermúdez";
        nombreCompleto3[2] = "Pérez";
        String[] telefono3 = new String[3];
        telefono3[0] = "911011595";
        telefono3[1] = "665487595";
        telefono3[2] = "698989898";
        Direccion direccionPostal3 = new Direccion (null, "Calle", "Radio", 51, "3", "Izquierda", 3,
                "D", "28019", "Madrid", "España");
        Cliente cliente3 = new Cliente(null, nombreCompleto3, direccionPostal3, "chusabermudez@gmail.com",
                "77777777X", telefono3, 27, true);

        direccionRepository.save(direccionPostal1);
        direccionRepository.save(direccionPostal2);
        direccionRepository.save(direccionPostal3);
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
    }
    // RECUPERAR TODOS LOS REGISTROS
    @GetMapping ("/clientes")
    public String findAll(Model model){
        // 1. Recuperamos los registros de base de datos: RETRIEVE
        List<Cliente> clientes = clienteRepository.findAll();
        // 2. Cargamos los productos en el Model
        model.addAttribute("clientes", clientes);
        // 3. Nos movemos a la vista (HTML)
        return "cliente-list"; // nombre del archivo html
    }
    // RECUPERAR UN REGISTRO UTILIZANDO EL ID
    @GetMapping("/clientes/{id}")
    public String findById(@PathVariable Long id, Model model){
        // 1. Recuperamos el registro de base de datos (si es que existe)
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if(clienteOpt.isEmpty())
            return "redirect:/products";
        // 2. Cargamos el registro en el modelo
        // 2.1. Sacamos el registro
        Cliente cliente = clienteOpt.get();
        // 2.2 Cargamos el registro en el modelo
        model.addAttribute("cliente", cliente);
        // 3. Nos movemos a la vista (HTML))
        return "cliente-view";
    }
    // CREAR UN REGISTRO NUEVO
    @GetMapping("/clientes/new")
    public String showForm(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cliente-form";
    }
    @PostMapping("/clientes")
    public String create(@ModelAttribute("product") Cliente cliente){
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }
    // ELIMINAR UN REGISTRO UTILIZANDO EL ID
    @GetMapping("/clientes/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        // Comprobamos si el registro existe en la base de datos
        if(clienteRepository.existsById(id))
        // Si existe lo borramos
            clienteRepository.deleteById(id);
        // Y, una vez borrado, nos redirigimos al listado actualizado
        return "redirect:/clientes";
    }


}
