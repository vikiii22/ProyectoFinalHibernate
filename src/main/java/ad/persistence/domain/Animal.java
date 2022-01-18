package ad.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAnimal;
    String Lesion;
    @ManyToOne
    @JoinColumn(name = "Cliente_idCliente")
    Cliente cliente;
    @OneToOne
    @JoinColumn(name = "Veterinario_idVeterinario")
    Veterinario veterinario;

    public Animal() {
    }

    public Animal(String lesion) {
        Lesion = lesion;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getLesion() {
        return Lesion;
    }

    public void setLesion(String lesion) {
        Lesion = lesion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Animal " +
                "idAnimal: " + idAnimal +
                ", Lesion: " + Lesion;
    }
}
