package com.robins.robinsbackend.controller;

import com.robins.robinsbackend.domain.service.CosteService;
import com.robins.robinsbackend.exception.RobinsResponse;
import com.robins.robinsbackend.resource.SaveCosteResource;
import com.robins.robinsbackend.resource.CosteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/coste")
public class CosteController {

    @Autowired
    CosteService costeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    RobinsResponse<List<CosteResource>> getAllCostes() throws Exception{
        return new RobinsResponse<>("200","Lista de Costes" , costeService.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    RobinsResponse<CosteResource> getCoste(@PathVariable Long id) throws Exception{
        return new RobinsResponse<>("200","Coste consultado" , costeService.getById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create")
    RobinsResponse<CosteResource> createCoste(@RequestBody @Valid SaveCosteResource saveCosteResource) throws Exception{
        return new RobinsResponse<>("200","Coste creado" , costeService.createCoste(saveCosteResource));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    RobinsResponse<String> deleteCoste(@RequestParam Long id) throws Exception{
        return new RobinsResponse<>("200","Coste borrado" , costeService.deleteCoste(id));
    }

}
