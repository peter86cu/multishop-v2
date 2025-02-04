package com.ayalait.modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marca_calendario")
public class MarcaCalendario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompositeMarcaEmpleado compositeId;
	
	

}
