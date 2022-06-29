package com.pppeludos.datosperros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pppeludos.datosperros.dto.DatosPerrosDto;
import com.pppeludos.datosperros.dto.Mensaje;
import com.pppeludos.datosperros.entity.DatosPerros;
import com.pppeludos.datosperros.service.DatosPerrosService;

@RestController
@RequestMapping("/datosperros")
@CrossOrigin(origins = "http://localhost:4200")
public class DatosPerrosController {

    @Autowired
    DatosPerrosService datosPerrosService;

    @GetMapping("/listaDatosPerros")
    public ResponseEntity<List<DatosPerros>> listaDatosPerross(){

        List<DatosPerros> datosPerross = datosPerrosService.listaDatosPerros();
        return new ResponseEntity<List<DatosPerros>>(datosPerross, HttpStatus.OK);
    }

    @GetMapping("/detalleDatosPerros/{numero_chip}")
    public ResponseEntity<Object> datosPerrosById(@PathVariable("numero_chip") int numero_chip){

        if (!datosPerrosService.existsByIdDatosPerros(numero_chip))
            return new ResponseEntity<Object>(new Mensaje("El PPPeludo no existe en la BBDD"), HttpStatus.NOT_FOUND);

        boolean datosPerros = datosPerrosService.existsByIdDatosPerros(numero_chip);
        return new ResponseEntity<Object>(datosPerros, HttpStatus.OK);
    }
    
    @GetMapping("/detalleNombre/{nombreDatosPerros}")
    public ResponseEntity<Object> datosPerrosByNombre(@PathVariable("nombre") String nombre){

        if (!datosPerrosService.existsByNombreDatosPerros(nombre))
            return new ResponseEntity<Object>(new Mensaje("El PPPeludo no existe en la BBDD"), HttpStatus.NOT_FOUND);

        DatosPerros datosPerros = datosPerrosService.getByNombreDatosPerros(nombre).get();
        return new ResponseEntity<Object>(datosPerros, HttpStatus.OK);
    }

    //Con el ? le decimos que no devulve ningún tipo de dato
    //El body va a ser un JSON
    //Aqui se usa el apache commons lang
    // El import de StringUtils es import org.apache.commons.lang3.StringUtils;
   
    
   
	@PostMapping("/crearDatosPerros")
    public ResponseEntity<?> creaDatosPerros(@RequestBody DatosPerrosDto datosPerrosDto){


        if(datosPerrosService.existsByIdDatosPerros(datosPerrosDto.getNumero_chip()))
            return new ResponseEntity<Object>(new Mensaje("Ya existe una pppeludo con ese Nº de chip"), HttpStatus.BAD_REQUEST);
  
        DatosPerros datosPerros = new DatosPerros(datosPerrosDto.getIdDatosPerros(), datosPerrosDto.getFoto(),datosPerrosDto.getNombre(), datosPerrosDto.getDonde_esta(),datosPerrosDto.getNumero_chip(),datosPerrosDto.getFecha_nacimiento(),datosPerrosDto.getLicencia(),datosPerrosDto.getRaza(),datosPerrosDto.getCastrado(),datosPerrosDto.getUltima_desparasitacion(),datosPerrosDto.getVacuna_rabia(),datosPerrosDto.getLeishmaniasis(),datosPerrosDto.getPendiente_operacion(),datosPerrosDto.getEnfermedades(),datosPerrosDto.getTratamiento());
        datosPerrosService.saveDatosPerros(datosPerros);
        return new ResponseEntity<Object>(new Mensaje("¡¡¡Bienvenido " + datosPerrosDto.getNombre() + "!!!"), HttpStatus.OK);
        
    }



