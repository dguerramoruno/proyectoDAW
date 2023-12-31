package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable; 

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue(Action.ASSIGNMENT)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Assignment extends Action implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MIN_PRIORITAT = 1;
	public static final int MAX_PRIORITAT = 3;
	@ManyToOne
	private Courier courier;
    
	@Column(nullable = false)
	@Size(min=MIN_PRIORITAT,max=MAX_PRIORITAT)
	private Integer priority;

}
