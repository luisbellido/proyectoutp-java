package utp.alumno.app.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter @Setter
public class Area {
	
	@NotNull
	private int id;
	
	@NotNull @Size(min=2, max=100)
	private String namearea;
	
	//@AssertTrue
	private boolean status;

}
