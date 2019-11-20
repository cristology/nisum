package com.example.demo.controller;

import com.example.demo.entity.PersonaInfo;
import com.example.demo.repository.PersonaRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/persona")
public class PersonaInfoController {

	@Autowired
	PersonaRepository personaRepository;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
    public Optional<PersonaInfo> retrieve(@PathVariable("id") int id){		
		Optional<PersonaInfo> persona = personaRepository.findById(id);		
		return persona;
    }
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(@RequestBody PersonaInfo persona){
		personaRepository.save(persona);
		return "Persona guardada: " + persona.getId();
    }       
    
    @RequestMapping(value="/modify",method=RequestMethod.POST)
    public String modify(@RequestParam("persona") PersonaInfo persona){
    	personaRepository.save(persona);
		return "Persona modificada: " + persona.getId();        
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
    	personaRepository.deleteById(id);    	
		return "Persona eliminada: " + id;
    }
    
}
