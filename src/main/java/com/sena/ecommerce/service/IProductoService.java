package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.sena.ecommerce.model.Producto;

public interface IProductoService {
	
	public Producto save(Producto producto);
	
	public Optional<Producto> get(Integer Id);
	
	public void update(Producto producto);
	
	public void delete(Integer Id);
	
	public List<Producto> finAll();

}
