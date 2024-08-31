package com.javanauta.usuario.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "endereco_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoEntity {

    @Id
    private String id;
    private String usuarioId;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String cep;
}
