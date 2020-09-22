package com.example.promociones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.promociones.entity.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, Integer> {
	List<Promocion> findByIdProducto(Integer idProducto);
	List<Promocion> findByIdProductoAndActivo(Integer idProducto, Boolean activo);
}
