package utp.alumno.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	private int id;
	private String password;
	private String nameCompany;
	private EmailAddress emailAdress;
	private String description;
	private String address;
	private int phoneNumber;
	private int companyState;

	public String getIdAsString() {
		return String.valueOf(getId());
	}

	public String getPasswordAsValue() {
		return "'" + getPassword() + "'";
	}

	public String getNameCompanyAsValue() {
		return "'" + getNameCompany() + "'";
	}

	public String getDescriptionAsValue() {
		return "'" + getDescription() + "'";
	}

	public String getAddressAsValue() {
		return "'" + getAddress() + "'";
	}

	public String getPhoneNumberAsString() {
		return String.valueOf(getPhoneNumber());
	}

	public String getCompanyStateAsString() {
		return String.valueOf(getCompanyState());
	}

	/*
	 * public static Company build(ResultSet rs, EmailAddressesEntity
	 * emailAddressEntity) { try { return (new Company()) .setId(rs.getInt("id"))
	 * .setPassword(rs.getString("password"))
	 * .setNameCompany(rs.getString("name_company"))
	 * .setDescription(rs.getString("description"))
	 * .setCompanyState(rs.getInt("company_state"))
	 * .setEmailAdress(emailAddressEntity.findById( rs.getInt("id_email_address")))
	 * .setAddress(rs.getString("address"))
	 * .setPhoneNumber(rs.getInt("phone_number")); } catch (SQLException e) {
	 * e.printStackTrace(); } return null; }
	 */

}