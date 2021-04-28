package com.jrodrigues.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jrodrigues.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

}
