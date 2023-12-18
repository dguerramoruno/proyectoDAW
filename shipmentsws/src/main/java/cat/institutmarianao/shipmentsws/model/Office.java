/**
 *
 */
package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_NAME = 100;

	//JPA//
	@Id
	/* Lombok */
	@EqualsAndHashCode.Include
	private Long id;

	private String name;

}
