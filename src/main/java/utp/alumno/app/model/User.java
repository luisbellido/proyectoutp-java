package utp.alumno.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
	
	@Getter @Setter 
	@NotNull(message = "Este campo es Obligatorio") @Size(min=2, max=100)
	private String username;
	
	@Getter @Setter
	@NotNull(message = "Este campo es Obligatorio") @Size(min=2, max=100)
	private String passname;

}
