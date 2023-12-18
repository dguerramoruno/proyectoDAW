package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.*;
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
	
	@Column(unique = false,nullable=false)
	private String name;
	
	@Column(unique = false,nullable=false)
	private String street;
	
	@Column(unique = false,nullable=false)
	private String number;
	
	@Column(unique = false,nullable=false)
	private String floor;
	
	@Column(unique = false,nullable=false)
	private String door;
	
	@Column(unique = false,nullable=false)
	private String city;
	
	@Column(unique = false,nullable=false)
	private String province;
	
	@Column(unique = false,nullable=true)
	private String postalCode;

	@Column(unique = false,nullable=false)
	private String country;
}
