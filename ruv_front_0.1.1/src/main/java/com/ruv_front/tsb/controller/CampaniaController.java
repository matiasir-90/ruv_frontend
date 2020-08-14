package com.ruv_front.tsb.controller;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.ruv_front.tsb.Model.CampaniaModel;


@Controller
@RequestMapping(value = "/campania")
public class CampaniaController {
	private String uri = "http://localhost:8080/campania";

	// default
	@GetMapping
	public String ViewCampania(Model model) {
		model.addAttribute("campaniaList", getCampania());
		return "campaniaList";
	}

	public List<CampaniaModel> getCampania() {
		RestTemplate restTemplate = new RestTemplate();

		List<CampaniaModel> result = restTemplate.getForObject(uri, List.class);
		System.out.println(result);
		return result;

	}

//    alta Campania
	@GetMapping("/crearcampania")
	public String crearcampania(Map<String, Object> model) {

		CampaniaModel campania = new CampaniaModel();
		model.put("campania", campania);
		model.put("accion", "guardar");

		return "crearcampania";
	}

	@PostMapping("/guardar")
	public String guardar(@Validated({ CampaniaModel.class, Default.class }) CampaniaModel campania,
			BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/campania";
		}
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(uri, campania, null);

		return "redirect:/campania";
	}

//delete campania
	@GetMapping("/eliminar/{id}")
	public String deletecampania(@PathVariable("id") String id)

	{
		final String uri = "http://localhost:8080/campania/" + id;

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri);

		return "redirect:/campania";
	}

//    principal a editar 
	@GetMapping(path = { "/editar/{id}" })
	public String ViewCampaniabyid(@PathVariable("id") String id, Model model) {
		model.addAttribute("campania", getCampaniabyid(id));
		return "editcampania";
	}

//    llama a Campania especifico

	public CampaniaModel getCampaniabyid(String id) {
		RestTemplate restTemplate = new RestTemplate();

		final String uri2 = "http://localhost:8080/campania/" + id;

		System.out.println(uri2);

		CampaniaModel campania = restTemplate.getForObject(uri2, CampaniaModel.class, id);

		return campania;

	}
	@GetMapping("/update/{id}")
	public String updatelendario(@PathVariable("id") String id,@Validated({ CampaniaModel.class, Default.class }) CampaniaModel campania,
			BindingResult result) {

		final String uri = "http://localhost:8080/campania/" + id;
//		if (result.hasErrors()) {
//			return "redirect:/campania";
//		}
//		campania.setCampania_desce(campania.getCampania_desce());
//		campania.setFecha_inicio(campania.getFecha_inicio());
//		campania.setFecha_fin(campania.getFecha_fin());
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		restTemplate.put(uri,campania);
		return "redirect:/campania";
	}
}
