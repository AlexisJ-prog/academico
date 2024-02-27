package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.repository.InvestigadorRepository;

@Service
public class InvestigadorServiceImp implements InvestigadorService {
	
	//Para invercion de dependencia de Spring
	//invRep es el objeto que tiene acceso a la base de datos
	@Autowired
	private InvestigadorRepository invRep;

	@Override
	@Transactional(readOnly = true)
	public List<Investigador> listarInv() {
		return (List<Investigador>)invRep.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Investigador> buscarPorIdInv(Long idInv) {
		return invRep.findById(idInv);
	}

	@Override
	public Investigador grabarInv(Investigador inv) {
		return invRep.save(inv);
	}

	@Override
	public void eliminarInv(Long idInv) {
		invRep.deleteById(idInv);
	}

}
