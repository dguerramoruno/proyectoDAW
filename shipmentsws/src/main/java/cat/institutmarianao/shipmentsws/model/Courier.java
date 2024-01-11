package cat.institutmarianao.shipmentsws.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@DiscriminatorValue(User.COURIER)
/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class Courier extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="company_id",nullable = false)
	private Company company;
}
