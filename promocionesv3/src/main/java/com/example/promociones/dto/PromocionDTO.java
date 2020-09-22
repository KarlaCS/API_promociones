package com.example.promociones.dto;

import java.io.Serializable;

public class PromocionDTO implements Serializable{

	private static final long serialVersionUID = -8428067755484792689L;
	private Integer idProducto;
	private Integer porcentaje;
	private String descripcion;
	private Boolean activa;
	
	public PromocionDTO() {
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

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}
	
}
