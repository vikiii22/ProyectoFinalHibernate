package ad.persistence.Service;

import ad.persistence.domain.Animal;
import ad.persistence.domain.Animal_;
import ad.persistence.domain.Cliente;
import ad.persistence.domain.Cliente_;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class ClienteService {
    public void insertarCliente(String nombre, int num){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            Cliente cliente=new Cliente(nombre, num);
            session.save(cliente);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verDatosCliente(String cliente){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            Root<Cliente> root = criteria.from(Cliente.class);
            criteria.select(root).where(builder.equal(root.get(Cliente_.NOMBRE_CLIENTE), cliente));
            List<Cliente> clientes = session.createQuery(criteria).getResultList();

            clientes.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
        session.getTransaction();
        session.close();
    }

    public void eliminarCliente(int id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder=session.getCriteriaBuilder();
            CriteriaDelete<Cliente> query=builder.createCriteriaDelete(Cliente.class);
            Root<Cliente>root=query.from(Cliente.class);
            query.where(builder.equal(root.get("idCliente"), id));

            session.createQuery(query).executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
