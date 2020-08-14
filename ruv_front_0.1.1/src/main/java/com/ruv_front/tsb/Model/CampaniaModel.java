package com.ruv_front.tsb.Model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;




public class CampaniaModel {

	public CampaniaModel() {}
	
	private int campania_id;
	private String campania_desce;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate fecha_alta;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate fecha_baja;
	
	public int getCampania_id() {
		return campania_id;
	}
	public void setCampania_id(int campania_id) {
		this.campania_id = campania_id;
	}
	
	public String getcampania_desce() {
		return campania_desce;
	}
	public void setCampania_desce(String campania_desce) {
		this.campania_desce = campania_desce;
	}

	public LocalDate getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_inicio(LocalDate fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public LocalDate getFecha_baja() {
//		SimpleDateFormat fecha_fin = new SimpleDateFormat("dd/MM/yyyy");
		
		return fecha_baja;
	}
	public void setFecha_baja(LocalDate fecha_baja) {
		this.fecha_baja = fecha_baja;
	}


	@Override
	public String toString() {
		return "CampaniaModel [id=" + campania_id + ", campaniaDescripcion=" + campania_desce + ", fechaInicio="
				+ fecha_alta + ", fechaFin=" + fecha_baja + "]";
	}
}
