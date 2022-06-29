package com.pppeludos.datosperros.repository;

import com.pppeludos.datosperros.entity.DatosPerros;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DatosPerrosRepository extends JpaRepository<DatosPerros, Integer> {

	Optional<DatosPerros> findByidDatosPerros(String nombre);

	boolean existsByidDatosPerros(String nombre);
}
