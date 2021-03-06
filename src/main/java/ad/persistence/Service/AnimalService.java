package ad.persistence.Service;

import ad.persistence.domain.Animal;
import ad.persistence.domain.Animal_;
import ad.persistence.domain.Veterinario;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnimalService {
    public void mostrarAnimal(int idCliente){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
            Root<Animal> root = criteria.from(Animal.class);
            criteria.select(root).where(builder.equal(root.get(Animal_.CLIENTE), idCliente));
            List<Animal> animales = session.createQuery(criteria).getResultList();

            animales.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
        session.getTransaction();
        session.close();
    }

    public void crearAnimal(String lesion, int idCliente, int idVeterinario){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Animal animal=new Animal(lesion, idCliente, idVeterinario);
            session.save(animal);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void modificarVeterinario(int idVeterinario, int idAnimal){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder=session.getCriteriaBuilder();
            CriteriaUpdate<Animal> actualiza=builder.createCriteriaUpdate(Animal.class);
            Root<Animal> animal=actualiza.from(Animal.class);
            actualiza.where(builder.equal(animal.get("idAnimal"), idAnimal)).set(animal.get("veterinario"), idVeterinario);

            session.createQuery(actualiza).executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
