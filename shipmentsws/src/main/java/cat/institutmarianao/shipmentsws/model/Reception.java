package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import cat.institutmarianao.shipmentsws.model.Action.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue(Action.RECEPTION)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Reception extends Action implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="tracking_number")
	private Integer trackingNumber;
}
