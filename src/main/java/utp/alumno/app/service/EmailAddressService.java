package utp.alumno.app.service;

import java.util.List;

import utp.alumno.app.model.EmailAddress;

public interface EmailAddressService {
	
	public List<EmailAddress> getEmailAddresses(int offset,int rows);
	public int getEmailCount();
	public EmailAddress getEmailAddressById(int id);
	public int updateEmail(EmailAddress emailAddress);
	public int createEmail(EmailAddress emailAddress);

}
