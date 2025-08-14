package com.sena.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ecommerce.model.usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<usuario, Integer>{
	
	Optional<usuario> findByEmail(String email); 
	
	//Optional<usuario> findByusername(String username); 

}
