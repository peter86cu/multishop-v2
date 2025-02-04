 async function modificarCantidad(productoId, cambio, precio) {
	
	const idCart = document.getElementById("cardId").value;
		const idUsuario = sessionStorage.getItem("userId") || "0000000000";

		// Realizar la solicitud al backend
		 await agregarProductoCarrito(productoId,precio,"op3");	
		
		// Actualizar el total del carrito
		actualizarCarrito();
	
}

async function eliminarCarrito() {
    try {
        // Obtener el id del carrito
        const idCart = document.getElementById("cardId").value;

        // Validar que el idCart exista
        if (!idCart) {
            console.error("No se encontró el ID del carrito");
            return;
        }

        // Confirmar antes de eliminar
        const confirmacion = confirm("¿Estás seguro de que deseas eliminar todo el carrito?");
        if (!confirmacion) return;

        // Realizar la solicitud al backend
        const response = await fetch(`/delete-car?idCart=${idCart}`, {
            method: "DELETE",
        });

        if (!response.ok) {
            throw new Error("Error al eliminar el carrito.");
        }

        const data = await response.json();

        // Verificar el código de la respuesta
        if (data.code !== 200) {
            console.error("Error en el backend:", data.message || "Error desconocido");
            return;
        }

        // Limpiar el carrito en la interfaz
        document.getElementById("carritoBody").innerHTML = "";
        document.getElementById("carritoTotal").textContent = "0.00";
        document.getElementById("contadorCarrito").innerHTML = "0";
        sessionStorage.removeItem("cart");
        sessionStorage.removeItem("cardId")
        sessionStorage.setItem("sessionId", uuid.v1());
        $("#cardId").val(uuid.v1())


        alert("Carrito eliminado exitosamente");
    } catch (error) {
        console.error("Error al eliminar el carrito:", error);
        alert("Ocurrió un error al intentar eliminar el carrito.");
    }
}


// Función para renderizar el carrito (se usa al iniciar la página o actualizar productos)
function renderizarCarrito() {
    const carritoBody = document.getElementById("carritoBody");
    carritoBody.innerHTML = ""; // Limpiar contenido

    // Agrupar productos por ID
    const productosAgrupados = {};

    for (const productoId in carrito) {
        const producto = carrito[productoId];

        if (productosAgrupados[productoId]) {
            // Si ya existe, suma la cantidad
            productosAgrupados[productoId].cantidad += producto.cantidad;
        } else {
            // Si no existe, agrégalo
            productosAgrupados[productoId] = { ...producto };
        }
    }
    
    let contadorProductos = 0;

    // Renderizar productos agrupados
    for (const productoId in productosAgrupados) {
        const producto = productosAgrupados[productoId];
        contadorProductos+=producto.cantidad;
        carritoBody.innerHTML += `
            <tr id="producto-row-${productoId}">
                <td>
                    <img src="img/${producto.imagen}" alt="${producto.nombre}" 
                         style="width: 50px; height: 50px; object-fit: cover; margin-right: 10px;">
                    ${producto.nombre}
                </td>
                <td>
                    <div class="cantidad-control">
                        <button class="btn btn-sm btn-light" onclick="modificarCantidad('${productoId}', -1,'${producto.precio}')">-</button>
                        <span id="cantidad-${productoId}">${producto.cantidad}</span>
                        <button class="btn btn-sm btn-light" onclick="modificarCantidad('${productoId}', 1,'${producto.precio}')">+</button>
                    </div>
                </td>
                <td>$${producto.precio.toFixed(2)}</td>
            </tr>
        `;
    }
        document.getElementById("contadorCarrito").innerHTML = contadorProductos;
        sessionStorage.setItem("contadorCarrito", contadorProductos);

    actualizarCarrito();
}




function actualizarTotalCarrito(detalles) {
    let total = 0;
    for (const detalle of detalles) {
        total += detalle.cantidad * detalle.precio; // Asegúrate de que `detalle` tenga precio
    }
    document.getElementById("carritoTotal").textContent = total.toFixed(2);
}


