package com.robins.robinsbackend.service;

import com.robins.robinsbackend.domain.model.Coste;
import com.robins.robinsbackend.domain.repository.CosteRepository;
import com.robins.robinsbackend.domain.repository.LetraRepository;
import com.robins.robinsbackend.domain.service.CosteService;
import com.robins.robinsbackend.resource.CosteResource;
import com.robins.robinsbackend.resource.SaveCosteResource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosteServiceImpl implements CosteService {

    @Autowired
    CosteRepository costeRepository;

    @Autowired
    LetraRepository letraRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CosteResource> getAll() throws Exception {
        final List<Coste> costes = costeRepository.findAll();
        return costes.stream().map(service->modelMapper.map(service,CosteResource.class)).collect(Collectors.toList());
    }

    @Override
    public CosteResource getById(Long id) throws Exception {
        final Coste coste = costeRepository.findById(id).orElseThrow(()-> new Exception("Coste_id_no_encontrado"));
        return modelMapper.map(coste,CosteResource.class);
    }

    @Override
    public CosteResource createCoste(SaveCosteResource saveCosteResource) throws Exception {

        if(!(letraRepository.findById(saveCosteResource.getLetraId()).isPresent())){throw new Exception("LetraId no existe");}
        Coste coste = modelMapper.map(saveCosteResource,Coste.class);
        try{
            coste = costeRepository.save(coste);
            System.out.println("Coste creado");
        }catch (Exception e){
            throw new Exception("Internal Server error");
        }

        return modelMapper.map(coste,CosteResource.class);
    }

    /*@Override
    public CosteResource updateCoste(SaveCosteResource saveCosteResource, Long id) throws Exception {
        return null;
    }*/

    @Override
    public String deleteCoste(Long id) throws Exception {
        Coste coste = costeRepository.findById(id).orElseThrow(()->new Exception("Coste_id_no_encontrado"));
        try {
            costeRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Internal Server Error");
        }
        return "Coste: Borrado";
    }
}
