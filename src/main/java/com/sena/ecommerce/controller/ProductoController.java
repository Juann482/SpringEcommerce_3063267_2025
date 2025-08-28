package com.sena.ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sena.ecommerce.model.Producto;
import com.sena.ecommerce.model.Usuario;
import com.sena.ecommerce.service.IProductoService;
import com.sena.ecommerce.service.UploadFileService;

@Controller
@RequestMapping("/productos")//Para hacer el llamado
public class ProductoController {
	
	//Instancia LOGGER
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class); //Exclusivo para este metodo - los logger ayudan a depurar en consola
	
	@Autowired
	private IProductoService productoservice;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String show(Model model) { //redirige a show.html
		model.addAttribute("productos", productoservice.findAll());
		return "productos/show";
	}
	
	//metodod e redireccionamiento
	@GetMapping("/create")
	public String create() { //Para crear productos
	    return "productos/create";
	}
	
	//Metodo de creacion de producto
	@PostMapping("/save")
	public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto del producto a guardar en la DB {}",producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		//Validacion imagen del producto
		if (producto.getId() == null) {
			String nombreImagen = upload.saveImages(file, producto.getNombre());
			producto.setImagen(nombreImagen);
		}
		productoservice.save(producto);
		return "redirect:/productos";
		
	}
	
	//Metodo para el formulario de edicion de producto
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto p = new Producto();
		//Retorna labusqueda de un objeto de tipo producto con el id
		Optional<Producto> op = productoservice.get(id);
		p = op.get();
		LOGGER.warn("Busqueda de producto por id {}", p);
		model.addAttribute("producto", p);
		return "productos/edit";
		
	}
	
	//Metodo de actualizacion de datos
	@PostMapping("/update")
	public String update(Producto producto, @RequestParam("img") MultipartFile file)throws IOException {
		LOGGER.info("Este es el objeto de producto a actualizar en la DB {}", producto);
		Producto p = new Producto();
		p = productoservice.get(producto.getId()).get();
		//Validar imagen
		if (file.isEmpty()) {
			producto.setImagen(p.getImagen());
		} else {
			if (!p.getImagen().equals("default.jpg")) {
				upload.deleteImage(p.getImagen());
			}
			String nombreImagen = upload.saveImages(file, p.getNombre());
			producto.setImagen(nombreImagen);
		}
		producto.setUsuario(p.getUsuario());
		productoservice.update(producto);
		return "redirect:/productos";
	}
	
	//metodo para eliminar con id un producto
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable Integer id) {
		Producto p = new Producto();
		p = productoservice.get(id).get();
		if (!p.getImagen().equals("default.jpg")) {
			upload.deleteImage(p.getImagen());			
		}
		productoservice.delete(id);
		return "redirect:/productos";
	}

}
