package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce.model.producto;

public interface IProductoService {
	
	public producto save(producto producto);
	
	public Optional<producto> get(Integer Id);
	
	public void update(producto producto);
	
	public void delete(Integer Id);
	
	public List<producto> finAll();

}
