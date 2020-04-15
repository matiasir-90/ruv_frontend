package com.ruv_front.tsb.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;




public class CalendarioModel {

	public CalendarioModel() {}
	
	private int calendario_id;

	private String calendario_desce;
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private java.sql.Date fecha_inicio;
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	private java.sql.Date fecha_fin;
	
	public int getCalendario_id() {
		return calendario_id;
	}
	public void setCalendario_id(int calendario_id) {
		this.calendario_id = calendario_id;
	}
	
	public String getCalendario_desce() {
		return calendario_desce;
	}
	public void setCalendario_desce(String calendario_desce) {
		this.calendario_desce = calendario_desce;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(java.sql.Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
//		SimpleDateFormat fecha_fin = new SimpleDateFormat("dd/MM/yyyy");
		
		return fecha_fin;
	}
	public void setFecha_fin(java.sql.Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	@Override
	public String toString() {
		return "CalendarioModel [id=" + calendario_id + ", calendarioDescripcion=" + calendario_desce + ", fechaInicio="
				+ fecha_inicio + ", fechaFin=" + fecha_fin + "]";
	}
}
