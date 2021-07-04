package com.projectCurso.mc.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectCurso.mc.domain.Categoria;
import com.projectCurso.mc.repositories.CategoriaRepository;
import com.projectCurso.mc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired // automaticamente será instanciado pelo Spring, mecanismo de injeção de dependência
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
										"Objeto não encontrado! Id: "+ id + ", Tipo: "+ Categoria.class.getName()));

	}

}
