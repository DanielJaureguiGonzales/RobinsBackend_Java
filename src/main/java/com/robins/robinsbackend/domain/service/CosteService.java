package com.robins.robinsbackend.domain.service;

import com.robins.robinsbackend.domain.model.Coste;
import com.robins.robinsbackend.resource.CosteResource;
import com.robins.robinsbackend.resource.SaveCosteResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CosteService {

    List<CosteResource> getAll() throws Exception;
    CosteResource getById(Long id) throws Exception;
    CosteResource createCoste(SaveCosteResource saveCosteResource) throws Exception;
    /*CosteResource updateCoste(SaveCosteResource saveCosteResource,Long id) throws Exception;*/
    String deleteCoste(Long id) throws Exception;
}
