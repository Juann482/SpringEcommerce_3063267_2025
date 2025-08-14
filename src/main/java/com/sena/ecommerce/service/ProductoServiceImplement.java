package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sena.ecommerce.model.producto;
import com.sena.ecommerce.repository.IProductoRepository;

public class ProductoServiceImplement  implements IProductoService{
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public producto save(producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Optional<producto> get(Integer Id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(Id);
	}

	@Override
	public void update(producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer Id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(Id);
		
	}

	@Override
	public List<producto> finAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

}
