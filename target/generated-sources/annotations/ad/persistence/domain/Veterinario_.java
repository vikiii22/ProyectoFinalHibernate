package ad.persistence.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Veterinario.class)
public abstract class Veterinario_ {

	public static volatile SingularAttribute<Veterinario, Clinica_Veterinaria> clinica_veterinaria;
	public static volatile SingularAttribute<Veterinario, String> Especialidad;
	public static volatile SingularAttribute<Veterinario, Integer> idVeterinario;
	public static volatile SingularAttribute<Veterinario, String> NombreVeterinario;

	public static final String CLINICA_VETERINARIA = "clinica_veterinaria";
	public static final String ESPECIALIDAD = "Especialidad";
	public static final String ID_VETERINARIO = "idVeterinario";
	public static final String NOMBRE_VETERINARIO = "NombreVeterinario";

}

