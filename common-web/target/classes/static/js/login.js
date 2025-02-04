
function isEqual(str1, str2) {
	return str1 === str2;
}

async function login() {
    const btnIngresar = document.getElementById('btnIngresar');

    // Guardar el texto original
    const originalText = btnIngresar.innerHTML;

    // Desactivar el botón y mostrar el spinner
    btnIngresar.disabled = true;
    btnIngresar.innerHTML = `
        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
        <span class="spinner-hidden">Autenticando</span>
    `;

    // Obtener valores de los inputs
    const mail = document.getElementById("emailInput").value.trim();
    const pass = document.getElementById("passwordInput").value.trim();

    // Validar si los campos están vacíos
    if (!mail || !pass) {
        mostrarError("Por favor, completa todos los campos.");
        btnIngresar.disabled = false;
        btnIngresar.innerHTML = originalText;
        return;
    }

    // Validar si el userId y userName están en sessionStorage
    if (!sessionStorage.getItem("userId")) {
        sessionStorage.setItem("userId", document.getElementById("userId")?.value || "");
    }
    if (!sessionStorage.getItem("userName")) {
        sessionStorage.setItem("userName", document.getElementById("userName")?.value || "");
    }

    const sessionId = sessionStorage.getItem("sessionId") || document.getElementById("sessionId")?.value || "";
    if (sessionId === "0000000000") {
        sessionStorage.setItem("sessionId", sessionId);
        sessionStorage.setItem("cardId", document.getElementById("cardId")?.value || "");
    }

    const datos = new FormData();
    datos.append("mail", mail);
    datos.append("password", pass);
    datos.append("sessionId", sessionId);

    //try {
        // Realizar la solicitud al backend
        const response = await fetch(URLLOCAL + "login", {
            method: "POST",
            body: datos,
        });

        if (!response.ok) throw new Error("Error al realizar el login.");

        const respuesta = await response.json();

        if (respuesta.code === 200) {
            sessionStorage.setItem("nameUser", respuesta.user.name);
            sessionStorage.setItem("userId", respuesta.user.id);
            sessionStorage.setItem("token", respuesta.token);
            sessionStorage.setItem("cardId", respuesta.cardId);

            // Actualizar contador del carrito
            const contadorCarrito = respuesta.responseResultado?.carrito?.detalle.reduce((acc, item) => acc + item.cantidad, 0) || 0;
            sessionStorage.setItem("contadorCarrito", contadorCarrito);
            document.getElementById("contadorCarrito").innerHTML = contadorCarrito;

            location.reload(); // Recargar la página
        } else if (respuesta.code === 406) {
            mostrarError(respuesta.error.menssage,originalText);
             btnIngresar.disabled = false;
        btnIngresar.innerHTML = originalText;
        } else if (respuesta.code === 404) {
            mostrarError("Estamos en mantenimiento, por favor intenta más tarde.",originalText);
             btnIngresar.disabled = false;
        btnIngresar.innerHTML = originalText;
        }
   /* } catch (error) {
        mostrarError(respuesta.error.menssag);
         btnIngresar.disabled = false;
        btnIngresar.innerHTML = originalText;
        console.error(error);
    } finally {
        // Restaurar el estado del botón
        btnIngresar.disabled = false;
        btnIngresar.innerHTML = originalText;
    }*/
}

function mostrarError(mensaje,originalText) {
    const errorContainer = document.getElementById("error-message");
    if (errorContainer) errorContainer.remove();

    const loginForm = document.getElementById("loginForm");
    const errorDiv = document.createElement("div");
    errorDiv.id = "error-message";
    errorDiv.className = "alert alert-danger text-center";
    errorDiv.style.fontSize = "14px";
    errorDiv.style.marginBottom = "15px";
    errorDiv.textContent = mensaje;

    loginForm.prepend(errorDiv);
     btnIngresar.disabled = false;
        btnIngresar.innerHTML = originalText;
}


document.addEventListener("DOMContentLoaded", () => {
    // Detectar Enter en el formulario
    const loginForm = document.getElementById("loginForm");
    loginForm.addEventListener("keydown", (event) => {
        if (event.key === "Enter") {
            event.preventDefault(); // Prevenir envío del formulario
            login(); // Ejecutar la función login
        }
    });
});

