package ad.persistence.app;

import ad.persistence.Service.AnimalService;
import ad.persistence.Service.ClienteService;
import ad.persistence.Service.ClinicaVeterinariaService;
import ad.persistence.Service.VeterinarioService;
import ad.persistence.domain.Veterinario;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        AnimalService animalService = new AnimalService();
        VeterinarioService veterinarioService = new VeterinarioService();
        ClinicaVeterinariaService clinicaVeterinariaService=new ClinicaVeterinariaService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Que deseas hacer?\n" +
                    "1: Crear un nuevo cliente\n" +
                    "2: Mostrar todos los datos de tu/s Animal/es\n" +
                    "3: Mostrar todos tus datos\n" +
                    "4: Borrar tus datos\n" +
                    "5: Ingreso animal\n" +
                    "6: Ver datos veterinario\n" +
                    "7: Registrar nuevo veterinario\n" +
                    "8: Modificar veterinario que atiende\n" +
                    "9: Crear nueva clínica veterinaria\n" +
                    "10: Ver clínicas disponibles\n" +
                    "11: Exportar datos de cliente a xml\n" +
                    "12: Saluda a Daniel\n");


            int eleccion = sc.nextInt();

            switch (eleccion) {
                case 1 -> {
                    System.out.print("Introduce tu nombre: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    System.out.print("Introduce tu número de teléfono: ");
                    int num = sc.nextInt();
                    clienteService.insertarCliente(nombre, num);
                }
                case 2 -> {
                    System.out.print("Introduce tu id: ");
                    int idCliente = sc.nextInt();
                    animalService.mostrarAnimal(idCliente);
                }
                case 3 -> {
                    System.out.print("Introduce tu nombre: ");
                    sc.nextLine();
                    String cliente = sc.nextLine();
                    clienteService.verDatosCliente(cliente);
                }
                case 4 -> {
                    System.out.print("Introduce tu id: ");
                    int idClie = sc.nextInt();
                    clienteService.eliminarCliente(idClie);
                }
                case 5 -> {
                    System.out.print("Introduce tu id: ");
                    int idCliente = sc.nextInt();
                    System.out.print("Introduce el id del veterinario asignado: ");
                    int idVeterinario = sc.nextInt();
                    System.out.print("Introduce la causa: ");
                    sc.nextLine();
                    String lesion = sc.nextLine();
                    animalService.crearAnimal(lesion, idCliente, idVeterinario);
                }
                case 6 -> {
                    System.out.print("Introduce id del veterinario: ");
                    int idVeterinario = sc.nextInt();
                    veterinarioService.visualizarVeterinario(idVeterinario);
                }
                case 7 -> {
                    System.out.print("Introduce el nombre del nuevo veterinario: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    System.out.print("Introduce su especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Introduce el id de la clínica en la que trabaja: ");
                    int clinica = sc.nextInt();
                    veterinarioService.altaNuevoVeterinario(nombre, especialidad, clinica);
                }
                case 8 -> {
                    System.out.print("Introduce el nuevo veterinario: ");
                    int nuevo = sc.nextInt();
                    System.out.print("Introduce id del animal que modifica: ");
                    int animal= sc.nextInt();
                    animalService.modificarVeterinario(nuevo, animal);
                }
                case 9 -> {
                    System.out.print("Introduce la dirección: ");
                    sc.nextLine();
                    String direccion=sc.nextLine();
                    System.out.print("Introduce nombre de la clínica: ");
                    String nombre=sc.nextLine();
                    clinicaVeterinariaService.crearNuevaClinica(direccion, nombre);
                }
                case 10 -> {
                    clinicaVeterinariaService.mostrarClinicasDisponibles();
                }
                case 11 -> {
                    clienteService.exportarDatos();
                }
                case 12 -> {
                    System.out.print("Introduce mi nota del trabajo: ");
                    int nota=sc.nextInt();
                    if (nota >=1 && nota <=5){
                        System.out.println("Hola, sin más.");
                    }else if (nota >= 5 && nota <=8){
                        System.out.println("Buenas tardes Daniel, que tenga un buen día.");
                    }else if (nota <=12){
                        System.out.println("Buenísimas tardes, sr Daniel, espero que pase una plácida tarde y todo sea de su agrado, posdata, eres un crack.");
                    }else {
                        System.out.println("Sin nota, día triste chicos :(");
                    }

                    try {
                        BufferedWriter bw=new BufferedWriter(new FileWriter("notaFinal.txt"));
                        bw.write("Nota final: " + nota);
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                default -> System.out.println("Opción no válida");
            }
        }
    }
}
