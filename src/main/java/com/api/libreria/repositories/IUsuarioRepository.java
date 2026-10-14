package com.api.libreria.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.libreria.models.UsuarioModel;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    ArrayList<UsuarioModel> findByCorreo(String correo);
    ArrayList<UsuarioModel> findByNombre(String nombre);
}
