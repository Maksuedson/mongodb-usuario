package com.javanauta.usuario.repository;

import com.javanauta.usuario.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    UsuarioEntity findByEmail(String email);
    void deleteByEmail(String email);
}
