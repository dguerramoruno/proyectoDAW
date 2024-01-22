package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cat.institutmarianao.shipmentsws.exception.NotFoundException;
import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.dto.ShipmentDto;
import cat.institutmarianao.shipmentsws.repositories.ShipmentRepository;
import cat.institutmarianao.shipmentsws.services.ShipmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Shipment> findAll() {
		return shipmentRepository.findAll();
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

	@Override
	public void deleteShipmentById(Long id) {
		shipmentRepository.deleteById(id);
	}

	@Override
	public List<ShipmentDto> getAllShipments() {
		shipmentRepository.findAll();
		return null;
	}

	@Override
	public Shipment findShipmentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipment saveShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipmentDto> findDtoAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipment> findShipmnetsInProcess() {
		// TODO Auto-generated method stub
		return null;
	}

}
