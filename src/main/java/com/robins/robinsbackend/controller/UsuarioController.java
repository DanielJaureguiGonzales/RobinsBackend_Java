package com.robins.robinsbackend.controller;


import com.robins.robinsbackend.domain.service.UsuarioService;
import com.robins.robinsbackend.exception.RobinsResponse;
import com.robins.robinsbackend.resource.SaveUsuarioResource;
import com.robins.robinsbackend.resource.UsuarioResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    RobinsResponse<List<UsuarioResource>> getAllUsers() throws Exception{
        return new RobinsResponse<>("200","Lista of Usuarios" , usuarioService.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    RobinsResponse<UsuarioResource> getUser(@PathVariable Long id) throws Exception{
        return new RobinsResponse<>("200","Usuario consultado" , usuarioService.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    RobinsResponse<UsuarioResource> createUser(@RequestBody @Valid SaveUsuarioResource saveUsuarioResource) throws Exception{
        return new RobinsResponse<>("200","Usuario creado" , usuarioService.createUsuario(saveUsuarioResource));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    RobinsResponse<UsuarioResource> updateUser(@RequestBody @Valid SaveUsuarioResource saveUsuarioResource,@PathVariable Long id) throws Exception{
        return new RobinsResponse<>("200","Usuario actualizado" , usuarioService.updateUsuario(saveUsuarioResource,id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    RobinsResponse<String> deleteUser(@RequestParam Long id) throws Exception{
        return new RobinsResponse<>("200","Usuario borrado" , usuarioService.deleteUsuario(id));
    }
}
