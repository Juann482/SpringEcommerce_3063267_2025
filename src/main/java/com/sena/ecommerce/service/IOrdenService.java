package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce.model.Orden;
import com.sena.ecommerce.model.usuario;


public interface IOrdenService {
	
public Orden save(Orden orden);
	
	public Optional<Orden> get(Integer Id);
	
	public List<Orden> finAll();
	
	public List<Orden> finByUsuario (usuario usuario);
	
	public String generarNumeroOrden();

}
