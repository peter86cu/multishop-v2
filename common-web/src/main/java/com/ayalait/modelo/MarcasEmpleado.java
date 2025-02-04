package com.ayalait.modelo;



import com.ayalait.utils.CompositeIdMarcasEmpleado;


public class MarcasEmpleado  {
	

		private CompositeIdMarcasEmpleado compositeId;
		private String marcaentrada;
		private String marcasalida;
		private String estado;
		private String proceso;
		private String tipo;
		private String accion;
		private String idhorario;


		public String getMarcaentrada() {
			return marcaentrada;
		}

		public void setMarcaentrada(String marcaentrada) {
			this.marcaentrada = marcaentrada;
		}

		public String getMarcasalida() {
			return marcasalida;
		}

		public void setMarcasalida(String marcasalida) {
			this.marcasalida = marcasalida;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getAccion() {
			return accion;
		}

		public void setAccion(String accion) {
			this.accion = accion;
		}

		public CompositeIdMarcasEmpleado getCompositeId() {
			return compositeId;
		}

		public void setCompositeId(CompositeIdMarcasEmpleado compositeId) {
			this.compositeId = compositeId;
		}

		public MarcasEmpleado() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getProceso() {
			return proceso;
		}

		public void setProceso(String proceso) {
			this.proceso = proceso;
		}

		public String getIdhorario() {
			return idhorario;
		}

		public void setIdhorario(String idhorario) {
			this.idhorario = idhorario;
		}

}
