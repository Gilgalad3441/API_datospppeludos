package com.pppeludos.datosperros.service;

import com.pppeludos.datosperros.entity.DatosPerros;
import com.pppeludos.datosperros.repository.DatosPerrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DatosPerrosService {

	@Autowired
	DatosPerrosRepository datosperrosRepository;

	public List<DatosPerros> listaDatosPerros() {
		return datosperrosRepository.findAll();
	}

	public Optional<DatosPerros> getDatosPerros(int numero_chip) {
		return datosperrosRepository.findById(numero_chip);
	}

	public Optional<DatosPerros> getByNombreDatosPerros(String nombre) {
		return datosperrosRepository.findByidDatosPerros(nombre);
	}

	public void saveDatosPerros(DatosPerros datosperros) {
		datosperrosRepository.save(datosperros);
	}

	public void deleteDatosPerros(int numero_chip) {
		datosperrosRepository.deleteById(numero_chip);
	}

	public boolean existsByIdDatosPerros(int numero_chip) {
		return datosperrosRepository.existsById(numero_chip);
	}

	public boolean existsByNombreDatosPerros(String nombre) {
		return datosperrosRepository.existsByidDatosPerros(nombre);
	}

}
