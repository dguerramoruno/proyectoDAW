package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

// JPA  //
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn()
public abstract class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Values for role - MUST be constants (can not be enums) */
	public static final String RECEPTIONIST = "RECEPTIONIST";
	public static final String LOGISTICS_MANAGER = "LOGISTICS_MANAGER";
	public static final String COURIER = "COURIER";

	public enum Role {
		RECEPTIONIST, LOGISTICS_MANAGER, COURIER
	}

	public static final int MIN_USERNAME = 2;
	public static final int MAX_USERNAME = 25;
	public static final int MIN_PASSWORD = 10;
	public static final int MIN_FULL_NAME = 3;
	public static final int MAX_FULL_NAME = 100;
	public static final int MAX_EXTENSION = 9999;

	/* Lombok */
	@EqualsAndHashCode.Include
	//JPA//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,nullable = false)
	protected String username;
	
	//VALIDATIONS
	
	@Enumerated(EnumType.STRING)
	@Column(unique = true,nullable = false)
	protected Role role;
	
	//VALIDATIONS
	@NotBlank
	protected String password;

	//VALIDATIONS
	@NotBlank
	//JPA//
	@Column(name="full_name",nullable = false)	
	protected String fullName;
	
	//VALIDATIONS
	@NotBlank
	//JPA//
	
	protected Integer extension;
}
