package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Company;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface CompanyService {
	List<Company> findAll();

	Company getById(@NotBlank Long id);

	Company save(@NotNull @Valid Company office);

	Company update(@NotNull @Valid Company office);

	void deleteById(@NotBlank Long id);
}