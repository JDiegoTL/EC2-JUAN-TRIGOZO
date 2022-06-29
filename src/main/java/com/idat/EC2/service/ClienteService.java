package com.idat.EC2.service;

import java.util.List;

import com.idat.EC2.DTO.ClienteDTORequest;
import com.idat.EC2.DTO.ClienteDTOResponse;
import com.idat.EC2.model.Cliente;

public interface ClienteService {

	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarCliente();
	ClienteDTOResponse obtenerClienteId(Integer id);
}
