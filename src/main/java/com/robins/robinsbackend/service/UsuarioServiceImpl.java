package com.robins.robinsbackend.service;

import com.robins.robinsbackend.domain.model.Usuario;
import com.robins.robinsbackend.domain.repository.UsuarioRepository;
import com.robins.robinsbackend.domain.service.UsuarioService;
import com.robins.robinsbackend.exception.RobinsResponse;
import com.robins.robinsbackend.resource.SaveUsuarioResource;
import com.robins.robinsbackend.resource.UsuarioResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UsuarioResource> getAll() throws Exception {
        final List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(service->modelMapper.map(service,UsuarioResource.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResource getById(Long id) throws Exception {
        final Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new Exception("Usuario_id_no_encontrado"));
        return modelMapper.map(usuario,UsuarioResource.class);
    }

    @Override
    public UsuarioResource createUsuario(SaveUsuarioResource saveUsuarioResource)  throws Exception {
        Usuario usuario = modelMapper.map(saveUsuarioResource,Usuario.class);
        try{
            usuario = usuarioRepository.save(usuario);
            System.out.println("Usuario creado");
        }catch (Exception e){
            throw new Exception("Internal Server error");
        }

        return modelMapper.map(usuario,UsuarioResource.class);
    }

    @Override
    public UsuarioResource updateUsuario(SaveUsuarioResource saveUsuarioResource,Long id) throws Exception{

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new Exception("Usuario_id_no_encontrado"));
        usuario.setNombre(saveUsuarioResource.getNombre());
        usuario.setContrasenha(saveUsuarioResource.getContrasenha());
        usuario.setCorreo(saveUsuarioResource.getCorreo());
        usuario.setDni(saveUsuarioResource.getDni());
        usuario.setTelefono(saveUsuarioResource.getTelefono());
        try{
            usuario = usuarioRepository.save(usuario);
            System.out.println("Usuario actualizado");
        }catch (Exception e){
            throw new Exception("Internal Server error");
        }

        return modelMapper.map(usuario,UsuarioResource.class);
    }

    @Override
    public String deleteUsuario(Long id)  throws Exception{
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new Exception("Usuario_id_no_encontrado"));
        try {
            usuarioRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Internal Server Error");
        }
        return "Usuario: Borrado";
    }
}
