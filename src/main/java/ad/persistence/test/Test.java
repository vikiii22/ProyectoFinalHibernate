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

        Scanner sc=new Scanner(System.in);
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

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        session.close();
    }
}
