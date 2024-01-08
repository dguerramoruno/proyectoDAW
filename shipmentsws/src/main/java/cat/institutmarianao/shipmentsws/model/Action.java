package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable; 
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import nonapi.io.github.classgraph.json.Id;

//JPA
@Entity
@Table(name="actions")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Values for type - MUST be constants */
	public static final String RECEPTION = "RECEPTION";
	public static final String ASSIGNMENT = "ASSIGNMENT";
	public static final String DELIVERY = "DELIVERY";

	public enum Type {
		RECEPTION, ASSIGNMENT, DELIVERY
	}

	/* Lombok */
	@EqualsAndHashCode.Include
	
	//VALIDATIONS
	@NotNull
	//JPA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
	protected Long id;
	
	
	//VALIDATIONS
	@NotNull
	//JPA
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)	
	protected Type type;
	
	//VALIDATIONS
	@NotNull
	//JPA
	@ManyToOne
	@Column(name="performer_username",nullable = false)
	protected User performer;
	//VALIDATIONS
	@NotNull
	//JPA
	@PastOrPresent
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	protected Date date = new Date();
	//VALIDATIONS
	@NotNull
	//JPA
	@ManyToOne
	@Column(name="shimpent_id",nullable = false,insertable = false)
	protected Shipment shipment;
}
