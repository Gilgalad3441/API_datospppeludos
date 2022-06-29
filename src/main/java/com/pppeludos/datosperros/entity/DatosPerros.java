package com.pppeludos.datosperros.entity;

import javax.persistence.*;

@Entity
@Table(name = "datosperros")
public class DatosPerros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDatosPerros;
	private String foto;
	private String nombre;
	private String donde_esta;
	private int numero_chip;
	private String fecha_nacimiento;
	private String licencia;
	private String raza;
	private String castrado;
	private String ultima_desparasitacion;
	private String vacuna_rabia;
	private String leishmaniasis;
	private String pendiente_operacion;
	private String enfermedades;
	private String tratamiento;

	public DatosPerros() {
	}

	public DatosPerros(int idDatosPerros, String foto, String nombre, String donde_esta, int numero_chip,
			String fecha_nacimiento, String licencia, String raza, String castrado, String ultima_desparasitacion,
			String vacuna_rabia, String leishmaniasis, String pendiente_operacion, String enfermedades,
			String tratamiento) {
		this.idDatosPerros = idDatosPerros;
		this.foto = foto;
		this.nombre = nombre;
		this.donde_esta = donde_esta;
		this.numero_chip = numero_chip;
		this.fecha_nacimiento = fecha_nacimiento;
		this.licencia = licencia;
		this.raza = raza;
		this.castrado = castrado;
		this.ultima_desparasitacion = ultima_desparasitacion;
		this.vacuna_rabia = vacuna_rabia;
		this.leishmaniasis = leishmaniasis;
		this.pendiente_operacion = pendiente_operacion;
		this.enfermedades = enfermedades;
		this.tratamiento = tratamiento;

	}

	public int getIdDatosPerros() {
		return idDatosPerros;
	}

	public void setIdDatosPerros(int idDatosPerros) {
		this.idDatosPerros = idDatosPerros;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDonde_esta() {
		return donde_esta;
	}

	public void setDonde_esta(String donde_esta) {
		this.donde_esta = donde_esta;
	}

	public int getNumero_chip() {
		return numero_chip;
	}

	public void setNumero_chip(int numero_chip) {
		this.numero_chip = numero_chip;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getCastrado() {
		return castrado;
	}

	public void setCastrado(String castrado) {
		this.castrado = castrado;
	}

	public String getUltima_desparasitacion() {
		return ultima_desparasitacion;
	}

	public void setUltima_desparasitacion(String ultima_desparasitacion) {
		this.ultima_desparasitacion = ultima_desparasitacion;
	}

	public String getVacuna_rabia() {
		return vacuna_rabia;
	}

	public void setVacuna_rabia(String vacuna_rabia) {
		this.vacuna_rabia = vacuna_rabia;
	}

	public String getLeishmaniasis() {
		return leishmaniasis;
	}

	public void setLeishmaniasis(String leishmaniasis) {
		this.leishmaniasis = leishmaniasis;
	}

	public String getPendiente_operacion() {
		return pendiente_operacion;
	}

	public void setPendiente_operacion(String pendiente_operacion) {
		this.pendiente_operacion = pendiente_operacion;
	}

	public String getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

}
