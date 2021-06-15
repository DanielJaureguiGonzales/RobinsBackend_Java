package com.robins.robinsbackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robins.robinsbackend.domain.model.Letra;
import com.robins.robinsbackend.domain.repository.LetraRepository;
import com.robins.robinsbackend.domain.service.LetraService;
import com.robins.robinsbackend.resource.LetraResource;
import com.robins.robinsbackend.resource.SaveLetraResource;

@Service
public class LetraServiceImpl implements LetraService {
	@Autowired
	LetraRepository letraRepository;

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<LetraResource> getAll() throws Exception {
		final List<Letra> letras = letraRepository.findAll();
		return letras.stream().map(service -> modelMapper.map(service, LetraResource.class))
				.collect(Collectors.toList());
	}

	@Override
	public LetraResource getById(Long id) throws Exception {
		final Letra letra = letraRepository.findById(id).orElseThrow(() -> new Exception("Usuario_id_no_encontrado"));
		return modelMapper.map(letra, LetraResource.class);
	}

	@Override
	public LetraResource createLetra(SaveLetraResource saveLetraResource) throws Exception {
		Letra letra = modelMapper.map(saveLetraResource, Letra.class);
		try {
			letra = letraRepository.save(letra);
			System.out.println("Letra creada");
		} catch (Exception e) {
			throw new Exception("Internal Server error");
		}

		return modelMapper.map(letra, LetraResource.class);
	}

	/*@Override
	public LetraResource updateLetra(SaveLetraResource saveLetraResource, Long id) throws Exception {
		Letra letra = letraRepository.findById(id).orElseThrow(() -> new Exception("Letra_id_no_encontrado"));
		letra.setDiasPorAnho(saveLetraResource.getDiasPorAnho());
		letra.setPlazoTasa(saveLetraResource.getPlazoTasa());
		letra.setTipoTasa(saveLetraResource.getTipoTasa());
		letra.setPorcentajeTasa(saveLetraResource.getPorcentajeTasa());
		letra.setPeriodoCapital(saveLetraResource.getPeriodoCapital());
		letra.setFechaDescuento(saveLetraResource.getFechaDescuento());
		letra.setFechaGiro(saveLetraResource.getFechaGiro());
		letra.
		
		try {
			usuario = usuarioRepository.save(usuario);
			System.out.println("Usuario actualizado");
		} catch (Exception e) {
			throw new Exception("Internal Server error");
		}

		return modelMapper.map(usuario, UsuarioResource.class);
	}*/

	@Override
	public String deleteLetra(Long id) throws Exception {
		Letra letra = letraRepository.findById(id).orElseThrow(()->new Exception("Letra_id_no_encontrado"));
        try {
            letraRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("Internal Server Error");
        }
        return "Letra borrada";
	}
	
	/*public float Calcular(){
		return null;}*/

}