function guardarCarritoConLogin(idUsuario) {
	//activarLoader()
	let carrito = sessionStorage.getItem("contadorCarrito"); //document.getElementById("contadorCarrito").innerText;
	if (carrito > 0) {
		var datos = new FormData();
		datos.append("idCart", sessionStorage.getItem("cardId")/*$("#sessionId").val()*/);
		datos.append("idUsuario", idUsuario);
		datos.append("idProducto", "");
		datos.append("precio", 0);
		datos.append("cantidad", 0);
		datos.append("accion", "login");
		datos.append("img", "");
		datos.append("producto", "");

		$.ajax({
			url: URLLOCAL + "add-item-cart",
			method: "POST",
			data: datos,
			chache: false,
			contentType: false,
			processData: false,
			dataType: "json",
			success: function(respuesta) {
				desactivarLoading()
				var response = JSON.stringify(respuesta, null, '\t');
				var datos = JSON.parse(response);
				if (datos.code == 200) {
					datos.append("idCart", datos.datosCart.cart.idcart);
					const element = 0;
					for (let index = 0; index < datos.datosCart.detalle.length; index++) {
						element += datos.datosCart.detalle[index].cantidad;

					}
					sessionStorage.setItem("cart", element);
				}
			}
		}).fail(function(jqXHR, textStatus, errorThrown) {

			var msg = '';
			if (jqXHR.status === 0) {
				// msg = 'No connection.\n Verify Network.';
				//ERR_CONNECTION_REFUSED hits this one

				window.location.href = URLLOCAL + "maintenance"
			} else if (jqXHR.status == 404) {
				window.location.href = URLLOCAL + "404.html"
			} else if (jqXHR.status == 500) {
				msg = 'Internal Server Error [500].';
			}

		});

	}
	//Buscar Carrito guardado si tiene

}

function totalPago() {
    let subTotal = document.getElementById("subtotal-cart").innerText;
    let iva = document.getElementById("iva-cart").innerText;

    // Extraer los valores numéricos después del símbolo
    let subTotalValue = parseFloat(subTotal.slice(3));
    let ivaValue = parseFloat(iva.slice(3));

    // Redondear hacia arriba los valores y calcular el total
    let total = Math.ceil(subTotalValue) + Math.ceil(ivaValue);

    // Obtener el símbolo actual
    var simbolo = document.getElementById("total-cart").innerText.slice(0, 2).trim();

    // Actualizar el total en el DOM
    document.getElementById('total-cart').innerHTML = simbolo + " " + total;
}


function agregarProductoCarrito(idProducto, precio, accion) {
	//activarLoader()
	//sessionStorage.removeItem("cart");
	
	 const btnIngresar = document.getElementById('btnAddCarito');

    // Guardar el texto original
    const originalText = btnIngresar.innerHTML;

    // Desactivar el botón y mostrar el spinner
    btnIngresar.disabled = true;
    btnIngresar.innerHTML = `
        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
        <span class="spinner-hidden">Agregando...</span>
    `;
    
    
	let cantCart = 0;
	let total = 0;
	let cantNuevo = 0;
	var algo = 0


	if (accion == "op1") {
		cantNuevo = document.getElementById("cantidad-product-car").value;
	} else if (accion == "op2") {
		cantNuevo = document.getElementById(idProducto).value;
	} else {
		cantNuevo = 1;
	}

	if (sessionStorage.getItem("contadorCarrito") != null) {
		cantCart = sessionStorage.getItem("contadorCarrito");
	}


	//Sumamos mas
	total = Math.floor(cantNuevo) + Math.floor(cantCart);

	sessionStorage.setItem("contadorCarrito", total);
	var img = "";
	//document.getElementById('carrito-item').innerHTML = total;
	var cantidadProd = 0;
	sessionStorage.setItem("cart", total);
	if (sessionStorage.getItem("cardId") == null || sessionStorage.getItem("cardId") == "") {
		sessionStorage.setItem("cardId",$("#cardId").val());
	}
	if (accion != "op3") {
		cantidadProd = sessionStorage.getItem("contadorCarrito");
		img = document.getElementById("mainImage");

	} else {
		cantidadProd = 1;
		img = document.getElementById("mainImage");
	}
	
	if(accion === "op3"){
		var nameProduct = document.getElementById("name-product").innerText;
	}else{
		var nameProduct = document.getElementById("name-product").innerText;

	}
	var rImg = img.title;

	//Envio datos al WS
	var datos = new FormData();
	var idUsuario = "";
	if (sessionStorage.getItem("token") != null) {
		idUsuario = sessionStorage.getItem("userId");
	} else {
		idUsuario = "0000000000"
	}
	datos.append("idCart",$("#cardId").val());
	datos.append("idUsuario", idUsuario);
	datos.append("idProducto", idProducto);
	datos.append("precio", precio);
	datos.append("cantidad", cantidadProd);
	datos.append("accion", "insertar");
	datos.append("img", rImg);
	datos.append("producto", nameProduct);

	$.ajax({
		url: URLLOCAL + "add-item-cart",
		method: "POST",
		data: datos,
		chache: false,
		contentType: false,
		processData: false,
		dataType: "json",
		success: function(respuesta) {
			desactivarLoading()
			var response = JSON.stringify(respuesta, null, '\t');
			var datos = JSON.parse(response);
			if (datos.code == 200) {
				agregarProductoAlCarrito();
				actualizarContadorCarrito(cantidadProd);

			}
			 btnIngresar.disabled = false;
             btnIngresar.innerHTML = originalText;
		}
	}).fail(function(jqXHR, textStatus, errorThrown) {

		var msg = '';
		if (jqXHR.status === 0) {
			// msg = 'No connection.\n Verify Network.';
			//ERR_CONNECTION_REFUSED hits this one

			window.location.href = URLLOCAL + "maintenance"
		} else if (jqXHR.status == 404) {
			window.location.href = URLLOCAL + "404.html"
		} else if (jqXHR.status == 500) {
			msg = 'Internal Server Error [500].';
		}
	});
	//$("#cantidad-product-car").val(1);
}

