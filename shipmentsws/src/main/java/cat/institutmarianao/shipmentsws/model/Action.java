package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;  
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.EqualsAndHashCode;

//JPA
@Entity
@Table(name="actions")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
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
	@Column(insertable=false, updatable=false)
	@Enumerated(EnumType.STRING)
	protected Action.Type type;
	
	//VALIDATIONS
	@NotNull
	//JPA
	@ManyToOne
	@JoinColumn(name="performer_username",nullable = false)
	protected User performer;
	//VALIDATIONS
	@NotNull
	//JPA
	@PastOrPresent
	@Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date date = new Date();
	//VALIDATIONS
	@NotNull
	//JPA
	@ManyToOne
	@JoinColumn(name="shipment_id",nullable = false,insertable = false)
	protected Shipment shipment;
}