function salir() {
	$.ajax({
		url: URLLOCAL + "logout",
		method: "POST",
		data: "",
		chache: false,
		contentType: false,
		processData: false,
		dataType: "json",
		success: function(respuesta) {
			var response = JSON.stringify(respuesta, null, "\t");
			var datos = JSON.parse(response);
			if (datos.code == 200) {
				sessionStorage.setItem("nameUser", "Invitado");
				// sessionStorage.setItem("sessionId",uuid.v1());
				sessionStorage.removeItem("token");
				sessionStorage.removeItem("cart");
				sessionStorage.setItem("userId", "0000000000");
				sessionStorage.clear(); // Borra explícitamente si detectas Ctrl + F5
				document.getElementById("contadorCarrito").innerHTML = 0;
				window.location.href = "index";
			} else if (
				datos.code == 201 &&
				sessionStorage.getItem("token") != datos.resultado
			) {
				sessionStorage.setItem("nameUser", "Invitado");
				sessionStorage.removeItem("token");
				sessionStorage.removeItem("cart");
				sessionStorage.setItem("userId", "0000000000");
				//sessionStorage.removeItem("sessionId",uuid.v1());
				window.location.href = "index";
			}
		},
	});
}

function mensajeOK(mensaje) {
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

function mensajeDeleteAcount(mensaje) {
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
			salir()
		}
	});
}



function validarPassword(event, objeto, accion) {
	const input = document.getElementById(objeto);
	input.addEventListener("change", valPasswords(objeto, accion));

	/*$(document).ready(function() {
		$(document).on('change', '#' + objeto, function() {
			if ($(this).val().trim() != "") {
				if(isEqual(pass,$(this).val().trim())){
				$("#" + objeto).removeClass("is-invalid");
				$('#password').removeClass('is-invalid');
				}else{
				$('#' + objeto).addClass('is-invalid');
				$('#password').addClass('is-invalid');
				}
			} else {
				$('#' + objeto).addClass('is-invalid');
				$('#password').addClass('is-invalid');
			}
			if(validarCampos())
			$('#btnRegistrar').prop('disabled', false);
		});
	})*/
}

function valPasswords(objeto, accion) {
	var pass = $('#password').val();

	if ($('#' + objeto).val().trim() != "") {
		if (isEqual(pass, $('#' + objeto).val().trim())) {
			$("#" + objeto).removeClass("is-invalid");
			$('#password').removeClass('is-invalid');
		} else {
			$('#' + objeto).addClass('is-invalid');
			$('#password').addClass('is-invalid');
		}
	} else {
		$('#' + objeto).addClass('is-invalid');
		$('#password').addClass('is-invalid');
	}
	if (validarCampos() && accion == "registrar")
		$('#btnRegistrar').prop('disabled', false);
	if (validarCamposUpdate() && accion == "actualizar")
		$('#btnRegistrar').prop('disabled', false);
}

function regitrarUsuario() {
	var nombre = $('#nombre').val();
	var apellidos = $("#apellidos").val();
	var email = $("#email").val()
	var telefono = $("#telefono").val()
	var tipodoc = $("#tipo-doc-select").val()
	var documento = $("#documento").val()
	var password = $("#password").val()

	const btnRegistrar = document.getElementById('btnRegistrar');

	// Guardar el texto original
	const originalText = btnRegistrar.innerHTML;

	// Desactivar el botón y mostrar el spinner
	btnRegistrar.disabled = true;
	btnRegistrar.innerHTML = `
        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
        <span class="spinner-hidden">Registrar</span>
    `;


	var datos = new FormData();
	datos.append("nombre", nombre);
	datos.append("apellidos", apellidos);
	datos.append("email", email);
	datos.append("telefono", telefono);
	datos.append("tipodoc", tipodoc);
	datos.append("documento", documento);
	datos.append("password", password);
	$.ajax({
		url: URLLOCAL + "add-new-user",
		method: "POST",
		data: datos,
		chache: false,
		contentType: false,
		processData: false,
		dataType: "json",
		success: function(respuesta) {
			var response = JSON.stringify(respuesta, null, '\t');
			var data = JSON.parse(response);
			if (data.status) {
				mensajeOK(data.resultado);
				btnRegistrar.disabled = false;
				btnRegistrar.innerHTML = 'Registrar';

			} else if (data.code == 70002) {

				Swal.fire({
					icon: "warning", // Cambiamos el icono a "warning" para que sea más apropiado
					title: "Correo ya registrado",
					text: "Ya existe un usuario registrado en el sistema con este correo. Por favor, intenta con otro correo o recupera tu contraseña.",
					confirmButtonText: "Entendido",
					confirmButtonColor: "#3085d6", // Cambiamos a un color más amigable
					iconColor: "#f39c12", // Personalizamos el color del icono para que sea distintivo
					footer: '<a href="/recuperar-contraseña" style="color: #3085d6;">¿Olvidaste tu contraseña?</a>', // Ofrecemos una opción para recuperar contraseña
				});

				btnRegistrar.disabled = false;
				btnRegistrar.innerHTML = 'Registrar';

			} else {
				mensajeErrorGenerico(data.error.menssage);
			}
		}
	})
}

