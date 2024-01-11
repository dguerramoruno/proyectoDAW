package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cat.institutmarianao.shipmentsws.model.Office;
import cat.institutmarianao.shipmentsws.repositories.CompanyRepository;
import cat.institutmarianao.shipmentsws.services.CompanyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Office> findAll(Long id, String fullName) {

		return companyRepository.findAll();
	}

	@Override
	public Office getById(@NotBlank Long id) {
		return companyRepository.getReferenceById(id);
	}

	@Override
	public Office save(@NotNull @Valid Office office) {
		return companyRepository.save(office);
	}

	@Override
	public Office update(@NotNull @Valid Office office) {
		return companyRepository.save(office);
	}

	@Override
	public void deleteById(@NotBlank Long id) {
		companyRepository.deleteById(id);
	}

}
