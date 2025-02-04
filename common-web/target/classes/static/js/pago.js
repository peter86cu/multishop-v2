/*function mostrarFormularioDireccion(checkbox) {
	// Desmarcar otros checkboxes
	const checkboxes = document.querySelectorAll('#dire-ckeck input[type="checkbox"]');
	checkboxes.forEach((cb) => {
		if (cb !== checkbox) cb.checked = false;
	});

	// Ocultar todos los formularios de dirección
	const formularios = document.querySelectorAll('#direccion-persona > div');
	formularios.forEach((form) => form.style.display = 'none');

	// Mostrar el formulario correspondiente al checkbox seleccionado
	if (checkbox.checked) {
		const formularioId = 'dir' + checkbox.value;
		const formulario = document.getElementById(formularioId);
		if (formulario) formulario.style.display = 'block';
	}
}*/

function mostrarFormularioDireccion(checkbox) {
	// Desmarcar otros checkboxes
	const checkboxes = document.querySelectorAll('#dire-ckeck input[type="checkbox"]');
	checkboxes.forEach((cb) => {
		if (cb !== checkbox) cb.checked = false;
	});

	// Ocultar todos los formularios de dirección
	const formularios = document.querySelectorAll('#direccion-persona > div');
	formularios.forEach((form) => form.style.display = 'none');

	// Mostrar el formulario correspondiente al checkbox seleccionado
	if (checkbox.checked) {
		const formularioId = 'dir' + checkbox.value;
		console.log('Mostrando formulario con ID:', formularioId); // Log para depuración
		const formulario = document.getElementById(formularioId);
		if (formulario) {
			formulario.style.removeProperty('display');
			formulario.style.display = 'block';
			console.log('Formulario encontrado y mostrado:', formulario);
		} else {
			console.error('Formulario no encontrado:', formularioId);
		}
	}
}



function pagarOrden() {
	//activarLoader()
	const btnIngresar = document.getElementById('button-pagar-orden');

	// Guardar el texto original
	const originalText = btnIngresar.innerHTML;

	// Desactivar el botón y mostrar el spinner
	btnIngresar.disabled = true;
	btnIngresar.innerHTML = `
        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
        <span class="spinner-hidden">Validando orden...</span>
    `;
	var idDireccion = "";
	let cantidadDir = $("#cantidadDirecciones").val();
	let pos = 1;
	while (pos <= cantidadDir) {
		if (document.getElementById(document.getElementsByName(pos)[0].value).checked) {
			idDireccion = document.getElementsByName(pos)[0].value;
			break;
		}
		pos++;
	}

	if (idDireccion != "") {
		var datos = new FormData();

		var idUsuario = sessionStorage.getItem("userId");
		//var iva = document.getElementById("iva-cart").innerHTML;
		//iva = iva.slice(3);
		//iva = iva.trim();
		datos.append("userId", idUsuario);
		datos.append("moneda", getQueryVariable("curenty"));
		datos.append("total", Math.floor(getQueryVariable("pay")));
		datos.append("cartId", $("#cardId").val());
		datos.append("iva", Math.floor(getQueryVariable("iva")));
		datos.append("idDireccion", Math.floor(idDireccion));

		$.ajax({
			url: URLLOCAL + "validar-pago",
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
					sessionStorage.setItem("sessionId", datos.cartIDSession);
					sessionStorage.setItem("cartIDSession", datos.cartIDSession);
					sessionStorage.setItem("contadorCarrito", 0);
					sessionStorage.removeItem("cart");
					sessionStorage.setItem("cart", 0);


					window.location = datos.pagoValidado.redirect_url;
				} else if (datos.code == 500) {

					//sessionStorage.removeItem("cart");
					//sessionStorage.removeItem("cartIDSession");
					mensajeErrorPago(datos.error.menssage)
					//salir()

				} else {
					mensajeErrorPago402(datos.error.menssage)
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
				window.location.href = URLLOCAL + "404"
			} else if (jqXHR.status == 500) {
				msg = 'Internal Server Error [500].';
			}

			// limpiarSession()
		});


	} else {
		mensajeDireccion("Debe seleccionar una dirección de envío para continuar.");
		btnIngresar.disabled = false;
		btnIngresar.innerHTML = originalText;
	}



}

