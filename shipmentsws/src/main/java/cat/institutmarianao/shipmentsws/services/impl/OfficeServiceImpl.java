package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Office;
import cat.institutmarianao.shipmentsws.repositories.OfficeRepository;
import cat.institutmarianao.shipmentsws.services.OfficeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Service
public class OfficeServiceImpl implements OfficeService {
	@Autowired
	private OfficeRepository officeRepository;

	@Override
	public List<Office> findAll() {

		List<Office> offices = officeRepository.findAll();
		return offices;
	}

	@Override
	public Office getById(Long id) {
		Office officeId = officeRepository.findById(id).orElseThrow(NotFoundException::new);
		return officeId;
	}

	@Override
	public Office save(@NotNull @Valid Office office) {
		return officeRepository.save(office);
	}

	@Override
	public Office update(@NotNull @Valid Office office) {
		return officeRepository.save(office);
	}

	@Override
	public void deleteById(@NotBlank Long id) {
		officeRepository.deleteById(id);
	}

}
