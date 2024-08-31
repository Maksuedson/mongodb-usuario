package com.javanauta.usuario.repository;

import com.javanauta.usuario.entity.EnderecoEntity;
import com.javanauta.usuario.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<EnderecoEntity, String> {
    EnderecoEntity findByUsuarioId(String usuarioId);
    void deleteByUsuarioId(String usuarioId);
}