	@PutMapping("/actualizarDatosPerros/{idDatosPerros}")
	public ResponseEntity<?> actualizarDatosPerros(@PathVariable("idDatosPerros") int idDatosPerros,
			@RequestBody DatosPerrosDto datosPerrosDto) {

		DatosPerros datosPerros = datosPerrosService.getDatosPerros(idDatosPerros).get();

		if (datosPerros.getIdDatosPerros() == datosPerrosDto.getIdDatosPerros()) {

			if (datosPerros.getFoto() != datosPerrosDto.getFoto()) {
				datosPerros.setFoto(datosPerrosDto.getFoto());
			}
			if (datosPerros.getNombre() != datosPerrosDto.getNombre()) {
				datosPerros.setNombre(datosPerrosDto.getNombre());
			}
			if (datosPerros.getDonde_esta() != datosPerrosDto.getDonde_esta()) {
				datosPerros.setDonde_esta(datosPerrosDto.getDonde_esta());
			}
			if (datosPerros.getNumero_chip() != datosPerrosDto.getNumero_chip()) {
				datosPerros.setNumero_chip(datosPerrosDto.getNumero_chip());
			}
			if (datosPerros.getFecha_nacimiento() != datosPerrosDto.getFecha_nacimiento()) {
				datosPerros.setFecha_nacimiento(datosPerrosDto.getFecha_nacimiento());
			}
			if (datosPerros.getLicencia() != datosPerrosDto.getLicencia()) {
				datosPerros.setLicencia(datosPerrosDto.getLicencia());
			}
			if (datosPerros.getRaza() != datosPerrosDto.getRaza()) {
				datosPerros.setRaza(datosPerrosDto.getRaza());
			}
			if (datosPerros.getCastrado() != datosPerrosDto.getCastrado()) {
				datosPerros.setCastrado(datosPerrosDto.getCastrado());
			}
			if (datosPerros.getUltima_desparasitacion() != datosPerrosDto.getUltima_desparasitacion()) {
				datosPerros.setUltima_desparasitacion(datosPerrosDto.getUltima_desparasitacion());
			}
			if (datosPerros.getVacuna_rabia() != datosPerrosDto.getVacuna_rabia()) {
				datosPerros.setVacuna_rabia(datosPerrosDto.getVacuna_rabia());
			}
			if (datosPerros.getLeishmaniasis() != datosPerrosDto.getLeishmaniasis()) {
				datosPerros.setLeishmaniasis(datosPerrosDto.getLeishmaniasis());
			}
			if (datosPerros.getPendiente_operacion() != datosPerrosDto.getPendiente_operacion()) {
				datosPerros.setPendiente_operacion(datosPerrosDto.getPendiente_operacion());
			}
			if (datosPerros.getEnfermedades() != datosPerrosDto.getEnfermedades()) {
				datosPerros.setEnfermedades(datosPerrosDto.getEnfermedades());
			}
			if (datosPerros.getTratamiento() != datosPerrosDto.getTratamiento()) {
				datosPerros.setTratamiento(datosPerrosDto.getTratamiento());
			}
			datosPerrosService.saveDatosPerros(datosPerros);
			return new ResponseEntity<Object>(
					new Mensaje("Los datos de " + datosPerrosDto.getNombre() + " han sido actualizados"), HttpStatus.OK);
		} else {

			return new ResponseEntity<Object>(
					new Mensaje(
							"Ha ocurrido un error, no se pueden actualizar los datos de " + datosPerrosDto.getNombre()),
					HttpStatus.NOT_FOUND);
		}

	}

    @DeleteMapping("/borrarDatosPerros/{idDatosPerros}")
    public ResponseEntity<?> borrarDatosPerros(@PathVariable("idDatosPerros") int idDatosPerros){
      
    	if (!datosPerrosService.existsByIdDatosPerros(idDatosPerros))
            return new ResponseEntity<Object>(new Mensaje("El PPPeludito a eliminar no existe en la BBDD"), HttpStatus.NOT_FOUND);
    	
        datosPerrosService.deleteDatosPerros(idDatosPerros);
        return new ResponseEntity<Object>(new Mensaje("Hasta siempre PPPeludito"), HttpStatus.OK);
    }

}
