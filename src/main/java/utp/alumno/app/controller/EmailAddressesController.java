package utp.alumno.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import utp.alumno.app.constant.utils;
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
	public @ResponseBody String addCorreo(@Valid @ModelAttribute("email") EmailAddress emailAddress, BindingResult br) {
		JSONObject json = new JSONObject();
		try {
			
			if (br.hasErrors()) {
				json.put("fieldValue", br.getFieldError().getRejectedValue());
				StringBuilder errorMsg = new StringBuilder(br.getFieldError().getDefaultMessage());
				errorMsg.setCharAt(0, (errorMsg.substring(0, 1).toUpperCase()).charAt(0));
				json.put("errorMsg", errorMsg.toString());
				//System.out.println(errorMsg.toString());
			}else if(emailvalue.getId() != emailAddress.getId()) {
				json.put("errorMsg", "Ha realizado un cambio manual, vuelva a cargar el formulario");
			}else {
				
				int rpta = emailAddress.getId() == 0 ? 
						emailAddressService.createEmail(emailAddress) :
						emailAddressService.updateEmail(emailAddress);
				if (rpta > 0) {
					json.put("okMsg", "Registro Procesado Correctamente");
				} else {
					json.put("errorMsg", "No se ha procesado ningun dato");
				}
			}
		}catch(NumberFormatException e) {
			json.put("errorMsg", "Ha realizado un cambio manual no númerico");
			LOG.error(e.getMessage());
		} catch (Exception e) {
			json.put("errorMsg", utils.ERRORS_MSG);
			LOG.error(e.getMessage());
		}
		return json.toString();
	}
	
	@GetMapping("/correos/correosDetails/{idcorreo}")
	public String getAreaDetails(Model model, @PathVariable("idcorreo") int id) {
		model.addAttribute("email", emailAddressService.getEmailAddressById(id));
		return view.CORREO_FORM_DETAILS;
	}
	
	
}
