package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@Table(name="users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

// JPA  //
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role")
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
	//VALIDATIONS
	@Size(min = MIN_USERNAME,max = MAX_USERNAME)
	protected String username;
	
	//VALIDATIONS
	
	@Enumerated(EnumType.STRING)
	@Column(insertable=false, updatable=false)
	protected Role role;
	
	//VALIDATIONS
	@NotBlank
	@Size(min = MIN_PASSWORD)
	@JsonIgnore
	protected String password;

	//VALIDATIONS
	@NotBlank
	@Size(min=MIN_FULL_NAME,max=MAX_FULL_NAME)
	//JPA//
	@Column(name="full_name",nullable = false)	
	protected String fullName;
	
	//VALIDATIONS
	@NotBlank
	@Size(max=MAX_EXTENSION,message="Minimo 2 caracteres de extension")
	protected Integer extension;
}
