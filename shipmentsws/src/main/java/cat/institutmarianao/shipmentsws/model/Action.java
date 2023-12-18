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
@DiscriminatorColumn()
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
	
	@NotNull
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
	protected Long id;

	@NotNull
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)	
	protected Type type;

	@NotNull
	
	@ManyToOne
	@Column(name="performer_username",nullable = false)
	protected User performer;
	
	@NotNull
	
	@PastOrPresent
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	protected Date date = new Date();
	
	@NotNull
	
	@ManyToOne
	@Column(name="shimpent_id",nullable = false,insertable = false)
	protected Shipment shipment;
}
