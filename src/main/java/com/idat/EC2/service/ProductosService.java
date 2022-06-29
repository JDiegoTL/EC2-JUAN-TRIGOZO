package com.idat.EC2.service;

import java.util.List;

import com.idat.EC2.DTO.ProductosDTORequest;
import com.idat.EC2.DTO.ProductosDTOResponse;
import com.idat.EC2.model.Productos;

public interface ProductosService {

	void guardarProductos(ProductosDTORequest producto);
	void actualizarProductos(ProductosDTORequest producto);
	void eliminarProductos(Integer id);
	List<ProductosDTOResponse> listarProductos();
	ProductosDTOResponse obtenerProductosId(Integer id);
}
