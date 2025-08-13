package com.sena.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "prductos")
public class producto {

	private Integer id;
	private String nombre;
	private String dscripcion;
	private String imagen;
	private Double precio;
	private Integer cantidad;
	
	@ManyToOne
	private Usuario usuario;
	
	public Producto() {
		
	}
}
