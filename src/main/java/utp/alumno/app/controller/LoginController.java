package utp.alumno.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.Getter;
import lombok.Setter;
import utp.alumno.app.constant.view;
import utp.alumno.app.model.User;

@Controller
public class LoginController {

	// Pantalla de Formulario para el sistema


	@GetMapping("/showFormLogin")
	public String getFormLogin(Model model) {
		return view.FORMLOGIN_VIEW;
	}


	@GetMapping("/logout")
	public String getHome() {
		return "redirect:/home";
	}

}
