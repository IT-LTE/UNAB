Algoritmo registro
	
	Definir perfil Como Caracter
	Definir i, nusuario Como Entero
	
	//se utilizan arrelos para guardar la data, la idea es guarda en la ubicacion especifica el valor
	Dimensionar nombre[100], fechanac[100], run[100]
	Dimensionar direccion[100], telefono[100], empleados[100] 
	Dimensionar experiencia[100], departamento[100] 
	Dimensionar puesto[100], jefe[100]
	
	Escribir ("Cuantos usuarios desea agregar")
	Leer nusuario
	
	//se utiliza ciclo for para ingresar a las personas indicadas anteriormente
	Para i<-1 Hasta nusuario Con Paso 1 Hacer
		Escribir "Ingrese el tipo de usuario (cliente / profesional / administrativo):"
		Leer perfil
		
		//se deben leer los datos comunes de los usuarios
		Escribir "Ingrese el nombre:"
		Leer nombre[i]
		Escribir "Ingrese la fecha de nacimiento (DD/MM/AAAA):"
		Leer fechanac[i]
		Escribir "Ingrese el RUN:"
		Leer run[i]
		
		//segun el perfil ingresado se piden los datos que corresponden
		Segun perfil Hacer
			"cliente":
				Escribir "Ingrese la dirección:"
				Leer direccion[i]
				Escribir "Ingrese el teléfono:"
				Leer telefono[i]
				Escribir "Ingrese la cantidad de empleados:"
				Leer empleados[i]
				
			"profesional":
				Escribir "Ingrese los años de experiencia:"
				Leer experiencia[i]
				Escribir "Ingrese el departamento:"
				Leer departamento[i]
				
			"administrativo" :
				Escribir "Ingrese la función:"
				Leer puesto[i]
				Escribir "Ingrese el nombre del superior:"
				Leer jefe[i]
				
			De Otro Modo:
				Escribir "Tipo de usuario no es válido. por favor revisar el perfil"
				
		Fin Segun
		
	Fin Para
	Escribir "Felicitaciones termino de ingresar los ", nusuario, " Usuarios"
				
FinAlgoritmo
