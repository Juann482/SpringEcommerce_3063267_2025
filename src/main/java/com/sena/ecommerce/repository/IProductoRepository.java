package com.sena.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ecommerce.model.producto;

@Repository
public interface IProductoRepository extends JpaRepository<producto, Integer>{

}
