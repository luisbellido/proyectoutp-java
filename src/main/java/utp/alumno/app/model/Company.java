package utp.alumno.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter @Setter
public class Company {

	private int id;
	private String nameCompany;
	private String descriptioncompany;
	private EmailAddress emailaddress;
	private String photocompany;
	private String addresscompany;
	private String phonecompany;
	private boolean statuscompany;
	
}