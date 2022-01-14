package ad.persistence.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clinica_Veterinaria")
public class Clinica_Veterinaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idClinica_Veterinaria;
    String Direccion;
    @OneToMany(mappedBy = "clinica_veterinaria")
    Set<Veterinario> Veterinario;

    public Clinica_Veterinaria() {
    }

    public Clinica_Veterinaria(String direccion) {
        Direccion = direccion;
    }

    public int getIdClinica_Veterinaria() {
        return idClinica_Veterinaria;
    }

    public void setIdClinica_Veterinaria(int idClinica_Veterinaria) {
        this.idClinica_Veterinaria = idClinica_Veterinaria;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Set<ad.persistence.domain.Veterinario> getVeterinario() {
        return Veterinario;
    }

    public void setVeterinario(Set<ad.persistence.domain.Veterinario> veterinario) {
        Veterinario = veterinario;
    }
}
