package com.ruv_front.tsb.Model;

import java.util.Date;



public class CalendarioModel {

	public CalendarioModel() {}
	
<<<<<<< HEAD
	private int calendario_id;

	private String calendario_desce;
	private Date fecha_inicio;
	private Date fecha_fin;
=======
	private int id;
	private String calendarioDescripcion;
	private Date fechaInicio;
	private Date fechaFin;
>>>>>>> branch 'master' of https://github.com/matiasir-90/ruv_frontend.git
	
	public int getCalendario_id() {
		return calendario_id;
	}
	public void setCalendario_id(int calendario_id) {
		this.calendario_id = calendario_id;
	}
<<<<<<< HEAD
	
	public String getCalendario_desce() {
		return calendario_desce;
	}
	public void setCalendario_desce(String calendario_desce) {
		this.calendario_desce = calendario_desce;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	@Override
	public String toString() {
		return "CalendarioModel [id=" + calendario_id + ", calendarioDescripcion=" + calendario_desce + ", fechaInicio="
				+ fecha_inicio + ", fechaFin=" + fecha_fin + "]";
	}

	public CalendarioModel(int id,String calendarioDescripcion,Date fechaInicio,Date fechaFin) {}
=======

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
	public CalendarioModel(int id,String calendarioDescripcion,Date fechaInicio,Date fechaFin) {
		this.id=id;
		this.calendarioDescripcion=calendarioDescripcion;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
	}
>>>>>>> branch 'master' of https://github.com/matiasir-90/ruv_frontend.git
}
