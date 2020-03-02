package com.ruv_front.tsb.controller;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.ruv_front.tsb.Model.CalendarioModel;

@Controller
@RequestMapping(value = "/calendario" )
public class CalendarioController {

    @GetMapping
    public String ViewCalendario(Model model){	   	
         model.addAttribute("calendarioList",getcalendario());
         return "calendarioList";
    }

    
    public List<CalendarioModel> getcalendario()
	{
	    final String uri = "http://localhost:8181/calendario";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    List<CalendarioModel> result = restTemplate.getForObject(uri, List.class);	  
	    System.out.println(result);
	    return result; 

	}



	public CalendarioModel getcalendariobyid(int id) {
	    String uri = "http://localhost:8181/calendario";
		    RestTemplate restTemplate = new RestTemplate();
		    uri=uri+"/${id}";
		    CalendarioModel calendarioid = restTemplate.getForObject(uri, CalendarioModel.class);  
		return calendarioid;
	}

	@GetMapping("/crearcalendario")
	public String crearcalendario(Map<String, Object> model) {

		CalendarioModel calendario = new CalendarioModel();
		model.put("calendario", calendario);
		model.put("accion", "guardar");

		return "crearcalendario";
	}
	@PostMapping("/guardar")
	public String guardar(@Validated({ CalendarioModel.class, Default.class }) CalendarioModel calendario, BindingResult result) {
		if (result.hasErrors()) {
			return "calendarioList";
		}

		String uri = "http://localhost:8181/calendario";
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.postForEntity(uri, calendario, null);  
	    
	    
		return "redirect:/calendarioList";
	}
}
