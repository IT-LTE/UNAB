Algoritmo EntregarActividadConLogin
	
    Definir usuario, contrasena Como Cadena
    Definir usuarioCorrecto, contrasenaCorrecta Como Cadena
    Definir archivo, nombre_correcto Como Cadena
    Definir archivo_correcto Como Logico
    Definir intentos Como Entero
	
    // Credenciales almacenadas (simulando una base de datos)
    usuarioCorrecto <- "admin"
    contrasenaCorrecta <- "12345"
	
    intentos <- 0
	
    // Inicio de sesi�n con validaci�n de usuario y contrase�a
    Repetir
        Escribir "Ingrese su nombre de usuario:"
        Leer usuario
        Escribir "Ingrese su contrase�a:"
        Leer contrasena
		
        Si usuario = usuarioCorrecto Y contrasena = contrasenaCorrecta Entonces
            Escribir "Inicio de sesi�n exitoso. Bienvenido ", usuario
        Sino
            intentos <- intentos + 1
            Escribir "Usuario o contrase�a incorrectos. Intento ", intentos, " de 3."
        FinSi
    Hasta Que (usuario = usuarioCorrecto Y contrasena = contrasenaCorrecta) O intentos = 3
	
    Si intentos = 3 Entonces
        Escribir "Demasiados intentos fallidos. Acceso denegado."
    Sino
        // Continuar con el proceso de entrega
        Escribir "Navegando al m�dulo correspondiente..."
        Escribir "Abriendo la actividad que desea entregar..."
        Escribir "Clic en Agregar entrega"
		
        // Selecci�n y validaci�n del archivo
        Escribir "Ingrese el nombre del archivo que desea entregar:"
        Leer archivo
        Escribir "Ingrese el nombre correcto del archivo esperado:"
        Leer nombre_correcto
		
        Si archivo = nombre_correcto Entonces
            archivo_correcto <- Verdadero
        Sino
            archivo_correcto <- Falso
        FinSi
		
        // Confirmaci�n de entrega
        Si archivo_correcto Entonces
            Escribir "Archivo correcto. Haciendo clic en Guardar cambios..."
            Escribir "Entrega realizada exitosamente."
        Sino
            Escribir "Nombre del archivo incorrecto. Por favor, seleccione el archivo correcto e intente nuevamente."
        FinSi
    FinSi
	
FinAlgoritmo
