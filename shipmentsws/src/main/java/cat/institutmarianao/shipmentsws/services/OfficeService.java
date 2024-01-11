package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Office;
import cat.institutmarianao.shipmentsws.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface OfficeService {
	List<Office> findAll(Long id, String fullName);

	Office getById(@NotBlank Long id);

	Office save(@NotNull @Valid Office office);

	Office update(@NotNull @Valid Office office);

	void deleteById(@NotBlank Long id);
}
