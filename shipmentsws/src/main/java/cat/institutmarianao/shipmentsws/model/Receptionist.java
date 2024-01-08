package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable; 

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Receptionist extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MAX_PLACE = 100;
	
	@ManyToOne
	private Office office;
	@NotNull
	@Size(max=MAX_PLACE,message="Maximo tiene que tener "+MAX_PLACE+" caracteres")
	private String place;

}
