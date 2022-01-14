package ad.persistence.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Clinica_Veterinaria.class)
public abstract class Clinica_Veterinaria_ {

	public static volatile SingularAttribute<Clinica_Veterinaria, Integer> idClinica_Veterinaria;
	public static volatile SingularAttribute<Clinica_Veterinaria, String> NombreClinica;
	public static volatile SingularAttribute<Clinica_Veterinaria, String> Direccion;
	public static volatile SetAttribute<Clinica_Veterinaria, Veterinario> Veterinario;

	public static final String ID_CLINICA__VETERINARIA = "idClinica_Veterinaria";
	public static final String NOMBRE_CLINICA = "NombreClinica";
	public static final String DIRECCION = "Direccion";
	public static final String VETERINARIO = "Veterinario";

}

