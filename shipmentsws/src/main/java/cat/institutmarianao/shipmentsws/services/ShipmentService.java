package cat.institutmarianao.shipmentsws.services;

import java.util.List;

import cat.institutmarianao.shipmentsws.model.Shipment;
import cat.institutmarianao.shipmentsws.model.Shipment.Category;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface ShipmentService {
	List<Shipment> findAll(Category[] Category);

	Shipment getById(Long id);

	Shipment save(@NotNull @Valid Shipment office);

	Shipment update(@NotNull @Valid Shipment office);

	void deleteById(@NotBlank Long id);

}
