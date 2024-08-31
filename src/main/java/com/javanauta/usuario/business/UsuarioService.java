package com.javanauta.usuario.business;

import com.javanauta.usuario.api.converter.UsuarioConverter;
import com.javanauta.usuario.api.converter.UsuarioMapper;
import com.javanauta.usuario.api.request.UsuarioRequestDTO;
import com.javanauta.usuario.api.response.UsuarioResponseDTO;
import com.javanauta.usuario.entity.EnderecoEntity;
import com.javanauta.usuario.entity.UsuarioEntity;
import com.javanauta.usuario.infraestrutura.BusinessException;
import com.javanauta.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private  final UsuarioConverter usuarioConverter;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final EnderecoService enderecoService;

    public UsuarioEntity salvaUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public UsuarioResponseDTO gravarUsuarios(UsuarioRequestDTO usuarioRequestDTO){
        try {
            notNull(usuarioRequestDTO, "Os dados do usuário são obrigatórios");
            UsuarioEntity usuarioEntity = salvaUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            EnderecoEntity enderecoEntity = enderecoService.salvaEndereco(
                    usuarioConverter.paraEnderecoEntity(usuarioRequestDTO.getEndereco(), usuarioEntity.getId())
            );
            return usuarioMapper.paraUsuarioResponseDTO(usuarioEntity, enderecoEntity);
        }catch (Exception e){
            throw new BusinessException("Erro ao gravar dados de usuário", e);
        }
    }
}
