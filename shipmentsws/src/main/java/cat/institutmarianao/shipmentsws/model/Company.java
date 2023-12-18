/**
 *
 */
package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="companies")
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_NAME = 100;

	/* Lombok */
	@EqualsAndHashCode.Include
	@Id
	@Column(unique = true,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = false,nullable=false)
	private String name;
}
