package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import cat.institutmarianao.shipmentsws.validation.groups.OnUserCreate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

// JPA  //
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
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
	@Column(unique = true,nullable = false)
	//VALIDATIONS
	@Size(min = MIN_USERNAME,max = MAX_USERNAME)
	protected String username;
	
	//VALIDATIONS
	
	@Enumerated(EnumType.STRING)
	@Column(name="role",insertable=false, updatable=false, nullable=false)
	protected Role role;
	
	//VALIDATIONS
	@NotBlank(groups = OnUserCreate.class)
	@Size(min = MIN_PASSWORD)
	protected String password;

	//VALIDATIONS
	@NotBlank
	@Size(min=MIN_FULL_NAME,max=MAX_FULL_NAME)
	//JPA//
	@Column(name="full_name",nullable = false)	
	protected String fullName;
	
	//VALIDATIONS
	@Max(value = MAX_EXTENSION,message="Minimo 2 caracteres de extension")
	protected Integer extension;
}
