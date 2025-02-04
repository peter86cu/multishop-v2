/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayalait.modelo;



/**
 *
 * @author pedro
 */
public class Empleado {

	private String idempleado;
	
	private int numeroempleado;

	private String nombre;

	private String apellidos;
	
	private int idtipodocumento;

	private String documento;

	private String fechanacimiento;

	private String fechaingreso;

	private String fechaegreso;

	private String foto;
	
	private int idempresa;
	
	private int idsucursal;
	
	private String imagen;
	
	private int sexo;
	
	private int pais_documento;
	
	private int pais_residencia;
	
	private String telefono;
	
	private String correo_personal;
	
	private String direccion;


    public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getPais_documento() {
		return pais_documento;
	}

	public void setPais_documento(int pais_documento) {
		this.pais_documento = pais_documento;
	}

	public int getPais_residencia() {
		return pais_residencia;
	}

	public void setPais_residencia(int pais_residencia) {
		this.pais_residencia = pais_residencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo_personal() {
		return correo_personal;
	}

	public void setCorreo_personal(String correo_personal) {
		this.correo_personal = correo_personal;
	}

	public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getFechaegreso() {
        return fechaegreso;
    }

    public void setFechaegreso(String fechaegreso) {
        this.fechaegreso = fechaegreso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Empleado() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Empleado(String idempleado, String nombre) {
		super();
		this.idempleado = idempleado;
		this.nombre = nombre;
	}

	public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    @Override
    public String toString() {
        return nombre+" "+apellidos;
    }

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumeroempleado() {
		return numeroempleado;
	}

	public void setNumeroempleado(int numeroempleado) {
		this.numeroempleado = numeroempleado;
	}
   
}
