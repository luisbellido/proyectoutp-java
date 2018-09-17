package utp.alumno.app.model;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {
	
	private int id;
	private Employee idEvaluator;
	private Employee idUserEmployee;
	private Company company;
	private Area area;

	private float grade;
	private float grade1;
	private float grade2;

	private String comment;

	private Timestamp date;

	private float avg_grade;

	private float competitive;
	private float commitment_company;
	private float teamwork;
	private float proactive;
	private float work_under_pressure;
	private float objective;
	private float analytical;
	private float decision_making;
	private float leadership;
	private float responsibility;
	private float punctuality;
	private float honesty;
	private float respect;
	private float organized;
	private float language_skills;
	private float computer_skills;
	private float give_successful_solutions;
	private float communication_skills;
	private float business_skills;
	private float business_knowledge;
	private float resource_optimization;
	private float market_knowledge;
	private float performance;
	private float efficiency;
	private float productivity;
	private float innovative;
	private int year;
	private int month;
	private int day;



	public String getIdAsString() {
		return String.valueOf(getId());
	}

	public String getDateAsValue() {

		return "'" + String.valueOf(getDate()) + "'";
	}

	public String getGrade1AsString() {
		return String.valueOf(getGrade1());
	}

	public String getGrade2AsString() {
		return String.valueOf(getGrade2());
	}

	public String getGradeAsString() {
		return String.valueOf(getGrade());
	}

	public String getCommentAsValue() {
		return "'" + getComment() + "'";
	}

	public String getAvg_gradeAsString() {

		return String.valueOf(getAvg_grade());
	}

	public String getCompetitiveAsString() {
		return String.valueOf(getCompetitive());
	}

	public String getCommitment_companyAsString() {
		return String.valueOf(getCommitment_company());
	}

	public String getTeamworkAsString() {
		return String.valueOf(getTeamwork());
	}

	public String getProactiveAsString() {
		return String.valueOf(getProactive());
	}

	public String getWork_under_pressureAsString() {
		return String.valueOf(getWork_under_pressure());
	}

	public String getObjectiveAsString() {
		return String.valueOf(getObjective());
	}

	public String getAnalyticalAsString() {
		return String.valueOf(getAnalytical());
	}

	public String getDecision_makingAsString() {
		return String.valueOf(getDecision_making());
	}

	public String getLeadershipAsString() {
		return String.valueOf(getLeadership());
	}

	public String getResponsibilityAsString() {
		return String.valueOf(getResponsibility());
	}

	public String getPunctualityAsString() {
		return String.valueOf(getPunctuality());
	}

	public String getHonestyAsString() {
		return String.valueOf(getHonesty());
	}

	public String getRespectAsString() {
		return String.valueOf(getRespect());
	}

	public String getOrganizedAsString() {
		return String.valueOf(getOrganized());
	}

	public String getLanguage_skillsAsString() {
		return String.valueOf(getLanguage_skills());
	}

	public String getComputer_skillsAsString() {
		return String.valueOf(getComputer_skills());
	}

	public String getGive_successful_solutionsAsString() {
		return String.valueOf(getGive_successful_solutions());
	}

	public String getCommunication_skillsAsString() {
		return String.valueOf(getCommunication_skills());
	}

	public String getBusiness_skillsAsString() {
		return String.valueOf(getBusiness_skills());
	}

	public String getBusiness_knowledgeAsString() {
		return String.valueOf(getBusiness_knowledge());
	}

	public String getResource_optimizationAsString() {
		return String.valueOf(getResource_optimization());
	}

	public String getMarket_knowledgeAsString() {
		return String.valueOf(getMarket_knowledge());
	}

	public String getPerformanceAsString() {
		return String.valueOf(getPerformance());
	}

	public String getEfficiencyAsString() {
		return String.valueOf(getEfficiency());
	}

	public String getProductivityAsString() {
		return String.valueOf(getProductivity());
	}

	public String getInnovativeAsString() {
		return String.valueOf(getInnovative());
	}

	/*public static Evaluation build(ResultSet rs, EmployeesEntity employeesEntity, CompaniesEntity companiesEntity,
			EmailAddressesEntity emailAddressesEntity, AreasEntity areasEntity) {
		try {
			return (new Evaluation()).setId(rs.getInt("id"))
					.setIdEvaluator(employeesEntity.findById(rs.getInt("id_evaluator"), companiesEntity,
							emailAddressesEntity, areasEntity))
					.setIdUserEmployee(employeesEntity.findById(rs.getInt("id_user_employee"), companiesEntity,
							emailAddressesEntity, areasEntity))
					.setCompany(companiesEntity.findById(rs.getInt("id_company"), emailAddressesEntity))
					.setArea(areasEntity.findById(rs.getInt("id_area")))

					.setDate(rs.getTimestamp("evaluation_date_and_time")).setGrade(rs.getFloat("grade"))
					.setGrade1(rs.getFloat("grade1")).setGrade2(rs.getFloat("grade2"))
					.setCompetitive(rs.getFloat("competitive")).setCommitment_company(rs.getFloat("commitment_company"))
					.setTeamwork(rs.getFloat("teamwork")).setProactive(rs.getFloat("proactive"))
					.setWork_under_pressure(rs.getFloat("work_under_pressure")).setObjective(rs.getFloat("objective"))
					.setAnalytical(rs.getFloat("analytical")).setDecision_making(rs.getFloat("decision_making"))
					.setLeadership(rs.getFloat("leadership")).setResponsibility(rs.getFloat("responsibility"))
					.setPunctuality(rs.getFloat("punctuality")).setHonesty(rs.getFloat("honesty"))
					.setRespect(rs.getFloat("respect")).setOrganized(rs.getFloat("organized"))
					.setLanguage_skills(rs.getFloat("language_skills"))
					.setComputer_skills(rs.getFloat("computer_skills"))
					.setGive_successful_solutions(rs.getFloat("give_successful_solutions"))
					.setCommunication_skills(rs.getFloat("communication_skills"))
					.setBusiness_skills(rs.getFloat("business_skills"))
					.setBusiness_knowledge(rs.getFloat("business_knowledge"))
					.setResource_optimization(rs.getFloat("resource_optimization"))
					.setMarket_knowledge(rs.getFloat("market_knowledge")).setPerformance(rs.getFloat("performance"))
					.setEfficiency(rs.getFloat("efficiency")).setProductivity(rs.getFloat("productivity"))
					.setInnovative(rs.getFloat("innovative")).setComment(rs.getString("comment"))
					.setAvg_grade(rs.getFloat("avg_grade"))

			;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/*public static Evaluation build2(ResultSet rs, EmployeesEntity employeesEntity, CompaniesEntity companiesEntity,
			EmailAddressesEntity emailAddressesEntity, AreasEntity areasEntity) {
		try {
			return (new Evaluation())
					.setIdUserEmployee(employeesEntity.findById(rs.getInt("id_user_employee"), companiesEntity,
							emailAddressesEntity, areasEntity))
					.setCompany(companiesEntity.findById(rs.getInt("id_company"), emailAddressesEntity))
					.setGrade(rs.getFloat("avg(grade)")).setGrade1(rs.getFloat("avg(grade1)"))
					.setGrade2(rs.getFloat("avg(grade2)")).setAvg_grade(rs.getFloat("avg(avg_grade)"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/*public static Evaluation build3(ResultSet rs, EmployeesEntity employeesEntity, CompaniesEntity companiesEntity,
			EmailAddressesEntity emailAddressesEntity, AreasEntity areasEntity) {
		try {
			return (new Evaluation()).setId(rs.getInt("id"))
					.setYear(rs.getInt("from_unixtime( UNIX_TIMESTAMP(  evaluation_date_and_time),'%Y')"))
					.setMonth(rs.getInt("from_unixtime( UNIX_TIMESTAMP(  evaluation_date_and_time),'%m')"))
					.setDay(rs.getInt("from_unixtime( UNIX_TIMESTAMP(  evaluation_date_and_time),'%d')"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

}
