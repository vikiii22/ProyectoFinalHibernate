package ad.persistence.app;

import ad.persistence.Service.AnimalService;
import ad.persistence.Service.ClienteService;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ClienteService clienteService = new ClienteService();
        AnimalService animalService = new AnimalService();
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Que deseas hacer?\n" +
                    "1: Crear un nuevo cliente\n" +
                    "2: Mostrar todos los datos de tu Animal/es\n" +
                    "3: Mostrar todos tus datos\n" +
                    "4: Borrar tus datos\n" +
                    "5: Ingreso animal\n");

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
                    int idCliente= sc.nextInt();
                    System.out.print("Introduce el id del veterinario asignado: ");
                    int idVeterinario=sc.nextInt();
                    System.out.print("Introduce la causa: ");
                    sc.nextLine();
                    String lesion= sc.nextLine();
                    animalService.crearAnimal(lesion, idCliente, idVeterinario);
                }
                default -> System.out.println("Opción no válida");
            }
        }

        /*Scanner sc=new Scanner(System.in);
        System.out.print("Introduce un nombre: ");
        String nombre=sc.nextLine();
        System.out.print("Introduce un número de teléfono: ");
        int num=sc.nextInt();
        System.out.print("Introduce un nombre: ");
        sc.nextLine();
        String nombre2=sc.nextLine();
        System.out.print("Introduce un número de teléfono: ");
        int num2=sc.nextInt();

        try {
            Cliente cliente=new Cliente(nombre, num);
            Cliente cliente1=new Cliente(nombre2, num2);
            session.save(cliente);
            session.save(cliente1);

            Clinica_Veterinaria clinica_veterinaria = new Clinica_Veterinaria("C/La Avenida", "Clínica Sonrisas");
            session.save(clinica_veterinaria);

            Veterinario veterinario=new Veterinario("Ramón", "Huesos Rotos");
            veterinario.setClinica_veterinaria(clinica_veterinaria);
            session.save(veterinario);

            Animal animal=new Animal("Rotura Hueso");
            Animal animal1=new Animal("Dentadura torcida");
            Animal animal2=new Animal("Infección Renal");
            animal.setCliente(cliente);
            animal1.setCliente(cliente);
            animal2.setCliente(cliente1);
            animal.setVeterinario(veterinario);
            animal1.setVeterinario(veterinario);
            animal2.setVeterinario(veterinario);
            session.save(animal);
            session.save(animal1);
            session.save(animal2);


        }catch (Exception e){
            e.printStackTrace();
        }*/


        //session.getTransaction();
        //session.close();
    }
}
