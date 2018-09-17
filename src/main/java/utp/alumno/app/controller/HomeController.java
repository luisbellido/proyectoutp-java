package utp.alumno.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import utp.alumno.app.constant.utils;
import utp.alumno.app.constant.view;
import utp.alumno.app.model.User;

@Controller
@RequestMapping(view.MAPPING_VIEW)
public class HomeController {

	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("home");
	}

	// Pantalla de Inicio
	@GetMapping("/home")
	public String getHome(Model model) {
		//System.out.println(this.user);
		model.addAttribute("user", new User());
		return view.LOGIN_VIEW;
	}

	// Formulario de Bienvenida o el dashboard
	@PostMapping("/login")
	public ModelAndView setLogin(@Valid @ModelAttribute("user") User user, BindingResult br) {
		ModelAndView mav = new ModelAndView();
		if (br.hasErrors()) {
			mav.setViewName(view.LOGIN_VIEW);
		} else {
			if (user.getUsername().equals("admin") && user.getPassname().equals("123")) {
				mav.addObject("message",  ("Bienvenido al Sistema : ").concat(user.getUsername()).toUpperCase());
				mav.addObject("cssclass",  "alert alert-success");
				mav.addObject("success",  true);
			}else {
				mav.addObject("message",  "Usuario y/o Contraseña incorrecto.");
				mav.addObject("cssclass",  "alert alert-danger");
			}
			mav.setViewName(view.LOGIN_VIEW);
		}
		return mav;
	}

	@GetMapping("/dashboard")
	public ModelAndView handleGetRequest(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(view.DASHBOARD_VIEW);
		return mav;
	}
	
	@GetMapping("/sidebarmenu")
	public String getSidebar() {
		return "fragment/fragment-sidebar-menu";
	}
	

}
