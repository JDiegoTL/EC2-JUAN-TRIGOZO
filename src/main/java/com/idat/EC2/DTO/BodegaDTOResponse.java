package com.idat.EC2.DTO;

public class BodegaDTOResponse {

	private int id;
	private String nombreBodega;
	private String direcciónBodega;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreBodega() {
		return nombreBodega;
	}
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	public String getDirecciónBodega() {
		return direcciónBodega;
	}
	public void setDirecciónBodega(String direcciónBodega) {
		this.direcciónBodega = direcciónBodega;
	}
}
