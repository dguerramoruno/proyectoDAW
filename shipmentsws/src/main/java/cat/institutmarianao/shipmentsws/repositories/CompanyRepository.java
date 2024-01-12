package cat.institutmarianao.shipmentsws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.institutmarianao.shipmentsws.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
