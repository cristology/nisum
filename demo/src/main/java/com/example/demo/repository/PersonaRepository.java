  

package com.example.demo.repository;

import com.example.demo.entity.PersonaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<PersonaInfo, Serializable>{

	public abstract PersonaInfo getById(int id);

}