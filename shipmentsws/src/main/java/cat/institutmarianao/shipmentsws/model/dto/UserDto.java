package cat.institutmarianao.shipmentsws.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import cat.institutmarianao.shipmentsws.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, 
include = JsonTypeInfo.As.EXISTING_PROPERTY, 
property = "role",visible = true)
@JsonSubTypes({ 
	  @Type(value = LogisticsManagerDto.class, name = User.LOGISTICS_MANAGER), 
	  @Type(value = CourierDto.class, name = User.COURIER),
	  @Type(value = ReceptionistDto.class, name = User.RECEPTIONIST)
	})

/* Swagger */
@Schema(oneOf = { ReceptionistDto.class, LogisticsManagerDto.class, CourierDto.class }, discriminatorProperty = "role")
/* Lombok */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Lombok */
	@EqualsAndHashCode.Include
	protected String username;

	protected User.Role role;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	protected String password;

	protected String fullName;

	protected Integer extension;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String location;

}
