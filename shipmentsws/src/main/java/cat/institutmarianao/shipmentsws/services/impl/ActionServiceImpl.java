package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.repositories.ActionRepository;
import cat.institutmarianao.shipmentsws.services.ActionService;
import jakarta.validation.constraints.NotBlank;

@Service
public class ActionServiceImpl implements ActionService {
	@Autowired
	private ActionRepository actionRepository;

	@Override
	public List<Action> findActionsByShipmentId(@NotBlank Long shipmentId) {

		return actionRepository.findActionsByShipmentIdOrderByDateDesc(shipmentId);
	}

}
