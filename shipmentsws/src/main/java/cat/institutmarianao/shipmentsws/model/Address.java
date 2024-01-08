package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable; 

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="address")
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Lombok */
	@EqualsAndHashCode.Include
	
	@Id
	@Column(unique = true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@NotBlank
	@Column(unique = false,nullable=false)
	private String name;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String street;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String number;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String floor;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String door;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String city;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String province;
	@NotBlank
	@Column(unique = false,nullable=true)
	private String postalCode;
	@NotBlank
	@Column(unique = false,nullable=false)
	private String country;
}