function agregarProductoAlCarrito() {
	const carritoIcon = document.getElementById("carritoIcon");
	carritoIcon.classList.add("animate__animated", "animate__bounce");

	setTimeout(() => {
		carritoIcon.classList.remove("animate__animated", "animate__bounce");
	}, 1000); // Duración de la animación en milisegundos
}

function actualizarContadorCarrito(cantidad) {
	const contador = document.getElementById("contadorCarrito");
	contador.textContent = /*parseInt(contador.textContent) +*/ parseInt(cantidad);

	// Destacar el contador al cambiar
	contador.classList.add("highlight");
	setTimeout(() => {
		contador.classList.remove("highlight");
	}, 500);
}





function toggleCarritoDesplegable() {
	const carritoDropdown = document.getElementById("carritoDropdown");
    carritoDropdown.classList.toggle("show");
    actualizarCarrito(); // Llama a la función para obtener y renderizar datos actualizados
}

async function actualizarCarrito() {
    const carritoBody = document.getElementById("carritoBody");
    const carritoTotal = document.getElementById("carritoTotal");

    if (!carritoBody || !carritoTotal) {
        console.error("Elementos del carrito no encontrados");
        return;
    }

    try {
        // Obtener el id del carrito y el id del usuario
        const idCart = document.getElementById("cardId").value;
        const idUsuario = sessionStorage.getItem("userId") || "0000000000";

        // Realizar la solicitud al backend
        const response = await fetch(`/search-car?idCart=${idCart}&idUsuario=${idUsuario}`);

        if (!response.ok) {
            throw new Error("Error al obtener los datos del carrito.");
        }

        const data = await response.json();

        // Verificar el código de la respuesta
        if (data.code !== 200) {
            console.error("Error en el backend:", data.resultado || "Error desconocido");
            return;
        }

        // Limpiar contenido del carrito antes de agregar nuevos elementos
        carritoBody.innerHTML = "";
        carritoTotal.textContent = "0.00";

        // Navegar hasta la lista de detalles del carrito
        const detalles = data.datosCart.cartDetalle.detalle || [];
        let total = 0;
        let contadorProductos = 0;

        // Agrupar productos por ID
        const productosAgrupados = {};

        detalles.forEach((producto) => {
            // Validar si el producto ya existe en productosAgrupados
            if (productosAgrupados[producto.idproducto]) {
                // Si ya existe, sumar la cantidad
                productosAgrupados[producto.idproducto].cantidad += producto.cantidad;
            } else {
                // Si no existe, agregarlo
                productosAgrupados[producto.idproducto] = { ...producto };
            }
        });

        // Renderizar productos agrupados
        for (const productoId in productosAgrupados) {
            const producto = productosAgrupados[productoId];
			contadorProductos+= producto.cantidad;
            carritoBody.innerHTML += `
                <tr id="producto-row-${productoId}">
                    <td>
                        <img id="mainImage" src="img/${producto.imagen}" alt="${producto.nombre}" 
                             style="width: 50px; height: 50px; object-fit: cover; margin-right: 10px;">
                        <span id="name-product">${producto.nombre}</span
                    </td>
                    <td>
                        <div class="cantidad-control">
                            <button class="btn btn-sm btn-light" onclick="modificarCantidad('${productoId}', -1,'${Math.ceil(producto.precio)}')">-</button>
                            <span id="cantidad-${productoId}">${producto.cantidad}</span>
                            <button class="btn btn-sm btn-light" onclick="modificarCantidad('${productoId}', 1,'${Math.ceil(producto.precio)}')">+</button>
                        </div>
                    </td>
                    <td>$${Math.ceil(producto.precio.toFixed(2))}</td>
                </tr>
            `;

            // Sumar al total
            total += producto.precio * producto.cantidad;
        }
        sessionStorage.setItem("contadorCarrito", contadorProductos);
        document.getElementById("contadorCarrito").innerHTML = contadorProductos;

        // Actualizar el total del carrito
        carritoTotal.textContent = Math.ceil(total.toFixed(2));
    } catch (error) {
        console.error("Error al actualizar el carrito:", error);
    }
}




