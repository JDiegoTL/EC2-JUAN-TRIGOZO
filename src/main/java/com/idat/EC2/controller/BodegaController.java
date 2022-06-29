package com.idat.EC2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC2.DTO.BodegaDTORequest;
import com.idat.EC2.DTO.BodegaDTOResponse;
import com.idat.EC2.service.BodegaService;

public class BodegaController {

	@Controller
	@RequestMapping( path = "/bodega/v1")
	public class ProductoController {

		@Autowired
		private BodegaService service;
		
		@RequestMapping("/listar")
		public @ResponseBody ResponseEntity<List<BodegaDTOResponse>>  listar() {
			
			return new ResponseEntity<List<BodegaDTOResponse>>(service.listarBodega(), HttpStatus.OK) ;
		}
		
		@RequestMapping( path = "/guardar", method = RequestMethod.POST)
		public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bodega) {
			service.guardarBodega(bodega);
			return  new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}

		@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
			BodegaDTOResponse p =service.obtenerBodegaId(id);
			if(p != null) {
				service.eliminarBodega(id);
				return  new ResponseEntity<Void>(HttpStatus.OK);
			}
			return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
		public ResponseEntity<Void> actualizar(@RequestBody BodegaDTORequest bodega) {
			BodegaDTOResponse p =service.obtenerBodegaId(bodega.getId());
			if(p != null) {
				service.actualizarBodega(bodega);;
				return  new ResponseEntity<Void>(HttpStatus.OK);
			}
			return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
		public ResponseEntity<BodegaDTOResponse> obtenerId(@PathVariable Integer id) {
			BodegaDTOResponse p =service.obtenerBodegaId(id);
			if(p != null) {
				return  new ResponseEntity<BodegaDTOResponse>(service.obtenerBodegaId(id),HttpStatus.OK);
			}
			return  new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
}
