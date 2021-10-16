package com.example.m2_testingJava_jorge_aparicio;

import com.example.m2_testingJava_jorge_aparicio.entities.Cliente;
import com.example.m2_testingJava_jorge_aparicio.entities.Direccion;
import com.example.m2_testingJava_jorge_aparicio.repository.ClienteRepository;
import com.example.m2_testingJava_jorge_aparicio.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2TestingJavaJorgeAparicioApplication implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	DireccionRepository direccionRepository;

	public static void main(String[] args) {
		SpringApplication.run(M2TestingJavaJorgeAparicioApplication.class, args);
	}

	public void showMenu() {
		System.out.println("Bienvenido/a a la aplicación, seleccione una opción: ");
		System.out.println("0.- SALIR DE LA APLICACIÓN");
		System.out.println("1.- Consultar el número total de clientes");
		System.out.println("2.- Consultar todos los clientes");
		System.out.println("3.- Consultar un cliente (utilizando el id)");
		System.out.println("4.- Crear un nuevo cliente");
		System.out.println("5.- Modificar un cliente (utilizando el id)");
		System.out.println("6.- Borrar un cliente (utilizando el id)");
		System.out.println("7.- Borrar todos los clientes");
		System.out.println("8.- Consultar un cliente utilizando el nombre completo");
		System.out.println("9.- Consultar un cliente utilizando el DNI");
		System.out.println("10.- Consultar todos los clientes utilizando el código postal");
	}

	@Override
	public void run(String... args) throws Exception {

		// Creo algunos clientes de prueba
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
				"Calle", "Argüeso", 21, "A", null, 4,
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

		Scanner scanner = new Scanner(System.in);

		while (true) {

			showMenu();

			try {
				int opcion = scanner.nextInt();
				scanner.nextLine();
				List<Cliente> clientes;

				if (opcion == 0) {
					System.out.println("Ha seleccionado la opción 0 - SALIR DE LA APLICACIÓN");
					System.out.println("*****************************************************");
					System.out.println("¡HASTA LA PRÓXIMA!");
					break;

				} else if (opcion == 1) {
					System.out.println("Ha seleccionado la opción 1 - CONSULTAR EL Nº TOTAL DE CLIENTES");
					clientes = clienteRepository.findAll();
					if (clientes.isEmpty()) {
						System.out.println("En este momento NO hay clientes registrados.");
					} else {
						long numClientes = clienteRepository.count();
						System.out.println("El número de clientes es: " + numClientes);
					}

				} else if (opcion == 2) {
					System.out.println("Ha seleccionado la opción 2 - CONSULTAR TODOS LOS CLIENTES");
					clientes = clienteRepository.findAll();
					if (clientes.isEmpty()) {
						System.out.println("En este momento NO hay clientes registrados.");
					} else {
						long numClientes = clienteRepository.count();
						System.out.println("El número de clientes es: " + numClientes);
						for (Cliente cliente : clientes) {
							System.out.println(cliente);
						}
					}

				} else if (opcion == 3) {
					System.out.println("Ha seleccionado la opción 3 - CONSULTAR UN CLIENTE (utilizando el id)");
					System.out.println("Por favor, introduzca el id del cliente que desea consultar: ");
					Long id = scanner.nextLong();
					Optional<Cliente> clienteOpt = clienteRepository.findById(id);
					if (clienteOpt.isPresent()) {
						Cliente cliente = clienteOpt.get();
						System.out.println("Consultando un solo cliente...");
						System.out.println(cliente);
					} else {
						System.out.println("No existe ningún cliente con ese id");
					}

				} else if (opcion == 4) {
					System.out.println("Ha seleccionado la opción 4 - CREAR UN NUEVO CLIENTE");

					System.out.println("1. DATOS PERSONALES");
					System.out.println("Introduzca el NOMBRE");
					String nombre = scanner.next();
					System.out.println("Introduzca el PRIMER APELLIDO");
					String primerApellido = scanner.next();
					System.out.println("Introduzca el SEGUNDO APELLIDO");
					String segundoApellido = scanner.next();
					String[] nombreCompleto = new String[3];
					nombreCompleto1[0] = nombre;
					nombreCompleto1[1] = primerApellido;
					nombreCompleto1[2] = segundoApellido;

					System.out.println("2. DIRECCIÓN POSTAL");
					System.out.println("Introduzca el TIPO DE VÍA (Calle, Plaza, Camino, etc.)");
					String tipoVia = scanner.next();
					System.out.println("Introduzca el NOMBRE DE LA VÍA");
					String nombreVia = scanner.next();
					System.out.println("Introduzca el NÚMERO DE LA VÍA");
					int numVia = scanner.nextInt();
					scanner.nextLine();
					System.out.println("¿Quiere introducir el PORTAL? (SÍ / NO)");
					String portal = "";
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca el PORTAL");
						portal = scanner.next();
					}
					System.out.println("¿Quiere introducir la ESCALERA? (SÍ / NO)");
					String escalera = "";
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca la ESCALERA");
						escalera = scanner.next();
					}
					System.out.println("¿Quiere introducir el PISO? (Sí / NO)");
					int piso = 0;
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca el PISO");
						piso = scanner.nextInt();
						scanner.nextLine();
					}
					System.out.println("¿Quiere introducir la PUERTA? (Sí / NO)");
					String puerta = "";
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca la PUERTA");
						puerta = scanner.next();
					}
					System.out.println("Introduzca el CÓDIGO POSTAL");
					String codigoPostal = scanner.next();
					System.out.println("Introduzca la CIUDAD");
					String ciudad = scanner.next();
					System.out.println("Introduzca el PAÍS");
					String pais = scanner.next();

					System.out.println("3. EMAIL");
					System.out.println("Introduzca el email");
					String email = scanner.next();

					System.out.println("4. DNI");
					System.out.println("Introduzca el DNI");
					String dni = scanner.next();

					System.out.println("5. TELÉFONOS");
					System.out.println("¿Tiene TELÉFONO FIJO? (SÍ / NO");
					String respuesta1 = scanner.next();
					String telefonoDomicilio = "";
					if (respuesta1.equalsIgnoreCase("si")) {
						System.out.println("Introduzca el nº de teléfono");
						telefonoDomicilio = scanner.next();
					}
					System.out.println("¿Tiene TELÉFONO MÓVIL? (SÍ / NO");
					String respuesta2 = scanner.next();
					String telefonoMovil = "";
					if (respuesta2.equalsIgnoreCase("si")) {
						System.out.println("Introduzca el nº de teléfono");
						telefonoMovil = scanner.next();
					}
					System.out.println("¿Tiene TELÉFONO del TRABAJO?");
					String respuesta3 = scanner.next();
					String telefonoTrabajo = "";
					if (respuesta3.equalsIgnoreCase("si")) {
						System.out.println("Introduzca el nº de teléfono");
						telefonoTrabajo = scanner.next();
					}
					String[] telefono = new String[3];
					telefono[0] = telefonoDomicilio;
					telefono[1] = telefonoMovil;
					telefono[2] = telefonoTrabajo;

					System.out.println("6. EDAD");
					System.out.println("Introduzca la edad");
					int edad = scanner.nextInt();
					scanner.nextLine();

					System.out.println("7. CARNET DE SOCIO");
					System.out.println("Tiene carnet de socio");
					boolean carnetSocio = scanner.nextBoolean();
					scanner.nextLine();

					clienteRepository.save(new Cliente(null, nombreCompleto, direccionRepository.save(new Direccion
							(null, tipoVia, nombreVia, numVia, portal, escalera, piso, puerta, codigoPostal,
									ciudad, pais)), email, dni, telefono, edad, carnetSocio));

					System.out.println("Cliente creado correctamente. Actualmente existen "
							+ clienteRepository.count() + " registros.");

				} else if (opcion == 5) {
					System.out.println("Ha seleccionado la opción 5 - MODIFICAR UN CLIENTE (utilizando el id)");

					System.out.println("Por favor, introduzca el id del cliente que desea modificar: ");
					Long id = scanner.nextLong();
					Optional<Cliente> clienteOpt = clienteRepository.findById(id);
					if (clienteOpt.isEmpty()) {
						Cliente cliente = clienteOpt.get();
						System.out.println("No existe ningún cliente con ese id");
						continue;
					}
					Cliente cliente = clienteOpt.get();

					System.out.println("Introduzca el NOMBRE (actual: " + cliente.getNombreCompleto()[0] + ")");
					String nombre = scanner.next();
					System.out.println("Introduzca el PRIMER APELLIDO (actual: " +
							cliente.getNombreCompleto()[1] + ")");
					String primerApellido = scanner.next();
					System.out.println("Introduzca el SEGUNDO APELLIDO (actual: " +
							cliente.getNombreCompleto()[2] + ")");
					String segundoApellido = scanner.next();
					String[] nombreCompleto = new String[3];
					nombreCompleto[0] = nombre;
					nombreCompleto[1] = primerApellido;
					nombreCompleto[2] = segundoApellido;
					cliente.setNombreCompleto(nombreCompleto);

					System.out.println("2. DIRECCIÓN POSTAL");
					System.out.println("Introduzca el TIPO DE VÍA (actual: "
							+ cliente.getDireccionPostal().getTipoDeVia() + " )");
					cliente.getDireccionPostal().setTipoDeVia(scanner.next());
					System.out.println("Introduzca el NOMBRE DE LA VÍA (actual: "
							+ cliente.getDireccionPostal().getNombreVia() + " )");
					cliente.getDireccionPostal().setNombreVia(scanner.next());
					System.out.println("Introduzca el NÚMERO DE LA VÍA (actual: "
							+ cliente.getDireccionPostal().getNumVia() + " )");
					cliente.getDireccionPostal().setNumVia(scanner.nextInt());
					System.out.println("¿Quiere introducir el PORTAL? SÍ / NO (actual: " +
							cliente.getDireccionPostal().getPortal() + " )");
					short portal = ' ';
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca el PORTAL");
						portal = scanner.nextShort();
					}
					System.out.println("¿Quiere introducir la ESCALERA? SÍ / NO (actual: "
							+ cliente.getDireccionPostal().getEscalera() + " )");
					String escalera = "";
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca la ESCALERA");
						escalera = scanner.next();
					}
					System.out.println("¿Quiere introducir el PISO? SÍ / NO (actual: "
							+ cliente.getDireccionPostal().getPiso() + " )");
					int piso = 0;
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca el PISO");
						piso = scanner.nextInt();
						scanner.nextLine();
					}
					System.out.println("¿Quiere introducir la PUERTA? SÍ / NO (actual: "
							+ cliente.getDireccionPostal().getPuerta() + " )");
					String puerta = "";
					if (scanner.next().equalsIgnoreCase("si")) {
						System.out.println("Introduzca la PUERTA");
						puerta = scanner.next();
					}
					System.out.println("Introduzca el CÓDIGO POSTAL (actual: "
							+ cliente.getDireccionPostal().getCodigoPostal() + " )");
					cliente.getDireccionPostal().setCodigoPostal(scanner.next());
					System.out.println("Introduzca la CIUDAD (actual: "
							+ cliente.getDireccionPostal().getCiudad() + " )");
					cliente.getDireccionPostal().setCiudad(scanner.next());
					System.out.println("Introduzca el PAÍS (actual: "
							+ cliente.getDireccionPostal().getPais() + " )");
					cliente.getDireccionPostal().setPais(scanner.next());

					System.out.println("3. EMAIL");
					System.out.println("Introduzca el email (actual: "
							+ cliente.getEmail() + " )");
					cliente.setEmail(scanner.next());

					System.out.println("4. DNI");
					System.out.println("Introduzca el DNI (actual: "
							+ cliente.getDni() + " )");
					cliente.setDni(scanner.next());

					System.out.println("5. TELÉFONOS");
					String telefonoDomicilio = "";
					String telefonoMovil = "";
					String telefonoTrabajo = "";
					if (cliente.getTelefono()[0] != null) {
						System.out.println("Introduzca el TELÉFONO del DOMICILIO (actual: " +
								cliente.getTelefono()[0] + ")");
						telefonoDomicilio = scanner.next();
					}
					if (cliente.getTelefono()[1] != null) {
						System.out.println("Introduzca el TELÉFONO MÓVIL (actual: " +
								cliente.getTelefono()[1] + ")");
						telefonoMovil = scanner.next();
					}
					if (cliente.getTelefono()[2] != null) {
						System.out.println("Introduzca el TELÉFONO del TRABAJO (actual: " +
								cliente.getTelefono()[2] + ")");
						telefonoTrabajo = scanner.next();
					}
					String[] telefono = new String[3];
					telefono[0] = telefonoDomicilio;
					telefono[1] = telefonoMovil;
					telefono[2] = telefonoTrabajo;
					cliente.setTelefono(telefono);

					System.out.println("6. EDAD");
					System.out.println("Introduzca la edad (actual: " + cliente.getEdad() + ")");
					cliente.setEdad(scanner.nextInt());

					System.out.println("7. CARNET DE SOCIO");
					System.out.println("Tiene carnet de socio (actualmente: " + cliente.getCarnetSocio() + ")");
					cliente.setCarnetSocio(scanner.nextBoolean());
					scanner.nextLine();

					clienteRepository.save(cliente);
					System.out.println("Cliente modificado correctamente");

				} else if (opcion == 6) {
					System.out.println("Ha seleccionado la opción 6 - BORRAR UN CLIENTE (utilizando el id)");

					System.out.println("Por favor, introduzca el id del cliente que desea eliminar: ");
					Long id = scanner.nextLong();
					Optional<Cliente> clienteOpt = clienteRepository.findById(id);
					if (clienteOpt.isEmpty()) {
						Cliente cliente = clienteOpt.get();
						System.out.println("No existe ningún cliente con ese id");
						continue;
					}
					Cliente cliente = clienteOpt.get();
					System.out.println("Esta acción eliminará el registro, ¿está seguro? (SÍ=true / NO=false)");
					String confirm = scanner.next();
					if (confirm.equalsIgnoreCase("si")) {
						clienteRepository.deleteById(id);
						System.out.println("Cliente borrado correctamente. Actualmente existen "
								+ clienteRepository.count() + " registros.");
					} else {
						continue;
					}

				} else if (opcion == 7) {
					System.out.println("Ha seleccionado la opción 7 - BORRAR TODOS LOS CLIENTES");
					System.out.println("¿SEGURO QUE DESEA ELIMINAR TODOS LOS REGISTROS? (SÍ / NO)");
					String respuesta = scanner.nextLine();
					if (respuesta.equalsIgnoreCase("si")) {
						clienteRepository.deleteAll();
						System.out.println("Clientes borrados correctamente. Actualmente existen "
								+ clienteRepository.count() + " registros.");
					} else {
						System.out.println("¡MENOS MAL QUE NO HAS ELIMINADO TODOS LOS REGISTROS!");
					}

				} else if (opcion == 8) {
					System.out.println("Ha seleccionado la opción 8 - CONSULTAR UN CLIENTE UTILIZANDO " +
							"EL NOMBRE COMPLETO");
					System.out.println("Por favor, introduzca el NOMBRE y los APELLIDOS del cliente que desea " +
							"consultar");
					String nombreCompleto = scanner.nextLine();
					clientes =  clienteRepository.findByNombreCompleto(nombreCompleto);
					if (clientes.isEmpty()) {
						System.out.println("No existe ningún cliente con esos datos.");
					} else {
						System.out.println("Consultando en base de datos...");
						for (Cliente cliente : clientes) {
							System.out.println(cliente);
						}
					}

				} else if (opcion == 9) {
					System.out.println("Ha seleccionado la opción 9 - CONSULTAR UN CLIENTE UTILIZANDO " +
							"EL DNI");
					System.out.println("Por favor, introduzca el DNI de los clientes que desea consultar");
					String dni = scanner.nextLine();
					clientes = clienteRepository.findByDni(dni);
					if (clientes.isEmpty()) {
						System.out.println("No existe ningún cliente con ese DNI");
					} else {
						System.out.println("Consultando en base de datos...");
						for (Cliente cliente : clientes) {
							System.out.println(cliente);
						}
					}

				} else if (opcion == 10) {
					System.out.println("Ha seleccionado la opción 10 - CONSULTAR TODOS LOS CLIENTES UTILIZANDO " +
							"EL CÓDIGO POSTAL");
					System.out.println("Por favor, introduzca el CÓDIGO POSTAL de los clientes que desea consultar");
					String codigoPostal = scanner.nextLine();
					List<Direccion> direccionPostal = direccionRepository.findByCodigoPostal(codigoPostal);
					if (direccionPostal.isEmpty()) {
						System.out.println("No existe ningún cliente con ese código postal");
					} else {
						System.out.println("Consultando en base de datos...");
						for (Direccion direccion : direccionPostal) {
							System.out.println(clienteRepository.findByDireccionPostal(direccion));
						}
					}
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		scanner.close();
	}
}


