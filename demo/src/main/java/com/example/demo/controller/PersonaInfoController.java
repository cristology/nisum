package com.example.demo.controller;

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
import com.example.demo.repository.PersonaRepository;

@Controller
@RequestMapping("/persona")
public class PersonaInfoController {

	private static final Logger logger = LoggerFactory.getLogger(PersonaInfoController.class);
	
	@Autowired
	PersonaRepository personaRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
	public String save(@RequestBody PersonaInfo persona){
		
		logger.debug("Grabando nueva persona: ",persona.toString());
		personaRepository.save(persona);
		return "Persona guardada: " + persona.getId();
    }	
    
    @RequestMapping(value="/modify",method=RequestMethod.POST)
    @ResponseBody
    public String modify(@RequestBody PersonaInfo persona){
    	logger.debug("Modificando nueva persona: ",persona.toString());
    	personaRepository.save(persona);
		return "Persona modificada: " + persona.getId();        
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
    public Optional<PersonaInfo> retrieve(@PathVariable("id") int id){		
    	logger.debug("Obteniendo persona: ");
		Optional<PersonaInfo> persona = personaRepository.findById(id);		
		return persona;
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id){
    	logger.debug("Eliminando persona: ",id);
    	personaRepository.deleteById(id);    	
		return "Persona eliminada: " + id;
    }
    
}
