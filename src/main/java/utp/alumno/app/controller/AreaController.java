package utp.alumno.app.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import utp.alumno.app.constant.utils;
import utp.alumno.app.constant.view;
import utp.alumno.app.model.Area;
import utp.alumno.app.service.AreaService;

@Controller
public class AreaController {

	private static final Log LOG = LogFactory.getLog(AreaController.class);

	@Autowired
	@Qualifier("areaService")
	private AreaService areaService;

	// Mostrar solo a Vista
	@GetMapping("/areas")
	public String getArea() {
		return view.AREA_VIEW;
	}

	private Area areavalue = null;

	@GetMapping("/areas/areaForm")
	public ModelAndView getAreaForm(@RequestParam(name = "idarea", required = false, defaultValue = "0") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(view.AREA_FORM_VIEW);
		if (id == 0) {
			areavalue = new Area();
		} else {
			areavalue = areaService.getAreaById(id);
		}
		mav.addObject("area", areavalue);
		return mav;
	}

	@GetMapping("/areas/areaDetails/{idarea}")
	public String getAreaDetails(Model model, @PathVariable("idarea") int id) {
		model.addAttribute("area", areaService.getAreaById(id));
		return view.AREA_FORM_DETAILS;
	}

	// Mostrar Lista en formato JSON
	@PostMapping("/areas/findAllAreas")
	public @ResponseBody String listAreaJson(ModelMap model, 
			@RequestParam("rows") int rows,
			@RequestParam("page") int page) throws JSONException {

		JSONObject json = new JSONObject();
		try {
			int total = areaService.findAllAreasCount();
			int offset = (page - 1) * rows;
			json.put("total", total);
			json.put("rows", areaService.findAllAreas(offset, rows));

		} catch (Exception e) {
			json.put("isError", true);
			json.put("message", "Error al momento de Realizar la Consula\nComuníquese con el Administrador de Sistema");
			LOG.error(e.getMessage());
		}
		return json.toString();
	}

	@PostMapping("/areas/addArea")
	public @ResponseBody String addArea(@Valid @ModelAttribute("area") Area area, BindingResult br) {
		JSONObject json = new JSONObject();
		try {
			if (br.hasErrors()) {
				json.put("errorValidation", "Error de Validación");
				json.put("fieldValue", br.getFieldError().getRejectedValue());
				StringBuilder errorMsg = new StringBuilder(br.getFieldError().getDefaultMessage());
				errorMsg.setCharAt(0, (errorMsg.substring(0, 1).toUpperCase()).charAt(0));
				json.put("fieldMsg", errorMsg.toString());
			} else if (areavalue.getId() != area.getId()) {
				json.put("errorHidden", "Ha realizado un cambio manual, vuelva a cargar el formulario");
			} else {
				
				int rpta = area.getId() == 0 ? areaService.createArea(area) : areaService.updateArea(area);
				if (rpta > 0) {
					json.put("okMsg", "Registro Procesado Correctamente");
				} else {
					json.put("errorMsg", "Registro Procesado");
				}
			}
		} catch (Exception e) {
			json.put("errorMsg","Ha ocurrido un Error\nComuníquese con el Administrador de Sistema");
			LOG.error(e.getMessage());
		}
		return json.toString();
	}
	
}
