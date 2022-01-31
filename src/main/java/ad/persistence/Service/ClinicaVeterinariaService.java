package ad.persistence.Service;

import ad.persistence.domain.Cliente;
import ad.persistence.domain.Cliente_;
import ad.persistence.domain.Clinica_Veterinaria;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClinicaVeterinariaService {
    public void crearNuevaClinica(String direccion, String nombreClinica){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Clinica_Veterinaria clinica=new Clinica_Veterinaria(direccion, nombreClinica);
            session.save(clinica);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarClinicasDisponibles(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Clinica_Veterinaria> criteria = builder.createQuery(Clinica_Veterinaria.class);
            Root<Clinica_Veterinaria> root = criteria.from(Clinica_Veterinaria.class);
            criteria.select(root);
            List<Clinica_Veterinaria> clinicas = session.createQuery(criteria).getResultList();

            clinicas.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
