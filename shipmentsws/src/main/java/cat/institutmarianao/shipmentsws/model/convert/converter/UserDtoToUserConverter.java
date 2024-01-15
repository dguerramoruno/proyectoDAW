package cat.institutmarianao.shipmentsws.model.convert.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cat.institutmarianao.shipmentsws.model.Company;
import cat.institutmarianao.shipmentsws.model.Courier;
import cat.institutmarianao.shipmentsws.model.LogisticsManager;
import cat.institutmarianao.shipmentsws.model.Office;
import cat.institutmarianao.shipmentsws.model.Receptionist;
import cat.institutmarianao.shipmentsws.model.User;
import cat.institutmarianao.shipmentsws.model.dto.CourierDto;
import cat.institutmarianao.shipmentsws.model.dto.LogisticsManagerDto;
import cat.institutmarianao.shipmentsws.model.dto.ReceptionistDto;
import cat.institutmarianao.shipmentsws.model.dto.UserDto;
import cat.institutmarianao.shipmentsws.services.CompanyService;
import cat.institutmarianao.shipmentsws.services.OfficeService;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
	@Autowired
	private OfficeService officeService;
	@Autowired
	private CompanyService companyService;

	@Override
	public User convert(UserDto userDto) {
		if (userDto instanceof LogisticsManagerDto logisticsManagerDto) {
			// Includes Supervisor
			LogisticsManager logisticsManager = new LogisticsManager();
			copyCommonProperties(logisticsManagerDto, logisticsManager);

			// Copy office
			Long officeId = logisticsManagerDto.getOfficeId();

			Office office = officeService.getById(officeId);
			logisticsManager.setOffice(office);

			logisticsManager.setPlace(logisticsManagerDto.getPlace());

			return logisticsManager;
		}
		if (userDto instanceof ReceptionistDto receptionistDto) {
			Receptionist receptionist = new Receptionist();
			copyCommonProperties(receptionistDto, receptionist);

			// Copy office

			Long officeId = receptionistDto.getOfficeId();
			Office office = officeService.getById(officeId);
			receptionist.setOffice(office);
			receptionist.setPlace(receptionistDto.getPlace());
			return receptionist;
		}
		if (userDto instanceof CourierDto courierDto) {
			// Includes Supervisor
			Courier courier = new Courier();
			copyCommonProperties(courierDto, courier);

			// Copy company
			Long companyID = courierDto.getCompanyId();
			Company company = companyService.getById(companyID);
			courier.setCompany(company);
			return courier;
		}
		return null;
	}

	private void copyCommonProperties(UserDto userDto, User user) {
		BeanUtils.copyProperties(userDto, user);
	}
}
