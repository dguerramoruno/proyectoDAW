package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Shipment> findAll(Category[] category) {
		Specification<Shipment> spec = Specification.where(new ShipmentWhitCategory(category));
		return shipmentRepository.findAll(spec);
	}

	@Override
	public Shipment getById(Long id) {

		return shipmentRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@Override
	public Shipment save(@NotNull @Valid Shipment shipment) {
		return shipmentRepository.saveAndFlush(shipment);
	}

	@Override
	public Shipment update(@NotNull @Valid Shipment shipment) {
		return shipmentRepository.saveAndFlush(shipment);
	}

	@Override
	public void deleteById(@NotBlank Long id) {
		shipmentRepository.deleteById(id);
	}

}
