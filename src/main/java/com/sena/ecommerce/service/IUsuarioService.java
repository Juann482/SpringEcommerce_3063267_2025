package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce.model.usuario;

public interface IUsuarioService {
	
	public usuario save(usuario usuario);
	
	public Optional<usuario> get(Integer id);
	
	public void update(usuario usuario);
	
	public void delete(Integer id);
	
	public Optional<usuario> findById(Integer id);
	
	public Optional<usuario> findByEmail(Integer email);
	
	List<usuario> findAll();

}