$('input[type="checkbox"]').on('change', function(e) {
	if (this.checked) {
		//console.log('Checkbox ' + $(e.currentTarget).val() + ' checked');
		document.getElementById("dir" + $(e.currentTarget).val()).style.display = "block";
	} else {
		//console.log('Checkbox ' + $(e.currentTarget).val() + ' unchecked');
		document.getElementById("dir" + $(e.currentTarget).val()).style.display = "none";
	}
});

function mensajeErrorPago(mensaje) {
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
			//desactivarLoading()
			//location.href = "index";
			btnIngresar.disabled = false;
				btnIngresar.innerHTML = originalText;
		}
		//desactivarLoading()
		return false;
	})
}

function mensajeErrorPago402(mensaje) {
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
			desactivarLoading()
			return true;
		}
		desactivarLoading()
		return false;
	})
}


function mensajeDireccion(mensaje) {
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
			desactivarLoading()
			return true;
		}
		return false;
	})
}


function guardarDireccionNueva() {

	activarLoader()

	var datos = new FormData();

	var idUsuario = sessionStorage.getItem("userId");
	var dpto = document.getElementById("tipo-dpto-select");

	datos.append("alias", $("#txt_alias").val());
	datos.append("departamento", dpto.value);
	datos.append("ciudad", $("#txt_ciudad").val());
	datos.append("direccion", $("#txt_direccion").val());
	datos.append("codigo", $("#txt_zip").val());
	datos.append("userId", idUsuario);

	$.ajax({
		url: URLLOCAL + "add-new-address",
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
			if (datos.status) {
				cerrarModal('ModalNuevaDireccion')
				mensajeProduct(datos.resultado);
			} else {
				mensajeErrorPago402(datos.error.menssage)
			}
		}
	})
}



//CREACION DEL PAGINADO
$(document).ready(function() {
	$("#search").keyup(function() {
		_this = this;
		// Show only matching TR, hide rest of them
		$.each($("#compras tbody tr"), function() {
			if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
				$(this).hide();
			else
				$(this).show();
		});
	});
});




//Aqui va el paginado de compras


$(document).ready(function() {

	addPagerToTables('#compras', 8);

});

function addPagerToTables(tables, rowsPerPage = 10) {

	tables =
		typeof tables == "string"
			? document.querySelectorAll(tables)
			: tables;

	for (let table of tables)
		addPagerToTable(table, rowsPerPage);

}

function addPagerToTable(table, rowsPerPage = 10) {

	let tBodyRows = table.querySelectorAll('tBody tr');
	let numPages = Math.ceil(tBodyRows.length / rowsPerPage);

	let colCount =
		[].slice.call(
			table.querySelector('tr').cells
		)
			.reduce((a, b) => a + parseInt(b.colSpan), 0);

	table
		.createTFoot()
		.insertRow()
		.innerHTML = `<td colspan=${colCount}><div class="nav"></div></td>`;

	if (numPages == 1)
		return;

	for (i = 0; i < numPages; i++) {

		let pageNum = i + 1;

		table.querySelector('.nav')
			.insertAdjacentHTML(
				'beforeend',
				`<a class="bot" href="#" rel="${i}"> ${pageNum}</a> `
			);

	}

	changeToPage(table, 1, rowsPerPage);

	for (let navA of table.querySelectorAll('.nav a'))
		navA.addEventListener(
			'click',
			e => changeToPage(
				table,
				parseInt(e.target.innerHTML),
				rowsPerPage
			)
		);

}

function changeToPage(table, page, rowsPerPage) {

	let startItem = (page - 1) * rowsPerPage;
	let endItem = startItem + rowsPerPage;
	let navAs = table.querySelectorAll('.nav a');
	let tBodyRows = table.querySelectorAll('tBody tr');

	for (let nix = 0; nix < navAs.length; nix++) {

		if (nix == page - 1)
			navAs[nix].classList.add('active');
		else
			navAs[nix].classList.remove('active');

		for (let trix = 0; trix < tBodyRows.length; trix++)
			tBodyRows[trix].style.display =
				(trix >= startItem && trix < endItem)
					? 'table-row'
					: 'none';

	}

}