package utp.alumno.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import utp.alumno.app.constant.view;

@Controller
public class CompanyController {
	
	private static final Log LOG = LogFactory.getLog(CompanyController.class);
	
	@GetMapping("/companies")
	public String getCompany() {
		return view.COMPANIES_FORM;
	}
	
}
