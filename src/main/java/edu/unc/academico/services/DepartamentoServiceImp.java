package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImp implements DepartamentoService {

	//Injeccion de dependencia para manipular los dptos;
	@Autowired
	private DepartamentoRepository dptRep;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Departamento> listarDptos() {
		return (List<Departamento>)dptRep.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Departamento> buscarPorIdDpto(Long idDpto) {
		return dptRep.findById(idDpto);
	}

	@Override
	public Departamento grabarDpto(Departamento dpto) {
		return dptRep.save(dpto);
	}

	@Override
	public void eliminarDpto(Long idDpto) {
		dptRep.deleteById(idDpto);
	}

}
