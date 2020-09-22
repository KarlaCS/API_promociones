package com.example.promociones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_promocion")
public class Promocion implements Serializable{

	private static final long serialVersionUID = -6487978895732551972L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_promocion")
	private Integer idPromocion;
	
	@Column(name="id_producto")
	private Integer idProducto;
	
	private Integer porcentaje;
	
	private String descripcion;
	
	private Boolean activo;
	
	public Promocion() {
	}
	
	public Promocion(Integer idProducto, Integer porcentaje, String descripcion, Boolean activo) {
		super();
		this.idProducto = idProducto;
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Integer getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
