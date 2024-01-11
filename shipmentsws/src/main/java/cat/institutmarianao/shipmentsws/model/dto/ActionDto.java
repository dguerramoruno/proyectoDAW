package cat.institutmarianao.shipmentsws.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import cat.institutmarianao.shipmentsws.ShipmentswsApplication;
import cat.institutmarianao.shipmentsws.model.Action;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


//JSON FORMAT
@JsonTypeInfo(use=Id.NAME, include=As.EXISTING_PROPERTY, property="type")
@JsonSubTypes({
	@Type(value = DeliveryDto.class, name=Action.DELIVERY), 
	@Type(value = ReceptionDto.class, name=Action.RECEPTION),
	@Type(value = AssignmentDto.class, name=Action.ASSIGNMENT)
	}) 
/* Swagger */
@Schema(oneOf = { ReceptionDto.class, AssignmentDto.class, DeliveryDto.class }, discriminatorProperty = "type")
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class ActionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Lombok */
	@EqualsAndHashCode.Include
	protected Long id;

	protected Action.Type type;

	protected String performer;

	/* Swagger */
	@Schema(pattern = ShipmentswsApplication.DATE_PATTERN)
	/* JSON */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date date = new Date();

	protected Long shipmentId;
}
