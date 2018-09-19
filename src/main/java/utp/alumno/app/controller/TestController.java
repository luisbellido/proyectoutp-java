package utp.alumno.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import utp.alumno.app.model.Area;
import utp.alumno.app.model.User;

@Controller
public class TestController {

	@GetMapping("/saludo")
	public String getSaludo(Model model) {
		User usr=new User();
		usr.setUsername("Hello Sarita");
		//usr.setCodiusua("Hello Sarita");
		//usr.setCoreusua("Hello Sarita");
		usr.setPassname("Luis Albertho Bellido Taipe");
		model.addAttribute("usr", usr);
		return "pagina";
	}
}
