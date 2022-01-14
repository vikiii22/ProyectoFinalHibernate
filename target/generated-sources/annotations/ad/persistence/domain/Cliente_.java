package ad.persistence.domain;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Integer> idCliente;
	public static volatile SingularAttribute<Cliente, String> NombreCliente;
	public static volatile SingularAttribute<Cliente, Integer> TelefonoContacto;
	public static volatile SetAttribute<Cliente, Animal> animal;

	public static final String ID_CLIENTE = "idCliente";
	public static final String NOMBRE_CLIENTE = "NombreCliente";
	public static final String TELEFONO_CONTACTO = "TelefonoContacto";
	public static final String ANIMAL = "animal";

}