// Mostrar el carrito en el modal
/*function mostrarCarritoDesplegable() {
	
	const modalId = 'carritoModal';

	// Verificar si el modal ya existe
	let modalElement = document.getElementById(modalId);
	if (!modalElement) {
		// Construir el modal dinámicamente si no existe
		const modalHTML = `
			<div id="${modalId}" class="modal fade" tabindex="-1" data-backdrop="static" aria-labelledby="carritoModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="carritoModalLabel">Tu Carrito</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<table class="table">
								<thead>
									<tr>
										<th>Producto</th>
										<th>Cantidad</th>
										<th>Precio</th>
									</tr>
								</thead>
								<tbody id="carritoBody">
									<!-- Productos se insertarán dinámicamente -->
								</tbody>
							</table>
							<div class="text-end">
								<strong>Total:</strong> $<span id="carritoTotal">0.00</span>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="realizarPago()">Pagar</button>
							<button type="button" class="btn btn-secondary" onclick="irAlCarrito()">Ver Carrito</button>
						</div>
					</div>
				</div>
			</div>
		`;

		// Agregar el modal al DOM
		document.body.insertAdjacentHTML('beforeend', modalHTML);
		modalElement = document.getElementById(modalId);
	}


	// Actualiza los datos del carrito
	const carritoBody = document.getElementById("carritoBody");
	const carritoTotal = document.getElementById("carritoTotal");

	if (!carritoBody || !carritoTotal) {
		console.error('Elementos del carrito no encontrados');
		return;
	}

	carritoBody.innerHTML = "";
	let total = 0;

	carrito.forEach(item => {
		const fila = `
			<tr>
				<td>${item.producto}</td>
				<td>${item.cantidad}</td>
				<td>$${(item.precio * item.cantidad).toFixed(2)}</td>
			</tr>
		`;
		carritoBody.innerHTML += fila;
		total += item.precio * item.cantidad;
	});

	carritoTotal.textContent = total.toFixed(2);

	// Mostrar el modal usando Bootstrap
	try {
		const modal = new bootstrap.Modal(document.getElementById('carritoModal'), {
			keyboard: true
		});
		modal.show();
	} catch (error) {
		console.error('Error al mostrar el modal:', error);
	}
}
*/


// Cerrar el modal del carrito
function cerrarCarritoDesplegable() {
	const modal = document.getElementById("carritoModal");
	modal.style.display = "none";
}

// Acción para el botón "Pagar"
function realizarPago() {
	alert("Redirigiendo a la página de pago...");
	// Aquí puedes redirigir o abrir la pasarela de pagos
}

// Acción para el botón "Ver Carrito"
function irAlCarrito() {
	window.location.href = "/carrito"; // Cambia "/carrito" por la URL de tu página de carrito
}
function eliminarProductoCarrito(idProducto) {
	activarLoader()
	var idUsuario = "";
	//if (sessionStorage.getItem("token") != null) {
	idUsuario = sessionStorage.getItem("userId");
	// } else {
	//  idUsuario = "0000000000"
	//}
	var datos = new FormData();
	datos.append("idProducto", idProducto);
	datos.append("idUsuario", idUsuario);
	datos.append("idCart", sessionStorage.getItem("cartIDSession"));

	$.ajax({
		url: URLLOCAL + "delete-product-cart",
		method: "POST",
		data: datos,
		chache: false,
		contentType: false,
		processData: false,
		dataType: "json",
		success: function(respuesta) {
			desactivarLoading()
			var response = JSON.stringify(respuesta, null, '\t');
			var datos = JSON.parse(response);
			if (datos.code == 200) {
				mensajeOK("OK");
			}
		}
	})


}


