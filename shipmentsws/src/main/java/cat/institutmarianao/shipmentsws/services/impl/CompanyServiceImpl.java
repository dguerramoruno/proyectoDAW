package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.model.Company;
import cat.institutmarianao.shipmentsws.repositories.CompanyRepository;
import cat.institutmarianao.shipmentsws.services.CompanyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> findAll() {

		return companyRepository.findAll();
	}

	@Override
	public Company getById(@NotBlank Long id) {
		return companyRepository.getReferenceById(id);
	}

	@Override
	public Company save(@NotNull @Valid Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company update(@NotNull @Valid Company office) {
		return companyRepository.save(office);
	}

	@Override
	public void deleteById(@NotBlank Long id) {
		companyRepository.deleteById(id);
	}

}
