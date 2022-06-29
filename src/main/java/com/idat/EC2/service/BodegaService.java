package com.idat.EC2.service;

import java.util.List;

import com.idat.EC2.DTO.BodegaDTORequest;
import com.idat.EC2.DTO.BodegaDTOResponse;
import com.idat.EC2.model.Bodega;

public interface BodegaService {

	void guardarBodega(BodegaDTORequest bodega);
	void actualizarBodega(BodegaDTORequest bodega);
	void eliminarBodega(Integer id);
	List<BodegaDTOResponse> listarBodega();
	BodegaDTOResponse obtenerBodegaId(Integer id);
}
