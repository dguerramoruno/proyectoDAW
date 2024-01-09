package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity

/* Lombok */
@Data
@Table(name="shipments")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shipment implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_DESCRIPTION = 500;

	public enum Category {
		PARTICULAR, COMPANY, GOVERNMENT
	}

	public static final String PENDING = "PENDING";
	public static final String IN_PROCESS = "IN_PROCESS";
	public static final String DELIVERED = "DELIVERED";

	public enum Status {
		PENDING, IN_PROCESS, DELIVERED
	}

	/* Lombok */
	@EqualsAndHashCode.Include
	//VALIDATIONS
	@NotNull
	//JPA
	@Id
	@Column(unique=true,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//JPA
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="sender_id",nullable = false)		
	private Address sender;
	
	@ManyToOne
	@JoinColumn(name="recipient_id",nullable = false)	
	private Address recipient;
	
	@Positive
	private Float weight;
	@Positive
	private Float height;
	@Positive
	private Float width;
	@Positive
	private Float length;

	private Boolean express;
	private Boolean fragile;
	@Size(max = 500, message = "La nota no puede tener mas de 500 caracteres")
	private String note;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shipment")
	private List<Action> tracking;

	/* Hibernate */
	@Formula("(SELECT CASE a.type WHEN '" + Action.RECEPTION + "' THEN '" + PENDING + "' " + " WHEN '"
			+ Action.ASSIGNMENT + "' THEN '" + IN_PROCESS + "' " + " WHEN '" + Action.DELIVERY + "' THEN '" + DELIVERED
			+ "' ELSE NULL END FROM actions a "
			+ " WHERE a.date=( SELECT MAX(last_action.date) FROM actions last_action "
			+ " WHERE last_action.shipment_id=a.shipment_id AND last_action.shipment_id=id ))")
	// Lombok
	@Setter(AccessLevel.NONE)
	//JPA
	@Enumerated(EnumType.STRING)
	private Status status;

}
