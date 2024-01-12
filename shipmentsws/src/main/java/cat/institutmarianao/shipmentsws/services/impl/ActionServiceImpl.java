package cat.institutmarianao.shipmentsws.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.institutmarianao.shipmentsws.model.Action;
import cat.institutmarianao.shipmentsws.repositories.ActionRepository;
import cat.institutmarianao.shipmentsws.services.ActionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Service
public class ActionServiceImpl implements ActionService {
	@Autowired
	private ActionRepository actionRepository;

	@Override
	public List<Action> findAll() {

		return actionRepository.findAll();
	}

	@Override
	public Action getById(@NotBlank Long id) {
		return actionRepository.getReferenceById(id);
	}

	@Override
	public Action save(@NotNull @Valid Action action) {
		return actionRepository.save(action);
	}

	@Override
	public Action update(@NotNull @Valid Action action) {
		return actionRepository.save(action);
	}

	@Override
	public void deleteById(@NotBlank Long id) {
		actionRepository.deleteById(id);
	}

}
