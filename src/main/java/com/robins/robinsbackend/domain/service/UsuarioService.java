package com.robins.robinsbackend.domain.service;


import com.robins.robinsbackend.resource.SaveUsuarioResource;
import com.robins.robinsbackend.resource.UsuarioResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResource> getAll() throws Exception;
    UsuarioResource getById(Long id) throws Exception;
    UsuarioResource createUsuario(SaveUsuarioResource saveUsuarioResource) throws Exception;
    UsuarioResource updateUsuario(SaveUsuarioResource saveUsuarioResource,Long id) throws Exception;
    String deleteUsuario(Long id) throws Exception;

}
