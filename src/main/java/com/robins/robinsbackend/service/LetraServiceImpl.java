package com.robins.robinsbackend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.robins.robinsbackend.domain.model.Coste;
import com.robins.robinsbackend.domain.model.Usuario;
import com.robins.robinsbackend.domain.repository.CosteRepository;
import com.robins.robinsbackend.domain.repository.UsuarioRepository;
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
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	CosteRepository costeRepository;

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<LetraResource> getAll() throws Exception {
		final List<Letra> letras = letraRepository.findAll();
		return letras.stream().map(service -> modelMapper.map(service, LetraResource.class))
				.collect(Collectors.toList());
	}

	@Override
	public LetraResource getById(Long id) throws Exception {
		final Letra letra = letraRepository.findById(id).orElseThrow(() -> new Exception("Letra_id_no_encontrado"));
		return modelMapper.map(letra, LetraResource.class);
	}

	@Override
	public LetraResource createLetra(SaveLetraResource saveLetraResource) throws Exception {
		Usuario usuario = usuarioRepository.findById(saveLetraResource.getUsuarioId()).orElseThrow(()->new Exception("Usuario no encontrado"));
		Letra letra = new Letra();
		letra.setFechadescuento(saveLetraResource.getFechadescuento());
		letra.setDiasPorAnho(saveLetraResource.getDiasPorAnho());
		letra.setFechaVencimiento(saveLetraResource.getFechaVencimiento());
		letra.setFechaGiro(saveLetraResource.getFechaGiro());
		letra.setFechadescuento(saveLetraResource.getFechadescuento());
		letra.setPeriodoCapital(saveLetraResource.getPeriodoCapital());
		letra.setRetencion(saveLetraResource.getRetencion());
		letra.setPlazoTasa(saveLetraResource.getPlazoTasa());
		letra.setPorcentajeTasa(saveLetraResource.getPorcentajeTasa());
		letra.setTipoMoneda(saveLetraResource.getTipoMoneda());
		letra.setTipoTasa(saveLetraResource.getTipoTasa());
		letra.setValorNominal(saveLetraResource.getValorNominal());
		letra.setUsuario(usuario);
		try {
			letra = letraRepository.save(letra);
			System.out.println("Letra creada");
		} catch (Exception e) {
			throw new Exception("Internal Server error");
		}

		return modelMapper.map(letra, LetraResource.class);
	}


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

	@Override
	public LetraResource Calcular(Long letra_id) throws Exception {

		Letra letra = letraRepository.findById(letra_id).orElseThrow(() -> new Exception("Letra_id_no_encontrada"));
		LetraResource letraResource = modelMapper.map(letra,LetraResource.class);
		List<Coste> costes = costeRepository.findAllByLetra_Id(letra_id);
		float ci = 0;
		float cf = 0;

		// Calcular el 'ci' total y 'cf' total de los costes de la letra correspondiente
		for(Coste coste:costes){
			if (!(coste.getTipo())){
				if (!(coste.getValorExpresado())){
					ci = ci+coste.getMonto();
				}else {
					ci = ci + (letra.getValorNominal()*(coste.getMonto()/100));
				}
			}else {
				if (!(coste.getValorExpresado())){
					cf = cf+coste.getMonto();
				}else {
					cf = cf + (letra.getValorNominal()*(coste.getMonto()/100));
				}
			}
		}
		if (!(letra.getTipoTasa())) {
			Double tasa_descuento=tasa_efectiva_descuento(letra.getPlazoTasa(),letra.getPorcentajeTasa(),letra.getFechadescuento(),letra.getFechaVencimiento());

			Float descuento = (float)(letraResource.getValorNominal()*tasa_descuento);
			letraResource.setDescuento(descuento);

			Float valor_neto = letraResource.getValorNominal()-descuento;

			Float valor_recibido= (float)(valor_neto - ci - letraResource.getRetencion());

			letraResource.setValor_recibido(valor_recibido);

			/*
				Porsia si sacan la TCEA DE CADA UNO
			*/

			Float valor_entregado = (float)(letraResource.getValorNominal()+cf-letraResource.getRetencion());
			System.out.println(valor_entregado);
			long startTime = letra.getFechadescuento().getTime();
			long endTime = letra.getFechaVencimiento().getTime();
			long diffTime = endTime-startTime;
			float tiempo = (float) TimeUnit.DAYS.convert(diffTime,TimeUnit.MILLISECONDS);
			Float TCEA = (float)(Math.pow((valor_entregado/valor_recibido),(letraResource.getDiasPorAnho()/tiempo))-1);
			letraResource.setTCEA(TCEA*100);

		}else {
			Double tasa_descuento=tasa_nominal(letra.getPlazoTasa(),letra.getPorcentajeTasa(),letra.getFechadescuento(),letra.getFechaVencimiento(),letra.getPeriodoCapital());
			Float descuento = (float)(letraResource.getValorNominal()*tasa_descuento);
			letraResource.setDescuento(descuento);

			Float valor_neto = letraResource.getValorNominal()-descuento;

			Float valor_recibido= (float)(valor_neto - ci - letraResource.getRetencion());

			letraResource.setValor_recibido(valor_recibido);

			/*
				Porsia si sacan la TCEA DE CADA UNO
			*/

			Float valor_entregado = (float)(letraResource.getValorNominal()+cf-letraResource.getRetencion());
			long startTime = letra.getFechadescuento().getTime();
			long endTime = letra.getFechaVencimiento().getTime();
			long diffTime = endTime-startTime;
			float tiempo = (float) TimeUnit.DAYS.convert(diffTime,TimeUnit.MILLISECONDS);
			Float TCEA = (float)(Math.pow((-(valor_entregado)/valor_recibido),(letraResource.getDiasPorAnho()/tiempo))-1);
			letraResource.setTCEA(TCEA*100);
		}

		letra= modelMapper.map(letraResource,Letra.class);

		try {
			letraRepository.save(letra);
		}catch (Exception e){
			throw new Exception("Internal Server Error");
		}
		return letraResource;
	}

	public Double tasa_efectiva_descuento(Integer PlazoTasa, Float porcentajeTasa, Date fechaDescuento, Date fechaVencimiento){

		//Operaciones
		long startTime = fechaDescuento.getTime();
		long endTime = fechaVencimiento.getTime();
		long diffTime = endTime-startTime;
		int tiempo = (int) TimeUnit.DAYS.convert(diffTime,TimeUnit.MILLISECONDS);
		Double tep2 = convertirTEP1aTEP2(porcentajeTasa,PlazoTasa,tiempo);
		Double tasa_descuento = tasa_descuento(tep2);
		return tasa_descuento;
	}
	public Double tasa_nominal(Integer PlazoTasa, Float porcentajeTasa, Date fechaDescuento, Date fechaVencimiento, Integer periodoCapital){
		//Operaciones
		long startTime = fechaDescuento.getTime();
		long endTime = fechaVencimiento.getTime();
		long diffTime = endTime-startTime;
		int tiempo = (int) TimeUnit.DAYS.convert(diffTime,TimeUnit.MILLISECONDS);
		float a= PlazoTasa/periodoCapital;
		float b= tiempo/periodoCapital;
		Double tep = convertirTNPaTEP(porcentajeTasa,a,b);
		Double tasa_descuento = tasa_descuento(tep);
		return tasa_descuento;
	}

	public double convertirTNPaTEP(Float tn,float n1,float n2){
		Double tep=(double)((Math.pow(1+((tn/100)/n1),n2)-1));
		return tep;
	}

	public double convertirTEP1aTEP2(Float tep1,float n1,float n2){
		Double tep2=(double)((Math.pow(1+(tep1/100),(n2/n1))-1));
		return tep2;
	}

	public Double tasa_descuento(Double tep2){
		Double TD = (tep2)/(1+tep2);
		return TD;
	}
}
