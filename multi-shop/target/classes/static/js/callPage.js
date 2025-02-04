function linkEnvioCateg(direccion, id, producto) {
  // sessionStorage.setItem("user", "invitado1");
activarLoader()
  var data = sessionStorage.getItem("user");

  window.location.href = URLLOCAL + direccion + "?id=" + id;
  desactivarLoading()
}

function linkEnvioProductosPorCategoria(direccion, id, categoria) {
	activarLoader()
  window.location.href = URLLOCAL + direccion + "?id=" + id;
  desactivarLoading()
}

function linkEnvioDetalleProducto(direccion, id, categoria) {
	activarLoader()
  window.location.href = URLLOCAL + direccion + "?id=" + id;
  desactivarLoading()
}

function linkValidarComprasUser(direccion, id) {
	activarLoader()
  window.location.href = URLLOCAL + direccion + "?id=" + id;
  desactivarLoading()
}

function linkEnvioCardProductos(direccion) {
	//activarLoader()
 /*if (
     $("#cardItems").val() == "0" || $("#cardItems").val() == ""
  ) {
    Swal.fire({
      position: "top-end",
      icon: "success",
      text: "Tengo que ver esto en linkEnvioCardProductos callPage",
      showConfirmButton: false,
      timer: 15000,
    });
  } else */if (
    getQueryVariable("filter") == "detail"
  ) {
   window.location.href =
      URLLOCAL +
        "search?idCart=" +
      $("#cardId").val()+"&idUsuario="+sessionStorage.getItem("userId");

   } else if( /* $("#cardItems").val()*/sessionStorage.getItem("contadorCarrito") != "0"){
	   if(sessionStorage.getItem("userId")==null){
		   sessionStorage.setItem("userId", "0000000000");
	   }
    window.location.href =
         URLLOCAL +
           "search?idCart=" +
         $("#cardId").val()+"&idUsuario="+sessionStorage.getItem("userId");
   }
   desactivarLoading()
  }

function linkListadoComprasUser(direccion, id) {
  activarLoader()
  window.location.href = URLLOCAL + direccion + "?iduser=" + id;
  desactivarLoading()
}


function mensajeNoOK(mensaje) {
  Swal.fire({
    title: mensaje,
    //type: "warning",
    icon: "warning",
    showCancelButton: false,
    confirmButtonText: "OK",
    cancelButtonText: "No",
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
  }).then((result) => {
    if (result.value) {
      //location.reload();
    }
    return false;
  });
}

function mensajeInicio(mensaje) {
  Swal.fire({
    text: mensaje,
   // type: "warning",
    icon: "warning",
    showCancelButton: false,
    confirmButtonText: "OK",
    cancelButtonText: "No",
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
  }).then((result) => {
    if (result.value) {
      location.href = "index.html";
    }
    return false;
  });
}
