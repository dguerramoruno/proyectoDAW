package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.model.Office;
import cat.institutmarianao.shipmentsws.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface ActionService {
	List<Action> findAll(Long id, String type);

	Action getById(@NotBlank Long id);

	Action save(@NotNull @Valid Action action);

	Action update(@NotNull @Valid Action action);

	void deleteById(@NotBlank Long id);
}
