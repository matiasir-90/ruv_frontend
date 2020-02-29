package com.ruv_front.tsb.controller;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.ruv_front.tsb.Model.CalendarioModel;

@Controller
@RequestMapping(value = "/calendario" )
public class CalendarioController {

	public static final String VISTA_FORMULARIO = "crearcalendario";
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

	
	@GetMapping("/crearcalendario")

	public String crearcalendario(Model model) {
		model.addAttribute("calendario", getcalendario());


	return "crearcalendario";
}
}
//    
//@PostMapping
//public CalendarioEntity agregarC(@RequestBody CalendarioModel p){
//    return service.add(p);
//}
//@GetMapping(path = {"/{id}"})
//public CalendarioEntity listarId(@PathVariable("id")int id){
//    return service.listarId(id);
//}
//@PutMapping(path = {"/{id}"})
//public CalendarioEntity editar(@RequestBody CalendarioModel p,@PathVariable("id") int id){
//    p.setId(id);
//    return service.edit(p);
//}
//@DeleteMapping(path = {"/{id}"})
//public CalendarioEntity delete(@PathVariable("id") int  id){
//    return service.delete(id);
//}
//                                                                                            
