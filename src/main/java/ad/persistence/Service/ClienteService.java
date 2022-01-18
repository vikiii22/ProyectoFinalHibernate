package ad.persistence.Service;

import ad.persistence.domain.Animal;
import ad.persistence.domain.Animal_;
import ad.persistence.domain.Cliente;
import ad.persistence.domain.Cliente_;
import ad.persistence.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
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

    public void verDatosCliente(int id){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            Root<Cliente> root = criteria.from(Cliente.class);
            criteria.select(root).where(builder.equal(root.get(Cliente_.ID_CLIENTE), id));
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
            CriteriaQuery<Cliente> criteria=builder.createQuery(Cliente.class);
            Root<Cliente> root=criteria.from(Cliente.class);
            criteria.where(builder.equal(root.get(Cliente_.ID_CLIENTE), id));
            List<Cliente> clientes=session.createQuery(criteria).getResultList();

            Cliente cliente=session.load(Cliente.class, id);

            for (Cliente c:clientes) {
                cliente.getAnimal().remove(c);
                session.save(cliente);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
