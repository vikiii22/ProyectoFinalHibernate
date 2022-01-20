package ad.persistence.Service;

import ad.persistence.domain.*;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class VeterinarioService {
    public void visualizarVeterinario(int idVeterinario){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Veterinario> criteria = builder.createQuery(Veterinario.class);
            Root<Veterinario> root = criteria.from(Veterinario.class);
            criteria.select(root).where(builder.equal(root.get(Veterinario_.ID_VETERINARIO), idVeterinario));
            List<Veterinario> veterinarios = session.createQuery(criteria).getResultList();

            veterinarios.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
        session.getTransaction();
        session.close();
    }

    public void altaNuevoVeterinario(String Nombre, String especialidad, int idClinica){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Veterinario veterinario=new Veterinario(Nombre, especialidad, idClinica);
            session.save(veterinario);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
