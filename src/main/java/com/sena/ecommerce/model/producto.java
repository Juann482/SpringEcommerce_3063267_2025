package com.sena.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")

public class producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String nombre;
	private String dscripcion;
	private String imagen;
	private Double precio;
	private Integer cantidad;
	
	@ManyToOne
	private usuario usuario;
	
	public producto() {
		
	}

	public producto(Integer id, String nombre, String dscripcion, String imagen, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dscripcion = dscripcion;
		this.imagen = imagen;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDscripcion() {
		return dscripcion;
	}

	public void setDscripcion(String dscripcion) {
		this.dscripcion = dscripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "producto [id=" + id + ", nombre=" + nombre + ", dscripcion=" + dscripcion + ", imagen=" + imagen
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
