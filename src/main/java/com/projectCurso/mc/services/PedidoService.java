package com.projectCurso.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectCurso.mc.domain.Pedido;
import com.projectCurso.mc.repositories.PedidoRepository;
import com.projectCurso.mc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired // automaticamente será instanciado pelo Spring, mecanismo de injeção de dependência
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
										"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Pedido.class.getName()));

	}

}
