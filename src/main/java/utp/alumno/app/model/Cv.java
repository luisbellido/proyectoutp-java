package utp.alumno.app.model;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cv {
	
	private int id;
	private Employee employee;
	private int cvType;
	private String description;
	private int year;
	private int month;
	private int day;
	private Timestamp date_cv;


	public String getIdAsString() {
		return String.valueOf(getId());
	}

	public String getDescriptionAsValue() {
		return "'" + getDescription() + "'";
	}

	public String getcvTypeAsString() {
		return String.valueOf(getCvType());
	}
	
	/*public static Cv build(ResultSet rs, EmployeesEntity employeesEntity, CompaniesEntity companiesEntity,
			EmailAddressesEntity emailAddressesEntity, AreasEntity areasEntity) {
		try {
			return (new Cv()).setId(rs.getInt("id"))
					.setEmployee(employeesEntity.findById(rs.getInt("id_employee"), companiesEntity,
							emailAddressesEntity, areasEntity))
					.setCvType(rs.getInt("cv_type")).setDescription(rs.getString("description"))
					.setDate_cv(rs.getTimestamp("date_cv"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	

	/*public static Cv buildFecha(ResultSet rs, EmployeesEntity employeesEntity, CompaniesEntity companiesEntity,
			EmailAddressesEntity emailAddressesEntity, AreasEntity areasEntity) {
		try {
			return (new Cv()).setId(rs.getInt("id")).setYear(rs.getInt("from_unixtime( UNIX_TIMESTAMP(date_cv),'%Y')"))
					.setMonth(rs.getInt("from_unixtime( UNIX_TIMESTAMP(date_cv),'%m')"))
					.setDay(rs.getInt("from_unixtime( UNIX_TIMESTAMP(date_cv),'%d')"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	



}