function validarPago(direccion) {
    // Activar loader (si es necesario)
    //var totalPagoText = document.getElementById("carritoTotal").innerText;
    const totalPagoText = document.getElementById("total-cart").textContent;


 let subTotal = document.getElementById("subtotal-cart").innerText;
    let iva = document.getElementById("iva-cart").innerText;

    // Extraer los valores numéricos después del símbolo
    let subTotalValue =  Math.ceil(subTotal.slice(3));
    let ivaValue = Math.ceil(iva.slice(3));
    
    
    var codeMoneda = document.getElementById("moneda-pago-select");
    
    // Obtener el valor antes del punto decimal
    let totalPago = totalPagoText.slice(3).split(".")[0].trim();

    if (sessionStorage.getItem("userId") == "0000000000" || sessionStorage.getItem("userId") == null) {
        mensajeErrorGenerico("Debe iniciar sessión para continuar.");
    } else {
        if (totalPago > 0) {
            window.location.href = URLLOCAL + "checkout01?curenty=" + codeMoneda.value + "&pay=" + totalPago + "&userId=" + $("#userId").val()+"&subtotal="+subTotalValue+"&iva="+ivaValue;
        } else {
            mensajeErrorGenerico("Ocurrió un error, por favor escribir a info@ayalait.com.uy.");
        }
    }
    // Desactivar loader (si es necesario)
}




function mensajeLoginUserPago(mensaje) {
	Swal.fire({
		text: mensaje,
		icon: 'warning',
		// icon: "warning",
		showCancelButton: true,
		confirmButtonText: 'OK',
		cancelButtonText: "No",
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
	}).then((result) => {
		if (result.value) {
			abrirModal('loginAutenticar');
		}
		return false;
	})
}

function getSourceCurrency() {
    const currencyInput = document.getElementById("sourceCurrency");
    return currencyInput.value;
}

function setSourceCurrency(newCurrency) {
    const currencyInput = document.getElementById("sourceCurrency");
    currencyInput.value = newCurrency;
}

async function cambiarMoneda() {
    try {
        const selectElement = document.getElementById("moneda-pago-select");
        const targetCurrency = selectElement.value; // Moneda seleccionada (a cambiar)
        const sourceCurrency = getSourceCurrency();// Moneda actual (puedes obtenerla dinámicamente si es necesario)
        var type="";
        if(sourceCurrency=="USD")
        type="1";
        else
        type="2";
        
        // Llamar al backend con ambas monedas
        const response = await fetch(`/cambio-moneda?type=${type}&sourceCurrency=${sourceCurrency}&targetCurrency=${targetCurrency}`);
        if (!response.ok) {
            throw new Error("Error al obtener el tipo de cambio");
        }

        const data = await response.json();
        if (data.code !== 200) {
            alert(data.respuesta || "No se pudo obtener el tipo de cambio.");
            return;
        }

        // Extraer el valor del tipo de cambio
        const cambio = data.cambio.value;

 // Actualizar la moneda actual en el campo oculto
        setSourceCurrency(targetCurrency);

        // Recalcular los valores del carrito
        actualizarValoresCarrito(cambio, targetCurrency);
    } catch (error) {
        console.error("Error al cambiar la moneda:", error);
        alert("Hubo un error al intentar cambiar la moneda.");
    }
}

function actualizarValoresCarrito(rate, currencySymbol) {
    // Actualizar los valores de subtotal, IVA y total
    const subtotalElement = document.getElementById("subtotal-cart");
    const ivaElement = document.getElementById("iva-cart");
    const totalElement = document.getElementById("total-cart");

    const subtotal = parseFloat(subtotalElement.textContent.replace(/[^\d.-]/g, ""));
    const iva = (subtotal * 22) / 100;
    const total = subtotal + iva;

    if (currencySymbol === "USD") {
        // Redondear hacia arriba para USD
        subtotalElement.textContent = `${currencySymbol} ${Math.ceil(subtotal / rate).toFixed(2)}`;
        ivaElement.textContent = `${currencySymbol} ${Math.ceil(iva / rate).toFixed(2)}`;
        totalElement.textContent = `${currencySymbol} ${Math.ceil(total / rate).toFixed(2)}`;
    } else {
        // Redondear hacia arriba para otras monedas
        subtotalElement.textContent = `${currencySymbol} ${Math.ceil(subtotal * rate).toFixed(2)}`;
        ivaElement.textContent = `${currencySymbol} ${Math.ceil(iva * rate).toFixed(2)}`;
        totalElement.textContent = `${currencySymbol} ${Math.ceil(total * rate).toFixed(2)}`;
    }
}

    
   


document.addEventListener("click", (event) => {
	const carritoDropdown = document.getElementById("carritoDropdown");
	const carritoIcon = document.getElementById("carritoIcon");

	if (!carritoDropdown.contains(event.target) && !carritoIcon.contains(event.target)) {
		carritoDropdown.classList.remove("show");
	}
});




