package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.transformer.PersonaTransformer;
import com.example.demo.entity.PersonaInfo;
import com.example.demo.model.PersonaModel;
import com.example.demo.repository.PersonaRepository;

@Controller
@RequestMapping("/persona")
public class PersonaInfoController {

	private static final Logger logger = LoggerFactory.getLogger(PersonaInfoController.class);
	
	@Autowired
	PersonaRepository personaRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
	public Object save(@RequestBody PersonaModel persona){
		
		logger.debug("Grabando nueva persona: ",persona.toString());
		
		List<String> validation = validatePersonData(persona);
		if(validation!=null && validation.size()>0) {
			return validation;
		}
		
		PersonaInfo personaSaved = personaRepository.save(PersonaTransformer.convertModelToEntity(persona));
		return "Persona guardada: " + personaSaved.getId();
    }	
    
   

	@RequestMapping(value="/modify",method=RequestMethod.POST)
    @ResponseBody
    public Object modify(@RequestBody PersonaModel persona){
    	logger.debug("Modificando nueva persona: ",persona.toString());
    	
    	List<String> validation = validatePersonData(persona);
		if(validation!=null && validation.size()>0) {
			return validation;
		}
		
    	personaRepository.save(PersonaTransformer.convertModelToEntity(persona));
		return "Persona modificada: " + persona.getId();        
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
    public PersonaModel retrieve(@PathVariable("id") int id){		
    	logger.debug("Obteniendo persona: ");
		PersonaInfo persona = personaRepository.getById(id);		
		return PersonaTransformer.convertEntityToModel(persona);
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
    	
    	String onlyNumbersRegExp = "^[0-9]*$";
    	String onlyLettersRegExp = "^[A-Za-z]*$";
    	String addressRegExp = "^[A-Za-z0-9\\s]*$";
    	String hairColourRegExp="(black|yellow|brown|red|white)";
    	
    	if(persona!=null) {
    		
    		//ID    		
    		if(persona.getId()!=null && !Pattern.matches(onlyNumbersRegExp,persona.getId())) {
    			ret.add("ERROR: el atributo ID debe contener solo numeros");
    		}
    		
    		//NAME
    		if(!Pattern.matches(onlyLettersRegExp,persona.getName())) {
    			ret.add("ERROR: el atributo NAME debe contener solo letras");
    		}
    		
    		//LAST NAME
    		if(!Pattern.matches(onlyLettersRegExp,persona.getLastName())) {
    			ret.add("ERROR: el atributo LAST_NAME debe contener solo letras");
    		}
    		
    		//ADDRESS
    		if(!Pattern.matches(addressRegExp,persona.getAddress())) {
    			ret.add("ERROR: el atributo ADDRESS debe contener solo letras y espacios");
    		}
    		
    		//PHONE NUMBER
    		if(!Pattern.matches(onlyNumbersRegExp,persona.getPhoneNumber())) {
    			ret.add("ERROR: el atributo PHONE_NUMBER debe contener solo numeros");
    		}
    		
    		//HAIR COLOR    		
    		if(!Pattern.matches(hairColourRegExp,persona.getHairColour().toLowerCase())) {
    			ret.add("ERROR: el atributo HAIR_COLOUR debe ser uno de los siguientes valores: BLACK, RED, YELLOW, BROWN, WHITE ");
    		}   		
    		
    		
    	}else {
    		ret.add("ERROR: Debes agregar valores ");
    	}
    	
    	
    	return ret;
    }    
   
    
}
