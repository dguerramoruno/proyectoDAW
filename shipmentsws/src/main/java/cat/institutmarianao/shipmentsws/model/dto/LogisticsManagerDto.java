package cat.institutmarianao.shipmentsws.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonTypeName;

import cat.institutmarianao.shipmentsws.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/* Lombok */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogisticsManagerDto extends ReceptionistDto implements Serializable {

	private static final long serialVersionUID = 1L;
}
