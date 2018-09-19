package utp.alumno.app.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter @Setter

public class EmailAddress {
	
	@NotNull(message = "Debe ingrese un valor Numérico")
	private int id;
	
	@NotNull
	@Size(min=2, max=100)
	@Email
	private String emaildata;

	private boolean statusemail;

}
