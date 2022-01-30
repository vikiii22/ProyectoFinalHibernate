package ad.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCliente;
    String NombreCliente;
    int TelefonoContacto;
    @OneToMany(mappedBy = "cliente")
    Set<Animal> animal;

    public Cliente() {
    }

    public Cliente(String nombreCliente, int telefonoContacto) {
        NombreCliente = nombreCliente;
        TelefonoContacto = telefonoContacto;
    }

    public Cliente(String nombreCliente, int idCliente, int telefonoContacto) {
        this.NombreCliente=nombreCliente;
        this.idCliente=idCliente;
        this.TelefonoContacto=telefonoContacto;
    }

    public Set<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(Set<Animal> animal) {
        this.animal = animal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public int getTelefonoContacto() {
        return TelefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        TelefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Cliente " +
                "idCliente: " + idCliente +
                ", NombreCliente: " + NombreCliente +
                ", TelefonoContacto: " + TelefonoContacto;
    }
}
