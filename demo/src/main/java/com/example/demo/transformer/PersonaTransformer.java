package com.example.demo.transformer;

import com.example.demo.entity.PersonaInfo;
import com.example.demo.model.PersonaModel;

public class PersonaTransformer {
	
	 public static PersonaInfo convertModelToEntity(PersonaModel persona) {

	    	PersonaInfo ret = null;
	    	
	    	if(persona!=null) {
	    		ret=new PersonaInfo();    		
	    		if(persona.getId()!=null && persona.getId().trim().length()>0) {
	    			ret.setId(Integer.parseInt(persona.getId()));	
	    		}    		
	    		ret.setName(persona.getName());
	    		ret.setLastName(persona.getLastName());
	    		ret.setAddress(persona.getAddress());    		
	    		ret.setPhoneNumber(Integer.parseInt(persona.getPhoneNumber()));
	    		ret.setHairColour(persona.getHairColour());    		
	    	}
			return ret;
		}
	    
	    public static PersonaModel convertEntityToModel(PersonaInfo persona) {

	    	PersonaModel ret = null;
	    	
	    	if(persona!=null) {
	    		ret=new PersonaModel();
	    		ret.setId(persona.getId().toString());
	    		ret.setName(persona.getName());
	    		ret.setLastName(persona.getLastName());
	    		ret.setAddress(persona.getAddress());    		
	    		ret.setPhoneNumber(persona.getPhoneNumber().toString());
	    		ret.setHairColour(persona.getHairColour());    		
	    	}
			return ret;
		}
}
