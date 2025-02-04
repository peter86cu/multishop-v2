


function activarLoader(){
	abrirModal('loadingModal');
}

function desactivarLoading(){
	cerrarModal('loadingModal');
	}

function getQueryVariable(variable) {
	// Estoy asumiendo que query es window.location.search.substring(1);
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	return false;
}

function abrirModal(nombreModal) {
	$('#' + nombreModal).modal({ backdrop: 'static', keyboard: false })
	$('#' + nombreModal).modal('show');
	

}

function cerrarModal(nombreModal) {
	
	$('#' + nombreModal).modal('hide');
}


function limpiarSession(){
	sessionStorage.removeItem("token");
	sessionStorage.removeItem("cart");
	sessionStorage.removeItem("cartId");
	sessionStorage.removeItem("userId");
	sessionStorage.removeItem("userName");



	sessionStorage.removeItem("cartIDSession");
    sessionStorage.removeItem("userId");
	sessionStorage.removeItem("nameUser");
	sessionStorage.removeItem("sessionId");
	sessionStorage.removeItem("simboloMoneda");
	
}


/*function cargarDatos(){

	

	var datos = new FormData();
  
	var idUsuario=sessionStorage.getItem("userId");
  
	datos.append("idUsuario", idUsuario);
  
		  $.ajax({
			url: URL+"star",
			method: "POST",
			data: datos,
			chache: false,
			contentType: false,
			processData: false,
			dataType: "json",
			  success: function (respuesta) {
				  var response = JSON.stringify(respuesta, null, '\t');
				  var datos = JSON.parse(response);
				  if (datos.code == 200) {
					  var tr2 = "";
					  var cat="";
					if(datos.tipoProducto.length>0){
					  for (var i = 0; i < datos.tipoProducto.length; i++) {
	  
						  tr2 +=  `<a  class="dropdown-item" onclick="linkEnvioCateg('category.html','` + datos.tipoProducto[i].id_tipo_producto + ` ','` + datos.tipoProducto[i].descripcion + `')"
					   >` + datos.tipoProducto[i].descripcion + `</a>`;
	  
						  
	  
					  }
					}
					if(datos.todasCategorias.length>0){
					  for (var i = 0; i < datos.todasCategorias.length; i++) {
	  
						  cat +=  `<a onclick="linkEnvioProductosPorCategoria('shop.html','` + datos.todasCategorias[i].id_categoria_producto + `','` + datos.todasCategorias[i].categoria + `')" class="nav-item nav-link">`+datos.todasCategorias[i].categoria+`</a>`;
	  
						  
	  
					  }
					}if(datos.carrito!=null){
					  let cantidad=0;
					  for (let index = 0; index < datos.carrito.detalle.length; index++) {
						cantidad += datos.carrito.detalle[index].cantidad;
						
					  }
					  sessionStorage.setItem("sessionId",datos.carrito.cart.idcart );
					  sessionStorage.setItem("cartIDSession",datos.carrito.cart.idcart );
					  sessionStorage.setItem("cart",cantidad );
					  document.getElementById('carrito-item').innerHTML = cantidad;
					}
					
					$("#item-category").append(cat);
				  }
	  
				  $("#tipo-productos-item").append(tr2);
			  }
		  }).fail(function(jqXHR, textStatus, errorThrown) {
  
			var msg = '';
			if (jqXHR.status === 0) {
			   // msg = 'No connection.\n Verify Network.';
				//ERR_CONNECTION_REFUSED hits this one
  
				window.location.href = URLLOCAL + "maintenance.html"
			} else if (jqXHR.status == 404) {
				window.location.href = URLLOCAL + "404.html"
			} else if (jqXHR.status == 500) {
				msg = 'Internal Server Error [500].';
			} else if (exception === 'parsererror') {
				msg = 'Requested JSON parse failed.';
			} else if (exception === 'timeout') {
				msg = 'Time out error.';
			} else if (exception === 'abort') {
				msg = 'Ajax request aborted.';
			} else {
				msg = 'Uncaught Error.\n' + jqXHR.responseText;
			}
	
		  limpiarSession()
		});
	  }*/
  
function mensajeProduct(mensaje) {
    Swal.fire({
        text: mensaje,
        //type: "success",
        icon: "success",
        showCancelButton: false,
        confirmButtonText: "OK",
        cancelButtonText: "No",
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
    }).then((result) => {
        if (result.value) {
           location.reload();

        }
    });
}

function mensajeErrorGenerico(mensaje) {
  Swal.fire({
      text: mensaje,
      //type: 'warning',
      icon: "warning",
      showCancelButton: false,
      confirmButtonText: 'OK',
      cancelButtonText: "No",
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
  }).then((result) => {
      if (result.value) {
          return true;
      }
      return false;
  })
}


