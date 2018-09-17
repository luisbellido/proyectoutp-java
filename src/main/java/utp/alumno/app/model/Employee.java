package utp.alumno.app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private int id;
	private int id2;
	private String password;
	private String name;
	private String firstLastName;
	private String SecondLastName;
	private int phoneNumber;
	private int cellPhoneNumber;
	private int dni;
	private String address;
	private String department;
	private Date birthdate;
	private Company company;
	private int employeeType;
	private EmailAddress emailAddress;
	private Area area;

	public String getId2AsString() {
		return String.valueOf(getId2());
	}

	public String getIdAsString() {
		return String.valueOf(getId());
	}

	public String getPasswordAsValue() {
		return "'" + getPassword() + "'";
	}

	public String getNameAsValue() {
		return "'" + getName() + "'";
	}

	public String getFirstLastNameAsValue() {
		return "'" + getFirstLastName() + "'";
	}

	public String getSecondLastNameAsValue() {
		return "'" + getSecondLastName() + "'";
	}

	public String getPhoneNumberAsString() {
		return String.valueOf(getPhoneNumber());
	}

	public String getCellPhoneNumberAsString() {
		return String.valueOf(getCellPhoneNumber());
	}

	public String getAddressAsValue() {
		return "'" + getAddress() + "'";
	}

	public String getEmployeeTypeAsString() {
		return String.valueOf(getEmployeeType());
	}

	public String getDniAsString() {
		return String.valueOf(getDni());
	}

	public String getDepartmentAsValue() {
		return "'" + getDepartment() + "'";
	}

	public String getBirthdateAsValue() {
		return "'" + String.valueOf(getBirthdate()) + "'";
	}
	

	/*public static Employee build(ResultSet rs, CompaniesEntity companiesEntity,
			EmailAddressesEntity emailAddressesEntity, AreasEntity areasEntity) {
		try {
			return (new Employee()).setId(rs.getInt("id"))
					.setCompany(companiesEntity.findById(rs.getInt("id_company"), emailAddressesEntity))
					.setEmailAddress(emailAddressesEntity.findById(rs.getInt("id_email_address")))
					.setArea(areasEntity.findById(rs.getInt("id_areas"))).setEmployeeType(rs.getInt("employee_type"))
					.setPassword(rs.getString("password")).setName(rs.getString("employee_name"))
					.setFirstLastName(rs.getString("employee_first_last_name"))
					.setSecondLastName(rs.getString("employee_second_last_name")).setDni(rs.getInt("dni"))
					.setPhoneNumber(rs.getInt("phone_number")).setCellPhoneNumber(rs.getInt("cell_phone_number"))
					.setAddress(rs.getString("address")).setDepartment(rs.getString("department"))
					.setBirthdate(rs.getDate("birthdate"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

}
