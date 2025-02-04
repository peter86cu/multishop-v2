function changeImage(imagePath) {
    const mainImage = document.getElementById("mainImage");
    mainImage.src = imagePath;
}

function selectColor(color) {
    alert(`Color seleccionado: ${color}`);
}

async function cargarPreguntasYRespuestas() {
    const preguntasContainer = document.getElementById("preguntas-container");
    preguntasContainer.innerHTML = '<p>Cargando preguntas y respuestas...</p>'; // Indicador de carga
    var productId= getQueryVariable("id");
    try {
        const response = await fetch(`/get-preguntas-respuestas?productId=${productId}`);
        if (!response.ok) {
            throw new Error("Error al obtener las preguntas y respuestas");
        }

        const data = await response.json();

        if (!data.preguntasRespuestas || data.preguntasRespuestas.length === 0) {
            preguntasContainer.innerHTML = '<p>No hay preguntas para este producto.</p>';
            return;
        }

        let contenidoHTML = "";
        data.preguntasRespuestas.forEach((pregunta) => {
            contenidoHTML += `
                <div class="media mb-4">
                    <img src="img/user.jpg" alt="User" class="img-fluid mr-3" style="width: 45px;">
                    <div class="media-body">
                        <h6>
                            Usuario ${pregunta.usuarioPregunta.name} 
                            <small><i>Hace ${calcularDias(pregunta.fechaPregunta)} días</i></small>
                        </h6>
                        <p>${pregunta.pregunta}</p>
                        ${
                            pregunta.respuesta
                                ? `<small class="text-primary">Respuesta del vendedor: ${pregunta.respuesta}</small>`
                                : '<small class="text-danger">Aún no hay respuesta del vendedor.</small>'
                        }
                    </div>
                </div>
                <hr />
            `;
        });

        preguntasContainer.innerHTML = contenidoHTML;
    } catch (error) {
        preguntasContainer.innerHTML = `<p>Error al cargar las preguntas: ${error.message}</p>`;
        console.error(error);
    }
}

// Calcula los días desde una fecha
function calcularDias(fecha) {
    const fechaPregunta = new Date(fecha);
    const hoy = new Date();
    const diferencia = Math.floor((hoy - fechaPregunta) / (1000 * 60 * 60 * 24)); // Diferencia en días
    return diferencia;
}

async function enviarPregunta(event) {
    event.preventDefault(); // Evita el envío predeterminado del formulario

    const pregunta = document.getElementById("pregunta").value;
    const productId = getQueryVariable("id"); // Reemplazar con el ID dinámico del producto
    
    if (!pregunta.trim()) {
    mensajeErrorGenerico("La pregunta no puede estar vacía.");
    return;
}


const userId = sessionStorage.getItem("userId");
if (!userId) {
    mensajeErrorGenerico("Debes iniciar sesión para enviar una pregunta.");
    return;
}


    try {
        const response = await fetch('/send-preguntas-respuestas', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                idProducto: productId,
                idUsuarioPregunta: userId , // Reemplazar dinámicamente
                pregunta: pregunta
            })
        });

        if (!response.ok) {
            throw new Error("Error al guardar la pregunta");
        }

        const data = await response.json();
        alert("Pregunta enviada con éxito");
        document.getElementById("pregunta").value = ""; // Limpiar el campo
        cargarPreguntasYRespuestas(productId); // Recargar las preguntas
    } catch (error) {
        console.error(error);
        alert("Error al enviar la pregunta");
    }
}


document.getElementById('btn-left').addEventListener('click', function () {
    const container = document.getElementById('productos-container');
    container.scrollLeft -= 300; // Desplazar hacia la izquierda
});

document.getElementById('btn-right').addEventListener('click', function () {
    const container = document.getElementById('productos-container');
    container.scrollLeft += 300; // Desplazar hacia la derecha
});


function handleProductClick(element) {
    const productId = element.getAttribute('data-product-id');
    if (productId) {
        linkEnvioDetalleProducto('detail', productId, null);
    }
}

