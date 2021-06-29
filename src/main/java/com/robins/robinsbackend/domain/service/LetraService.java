package com.robins.robinsbackend.domain.service;

import java.util.List;

import com.robins.robinsbackend.resource.LetraResource;
import com.robins.robinsbackend.resource.SaveLetraResource;

public interface LetraService {
	List<LetraResource> getAll() throws Exception;
	LetraResource getById(Long id) throws Exception;
	LetraResource createLetra(SaveLetraResource saveLetraResource) throws Exception;
	LetraResource Calcular(Long id) throws Exception;

	String deleteLetra(Long id) throws Exception;
}
