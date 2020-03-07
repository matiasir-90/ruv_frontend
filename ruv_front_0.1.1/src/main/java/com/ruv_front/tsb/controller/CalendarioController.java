package com.ruv_front.tsb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
import com.ruv_front.tsb.Model.CalendarioModel;

@Controller
@RequestMapping(value = "/calendario" )
public class CalendarioController {
	private String uri = "http://localhost:8181/calendario";
	
	//default 
    @GetMapping
    public String ViewCalendario(Model model){	   	
         model.addAttribute("calendarioList",getcalendario());
         return "calendarioList";
    }

    
    public List<CalendarioModel> getcalendario()
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    List<CalendarioModel> result = restTemplate.getForObject(uri, List.class);	  
	    System.out.println(result);
	    return result; 

	}
//    alta calendario
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
			return "redirect:/calendario";
		}
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.postForEntity(uri, calendario, null);  
	    
		return "redirect:/calendario";
	}
//delete calendario
    @GetMapping("/eliminar/{id}")
    public String deletecalendario(@PathVariable("id") String id)
 
    {
        final String uri = "http://localhost:8181/calendario/" + id;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete ( uri );
        
        return "redirect:/calendario";
    }
    
//    principal a editar 
    @GetMapping(path = {"/editar/{id}"})
    public String ViewCalendariobyid(@PathVariable("id") String id,Model model){	   	
      model.addAttribute("calendario",getcalendariobyid(id));
      return "editcalendario";
    }
    
//    llama a calendario especifico
    
    public CalendarioModel getcalendariobyid(String id)
	{
	    RestTemplate restTemplate = new RestTemplate();

        
        final String uri2 = "http://localhost:8181/calendario/";
        
         System.out.println(uri2);
//        CalendarioModel calendario3 = new CalendarioModel();
//       calendario3 = restTemplate.getForObject(uri2, CalendarioModel.class);
//        System.out.println(calendario3.getId());
         
         CalendarioModel calendario3 = restTemplate.getForObject(uri2+id, CalendarioModel.class);
         System.out.println(calendario3);
	    return calendario3;
	    
	}

}
