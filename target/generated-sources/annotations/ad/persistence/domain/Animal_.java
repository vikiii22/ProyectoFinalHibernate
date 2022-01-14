package ad.persistence.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, Cliente> cliente;
	public static volatile SingularAttribute<Animal, Integer> idAnimal;
	public static volatile SingularAttribute<Animal, Veterinario> veterinario;
	public static volatile SingularAttribute<Animal, String> Lesion;

	public static final String CLIENTE = "cliente";
	public static final String ID_ANIMAL = "idAnimal";
	public static final String VETERINARIO = "veterinario";
	public static final String LESION = "Lesion";

}

