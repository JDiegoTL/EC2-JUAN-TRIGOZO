package com.idat.EC2.DTO;

public class ProductosDTORequest {

	private int id;
	private String productos;
	private String descripcionProductos;
	private double precioProductos;
	private int stockProductos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
	}
	public String getDescripcionProductos() {
		return descripcionProductos;
	}
	public void setDescripcionProductos(String descripcionProductos) {
		this.descripcionProductos = descripcionProductos;
	}
	public double getPrecioProductos() {
		return precioProductos;
	}
	public void setPrecioProductos(double precioProductos) {
		this.precioProductos = precioProductos;
	}
	public int getStockProductos() {
		return stockProductos;
	}
	public void setStockProductos(int stockProductos) {
		this.stockProductos = stockProductos;
	}
	
	
}
