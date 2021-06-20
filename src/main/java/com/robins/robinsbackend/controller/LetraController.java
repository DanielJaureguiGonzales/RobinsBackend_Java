package com.robins.robinsbackend.controller;

import com.robins.robinsbackend.domain.service.LetraService;
import com.robins.robinsbackend.exception.RobinsResponse;
import com.robins.robinsbackend.resource.CosteResource;
import com.robins.robinsbackend.resource.LetraResource;

import com.robins.robinsbackend.resource.SaveCosteResource;
import com.robins.robinsbackend.resource.SaveLetraResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/letra")
public class LetraController {

    @Autowired
    LetraService letraService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    RobinsResponse<List<LetraResource>> getAllUsers() throws Exception{
        return new RobinsResponse<>("200","Lista de Letras" , letraService.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    RobinsResponse<LetraResource> getUser(@PathVariable Long id) throws Exception{
        return new RobinsResponse<>("200","Letra consultado" , letraService.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    RobinsResponse<LetraResource> createLetra(@RequestBody @Valid SaveLetraResource saveLetraResource) throws Exception{
        return new RobinsResponse<>("200","Letra registrado" , letraService.createLetra(saveLetraResource));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/calculate/{id}")
    RobinsResponse<LetraResource> calcularLetra(@PathVariable Long id) throws Exception{
        return new RobinsResponse<>("200","Letra calculado" , letraService.Calcular(id));
    }

}
