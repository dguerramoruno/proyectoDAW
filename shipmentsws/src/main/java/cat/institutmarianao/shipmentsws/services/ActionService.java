package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Action;
import jakarta.validation.constraints.NotBlank;

public interface ActionService {

	List<Action> findActionsByShipmentId(@NotBlank Long id);

}
