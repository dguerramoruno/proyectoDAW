package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue(User.LOGISTICS_MANAGER)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogisticsManager extends Receptionist implements Serializable {

	private static final long serialVersionUID = 1L;
}
