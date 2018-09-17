package utp.alumno.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import utp.alumno.app.constant.view;
import utp.alumno.app.model.EmailAddress;
import utp.alumno.app.service.EmailAddressService;

@Controller
public class EmailAddressesController {

	private static final Log LOG = LogFactory.getLog(EmailAddressesController.class);
	private EmailAddress emailvalue = null;
	
	@Autowired
	@Qualifier("emailAddressService")
	private EmailAddressService emailAddressService;
	
	@GetMapping("/correos")
	public String getArea() {
		return view.CORREO_FORM;
	}
	
	@PostMapping("/correos/getEmailAddresses")
	public @ResponseBody String listUsersJson(ModelMap model, 
			@RequestParam("rows") int rows,
			@RequestParam("page") int page) throws JSONException {
		JSONObject json = new JSONObject();
		try {
			int total = emailAddressService.getEmailCount();
			int offset = (page - 1) * rows;
			json.put("total", total);
			json.put("rows", emailAddressService.getEmailAddresses(offset, rows));

		} catch (Exception e) {
			json.put("isError", true);
			json.put("message", "Error al momento de Realizar la Consula\nComuníquese con el Administrador de Sistema");
			LOG.error(e.getMessage());
		}
		return json.toString();
	}
	
	@GetMapping("/correos/correoForm")
	public ModelAndView getCorreoForm(@RequestParam(name = "idcorreo", required = false, defaultValue = "0") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(view.CORREO_FORM_VIEW);
		if (id == 0) {
			emailvalue = new EmailAddress();
		} else {
			emailvalue = emailAddressService.getEmailAddressById(id);
		}
		mav.addObject("email", emailvalue);
		return mav;
	}
	
	@PostMapping("/correos/addCorreo")
	public @ResponseBody String addCorreo() {
		return "";
	}
	
	
}
