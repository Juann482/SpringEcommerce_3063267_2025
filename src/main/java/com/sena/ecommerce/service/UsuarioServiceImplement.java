package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce.model.usuario;
import com.sena.ecommerce.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImplement implements IUsuarioService{
	
	//Instancia de objeto de tipo privado del repository
	
	@Autowired
	private IUsuarioRepository usuariorepository;

	@Override
	public usuario save(usuario usuario) {
		// TODO Auto-generated method stub
		return usuariorepository.save(usuario);
	}

	@Override
	public Optional<usuario> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<usuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return usuariorepository.findById(id);
	}

	@Override
	public Optional<usuario> findByEmail(Integer email) {
		// TODO Auto-generated method stub
		return usuariorepository.findByEmail(null);
	}

	@Override
	public List<usuario> findAll() {
		// TODO Auto-generated method stub
		return usuariorepository.findAll();
	}

}
