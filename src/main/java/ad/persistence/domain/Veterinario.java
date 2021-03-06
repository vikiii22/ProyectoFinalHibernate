package ad.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "Veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVeterinario;
    String NombreVeterinario;
    String Especialidad;
    @ManyToOne
    @JoinColumn(name = "Clinica_Veterinaria_idClinica_Veterinaria")
    Clinica_Veterinaria clinica_veterinaria;

    public Veterinario() {
    }

    public Veterinario(String nombreVeterinario, String especialidad) {
        NombreVeterinario = nombreVeterinario;
        Especialidad = especialidad;
    }

    public Veterinario(String nombreVeterinario, String especialidad, int idClinica_veterinaria) {
        clinica_veterinaria=new Clinica_Veterinaria();
        NombreVeterinario = nombreVeterinario;
        Especialidad = especialidad;
        clinica_veterinaria.setIdClinica_Veterinaria(idClinica_veterinaria);
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombreVeterinario() {
        return NombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        NombreVeterinario = nombreVeterinario;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public Clinica_Veterinaria getClinica_veterinaria() {
        return clinica_veterinaria;
    }

    public void setClinica_veterinaria(Clinica_Veterinaria clinica_veterinaria) {
        this.clinica_veterinaria = clinica_veterinaria;
    }

    @Override
    public String toString() {
        return "Nombre del veterinario: " + NombreVeterinario + ", Especialidad: " + Especialidad
                +", Trabaja en: " + clinica_veterinaria.getNombreClinica();
    }
}
