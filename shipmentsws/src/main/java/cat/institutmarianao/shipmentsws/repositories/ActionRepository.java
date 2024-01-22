package cat.institutmarianao.shipmentsws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.institutmarianao.shipmentsws.model.Action;

public interface ActionRepository extends JpaRepository<Action, Long> {
	List<Action> findActionsByShipmentIdOrderByDateDesc(Long shipmentId);
}
