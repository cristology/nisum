package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.PersonaInfo;
import com.example.demo.model.PersonaModel;
import com.example.demo.repository.PersonaRepository;

import java.util.regex.*;

@Controller
@RequestMapping("/persona")
public class PersonaInfoController {

	private static final Logger logger = LoggerFactory.getLogger(PersonaInfoController.class);
	
	@Autowired
	PersonaRepository personaRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
	public String save(@RequestBody PersonaModel persona){
		
		logger.debug("Grabando nueva persona: ",persona.toString());
		
		PersonaInfo pi = new PersonaInfo();
		
		personaRepository.save(pi);
		return "Persona guardada: " + persona.getId();
    }	
    
    @RequestMapping(value="/modify",method=RequestMethod.POST)
    @ResponseBody
    public String modify(@RequestBody PersonaModel persona){
    	logger.debug("Modificando nueva persona: ",persona.toString());
    	
    	PersonaInfo pi = new PersonaInfo();
    	
    	personaRepository.save(pi);
		return "Persona modificada: " + persona.getId();        
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
    public PersonaModel retrieve(@PathVariable("id") int id){		
    	logger.debug("Obteniendo persona: ");
		Optional<PersonaInfo> persona = personaRepository.findById(id);		
		
		PersonaModel pmodel = new PersonaModel();
		return pmodel;
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id){
    	logger.debug("Eliminando persona: ",id);
    	personaRepository.deleteById(id);    	
		return "Persona eliminada: " + id;
    }
    
    private List<String> validatePersonData(PersonaModel persona) {
    	
    	List<String> ret = new ArrayList<>();
    	
    	if(persona!=null) {
    		
    		//ID
    		if(!Pattern.compile("expresion").matcher(persona.getId()).matches()) {
    			ret.add("ERROR: el atributo ID debe contener solo numeros");
    		}
    		
    		//NAME
    		if(!Pattern.compile("expresion").matcher(persona.getName()).matches()) {
    			ret.add("ERROR: ");
    		}
    		
    		//LAST NAME
    		if(!Pattern.compile("expresion").matcher(persona.getLastName()).matches()) {
    			ret.add("ERROR: ");
    		}
    		
    		//ADDRESS
    		if(!Pattern.compile("expresion").matcher(persona.getAddress()).matches()) {
    			ret.add("ERROR: ");
    		}
    		
    		//PHONE NUMBER
    		if(!Pattern.compile("expresion").matcher(persona.getPhoneNumber()).matches()) {
    			ret.add("ERROR: ");
    		}
    		
    		//HAIR COLOR
    		/*
    		if(!Pattern.compile("expresion").matcher(persona.getHairColour()).matches()) {
    			ret.add("ERROR: ");
    		}
    		*/
    		    		
    		if(!"black".equalsIgnoreCase(persona.getHairColour())
				&& !"red".equalsIgnoreCase(persona.getHairColour())
				&& !"yellow".equalsIgnoreCase(persona.getHairColour())
				&& !"brown".equalsIgnoreCase(persona.getHairColour())
				&& !"white".equalsIgnoreCase(persona.getHairColour())) {
    			
    			ret.add("ERROR: el atributo HAIR_COLOUR debe ser uno de los siguientes valores: BLACK, RED, YELLOW, BROWN, WHITE ");
    		}
    		
    		
    	}else {
    		ret.add("ERROR: Debes agregar valores ");
    	}
    	
    	
    	return ret;
    }
    
}
