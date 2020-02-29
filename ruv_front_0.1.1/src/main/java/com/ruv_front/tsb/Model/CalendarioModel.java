package com.ruv_front.tsb.Model;

import java.util.Date;


public class CalendarioModel {

	public CalendarioModel() {}
	
	private int id;
	private String calendarioDescripcion;
	private Date fechaInicio;
	private Date fechaFin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCalendarioDescripcion() {
		return calendarioDescripcion;
	}
	public void setCalendarioDescripcion(String calendarioDescripcion) {
		this.calendarioDescripcion = calendarioDescripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
