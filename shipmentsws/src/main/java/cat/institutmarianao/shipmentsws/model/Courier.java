package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@DiscriminatorValue(value = "courier")
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Courier extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Company company;
}
