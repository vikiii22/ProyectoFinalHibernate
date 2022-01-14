package ad.persistence.test;

import ad.persistence.domain.Animal;
import ad.persistence.domain.Cliente;
import ad.persistence.domain.Clinica_Veterinaria;
import ad.persistence.domain.Veterinario;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        /*Scanner sc=new Scanner(System.in);
        System.out.print("Introduce un nombre: ");
        String nombre=sc.nextLine();
        Cliente cliente=new Cliente();
        cliente.setNombreCliente(nombre);
        System.out.print("Introduce un número de teléfono: ");
        int num=sc.nextInt();
        cliente.setTelefonoContacto(num);
        System.out.println("Usuario creado");

        session.save(cliente);*/

        try {
            Cliente cliente=new Cliente("Julio", 787945412);
            Cliente cliente1=new Cliente("Jose", 727701591);
            session.save(cliente);
            session.save(cliente1);

            Clinica_Veterinaria clinica_veterinaria=new Clinica_Veterinaria("C/La calle");
            session.save(clinica_veterinaria);

            Veterinario veterinario=new Veterinario("Ramón", "Huesos rotos");
            veterinario.setClinica_veterinaria(clinica_veterinaria);
            session.save(veterinario);

            Animal animal=new Animal("Infección dental");
            Animal animal1=new Animal("Rotura");
            Animal animal2=new Animal("Limar uñas");
            animal.setCliente(cliente);
            animal1.setCliente(cliente);
            animal2.setCliente(cliente1);
            animal.setVeterinario(veterinario);
            animal1.setVeterinario(veterinario);
            animal2.setVeterinario(veterinario);
            session.save(animal);
            session.save(animal1);
            session.save(animal2);

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        session.close();
    }
}