function actualizarUsuario() {
	var nombre = $('#nombre').val();
	var email = $("#email").val()
	var telefono = $("#telefono").val()
	var password = $("#password").val()
	var id = $("#idUser").val()


	var datos = new FormData();
	datos.append("id", id);
	datos.append("nombre", nombre);
	datos.append("email", email);
	datos.append("telefono", telefono);
	datos.append("password", password);
	$.ajax({
		url: URLLOCAL + "update-user",
		method: "POST",
		data: datos,
		chache: false,
		contentType: false,
		processData: false,
		dataType: "json",
		success: function(respuesta) {
			var response = JSON.stringify(respuesta, null, '\t');
			var data = JSON.parse(response);
			if (data.status) {
				mensajeOK(data.resultado);
			} else {
				mensajeErrorGenerico(data.error.menssage);
			}
		}
	})
}


function validarChange(event, objeto) {

	const input = document.getElementById(objeto);

	input.addEventListener("change", updateValue(objeto));


	/*$(input).ready(function() {
		$(input).on('change', '#' + objeto, function() {
			if ($(this).val().trim() == "") {
				$('#' + objeto).addClass('is-invalid');
			} else {
				$("#" + objeto).removeClass("is-invalid");
			}
			if(validarCampos())
			$('#btnRegistrar').prop('disabled', false);
		});
	})*/
}

function updateValue(objeto) {
	if ($('#' + objeto).val().trim() == "") {
		$('#' + objeto).addClass('is-invalid');
	} else {
		$("#" + objeto).removeClass("is-invalid");
	}
	if (validarCampos())
		$('#btnRegistrar').prop('disabled', false);
}

function validarCampos() {
	var validar = true;

	if ($("#nombre").val() == "") {
		//$('#nombre').addClass('is-invalid');
		validar = false;
	} if ($("#apellidos").val() == "") {
		//$('#apellidos').addClass('is-invalid');
		validar = false;
	} if ($("#email").val() == "") {
		//$('#email').addClass('is-invalid');
		validar = false;
	} if ($("#telefono").val() == "") {
		//$('#telefono').addClass('is-invalid');
		validar = false;
	} if ($("#tipo-doc-select").val() == null) {
		//$('#tipo-doc-select').addClass('is-invalid');
		validar = false;
	} if ($("#documento").val() == "") {
		//$('#documento').addClass('is-invalid');
		validar = false;
	} if ($("#password").val() == "") {
		//$('#password').addClass('is-invalid');
		validar = false;
	} if ($("#passwordConfir").val() == "") {
		//$('#passwordConf').addClass('is-invalid');
		validar = false;
	} if (!isEqual($("#password").val(), $("#passwordConfir").val())) {
		validar = false;
	}


	return validar;

}

function validarCamposUpdate() {
	var validar = true;

	if ($("#nombre").val() == "") {
		//$('#nombre').addClass('is-invalid');
		validar = false;
	} if ($("#email").val() == "") {
		//$('#email').addClass('is-invalid');
		validar = false;
	} if ($("#telefono").val() == "") {
		//$('#telefono').addClass('is-invalid');

	} if ($("#password").val() == "") {
		//$('#password').addClass('is-invalid');
		validar = false;
	} if ($("#passwordConfir").val() == "") {
		//$('#passwordConf').addClass('is-invalid');
		validar = false;
	} if (!isEqual($("#password").val(), $("#passwordConfir").val())) {
		validar = false;
	}


	return validar;

}

function registerUser() {
	const btnRegistrar = document.getElementById('btnRegistrar');

	// Guardar el texto original
	const originalText = btnRegistrar.innerHTML;

	// Desactivar el botón y mostrar el spinner
	btnRegistrar.disabled = true;
	btnRegistrar.innerHTML = `
        <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
        <span class="spinner-hidden">Registrar</span>
    `;
	// Simular una llamada a un servidor
	setTimeout(() => {
		// Una vez finalizado, reactivar el botón y restaurar el texto
		btnRegistrar.disabled = false;
		btnRegistrar.innerHTML = 'Registrar';

		// Mostrar un mensaje de éxito o redirigir
		alert('Registro completado exitosamente');
	}, 3000); // Simula un retraso de 3 segundos
}

function toggleDocumentoInput(select) {
	const documentoInput = document.getElementById('documento');
	documentoInput.disabled = !select.value;
}

function deleteAcount() {
	var id = $("#idUser").val()


	var datos = new FormData();
	datos.append("idUsuario", id);
	$.ajax({
		url: URLLOCAL + "delete-acount",
		method: "POST",
		data: datos,
		chache: false,
		contentType: false,
		processData: false,
		dataType: "json",
		success: function(respuesta) {
			var response = JSON.stringify(respuesta, null, "\t");
			var data = JSON.parse(response);

			if (data.status) {
				mensajeDeleteAcount(data.resultado)
			} else {
				mensajeErrorGenerico(data.error.menssage);
			}
		},
	});
}

