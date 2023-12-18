package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue(value = "")
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Delivery extends Action implements Serializable {

	private static final long serialVersionUID = 1L;
}
