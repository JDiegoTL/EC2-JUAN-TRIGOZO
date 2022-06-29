package com.idat.EC2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.EC2.DTO.ProductosDTORequest;
import com.idat.EC2.DTO.ProductosDTOResponse;
import com.idat.EC2.model.Productos;
import com.idat.EC2.repository.ProductosRepository;

public class ProductosServiceImpl implements ProductosService{

	@Autowired
	private ProductosRepository repository;
	
	@Override
	public void guardarProductos(ProductosDTORequest producto) {
		Productos p = new Productos();
		p.setProducto(producto.getProductos());
		p.setDescripcion(producto.getDescripcionProductos());
		p.setPrecio(producto.getPrecioProductos());
		p.setStock(producto.getStockProductos());
		
		repository.save(p);
	}

	@Override
	public void actualizarProductos(ProductosDTORequest producto) {
		Productos p = new Productos();
		p.setIdProductos(producto.getId());
		p.setProducto(producto.getProductos());
		p.setDescripcion(producto.getDescripcionProductos());
		p.setPrecio(producto.getPrecioProductos());
		p.setStock(producto.getStockProductos());
		
		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarProductos(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ProductosDTOResponse> listarProductos() {
		
		List<ProductosDTOResponse> listar = new ArrayList<>();
		
		ProductosDTOResponse dto = null;
		
		List<Productos> p = repository.findAll();
		
		for(Productos productos:p) {
			
			dto = new ProductosDTOResponse();
			
			dto.setProductos(productos.getProducto());
			dto.setDescripcionProductos(productos.getDescripcion());
			dto.setPrecioProductos(productos.getPrecio());
			dto.setStockProductos(productos.getStock());
			dto.setId(productos.getIdProductos());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ProductosDTOResponse obtenerProductosId(Integer id) {

		Productos productos = repository.findById(id).orElse(null);
		ProductosDTOResponse dto = new ProductosDTOResponse();
		
		dto.setProductos(productos.getProducto());
		dto.setDescripcionProductos(productos.getDescripcion());
		dto.setPrecioProductos(productos.getPrecio());
		dto.setStockProductos(productos.getStock());
		dto.setId(productos.getIdProductos());
		
		return dto;
	}

}
