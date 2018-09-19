package utp.alumno.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import utp.alumno.app.mapper.EmailAddressMapper;
import utp.alumno.app.model.EmailAddress;
import utp.alumno.app.service.EmailAddressService;

@Service("emailAddressService")
public class EmailAddressServiceImpl implements EmailAddressService{

	@Autowired
	@Qualifier("emailAddressMapper")
	private EmailAddressMapper emailAddressMapper;
	
	@Override
	public final List<EmailAddress> getEmailAddresses(int offset,int rows) {
		return emailAddressMapper.getEmailAddresses(offset, rows);
	}
	
	@Override
	public final int getEmailCount() {
		return emailAddressMapper.getEmailCount();
	}

	@Override
	public final EmailAddress getEmailAddressById(int id) {
		return emailAddressMapper.getEmailAddressById(id);
	}

	@Override
	public final int createEmail(EmailAddress emailAddress) {
		return emailAddressMapper.createEmail(emailAddress);
	}

	@Override
	public final int updateEmail(EmailAddress emailAddress) {
		return emailAddressMapper.updateEmail(emailAddress);
	}


}
