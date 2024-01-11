/**
 *
 */
package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/* JPA */
@Table(name="offices")
@Entity
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_NAME = 100;

	//JPA//
	@Id
	@Column(unique = true,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/* Lombok */
	@EqualsAndHashCode.Include
	private Long id;
	
	@Size(max=MAX_NAME,message="Tiene que tener maximo "+MAX_NAME+" caracteres")
	private String name;

}
