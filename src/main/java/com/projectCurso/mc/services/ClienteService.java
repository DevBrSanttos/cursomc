package com.projectCurso.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectCurso.mc.domain.Cliente;
import com.projectCurso.mc.repositories.ClienteRepository;
import com.projectCurso.mc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired // automaticamente será instanciado pelo Spring, mecanismo de injeção de dependência
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
										"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Cliente.class.getName()));

	}

}
