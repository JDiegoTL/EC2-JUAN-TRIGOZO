package com.idat.EC2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.EC2.DTO.BodegaDTORequest;
import com.idat.EC2.DTO.BodegaDTOResponse;
import com.idat.EC2.model.Bodega;
import com.idat.EC2.repository.BodegaRepository;

public class BodegaServiceImpl implements BodegaService{

	@Autowired
	private BodegaRepository repository;
	
	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setNombre(bodega.getNombreBodega());
		b.setDirección(bodega.getDirecciónBodega());
		
		repository.save(b);
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setIdBodega(bodega.getId());
		b.setNombre(bodega.getNombreBodega());
		b.setDirección(bodega.getDirecciónBodega());
		
		repository.saveAndFlush(b);
	}

	@Override
	public void eliminarBodega(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {

		List<BodegaDTOResponse> listar = new ArrayList<>();
		
		BodegaDTOResponse dto = null;
		
		List<Bodega> b = repository.findAll();
		
		for(Bodega bodega:b) {
			
			dto = new BodegaDTOResponse();
			
			dto.setNombreBodega(bodega.getNombre());
			dto.setDirecciónBodega(bodega.getDirección());
			dto.setId(bodega.getIdBodega());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		
		Bodega bodega = repository.findById(id).orElse(null);
		BodegaDTOResponse dto = new BodegaDTOResponse();
		
		dto.setNombreBodega(bodega.getNombre());
		dto.setDirecciónBodega(bodega.getDirección());
		dto.setId(bodega.getIdBodega());
		
		return dto;
	}

}
