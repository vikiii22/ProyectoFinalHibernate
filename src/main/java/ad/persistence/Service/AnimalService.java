package ad.persistence.Service;

import ad.persistence.domain.Animal;
import ad.persistence.domain.Animal_;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnimalService {
    public void mostrarAnimal(int idCliente){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Animal> criteria=builder.createQuery(Animal.class);
        Root<Animal> root=criteria.from(Animal.class);
        criteria.select(root).where(builder.equal(root.get(Animal_.CLIENTE), idCliente));
        List<Animal> animales=session.createQuery(criteria).getResultList();

        animales.forEach(System.out::println);

        session.getTransaction();
        session.close();
    }
}
