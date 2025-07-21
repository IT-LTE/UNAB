//Desarrolle un algoritmo en pseudoc�digo que represente el proceso de
//conexi�n de un dispositivo a una red Wi-F��i.
Algoritmo LoginRed
	
	//contador de numero de intentos
	Definir intento Como Entero
	//variables
	Definir redUsuario, contrase�a Como Caracter
	Definir ingreso Como Logico
	
	//lista de redes disponibles
	Dimension redes[3]
	
	//crear arreglo con datos, esta alternativa deberia ser alimentada por una consulta realizada al administrador
	redes[1]="Red1"
	redes[2]="Red2"
	redes[3]="Red3"
	
	//inicializacion de variable
	intento=1
	ingreso=Falso
	
	Mientras intento<=3 y ingreso =falso Hacer
		Escribir "Ingrese nombre de la red:"
		leer redUsuario
		Escribir "ingrese contrase�a :"
		leer contrase�a
		
		Si (redUsuario<> redes[1]) y (redUsuario <> redes[2]) y (redUsuario <> redes[3]) Entonces
			intento=intento+1
		SiNo
			Si contrase�a<>"123ABC" Entonces		//aca realmente yo pondria una funcion donde contra la BBDD verifica si la contrase;a es correocta
				intento=intento+1
			SiNo
				ingreso=verdadero
			Fin Si
		Fin Si
		Si intento<=3 y ingreso=falso Entonces
			Escribir "Hubo error en el ingreso, vuelva a intentarlo" 
		Fin Si
		
	Fin Mientras
	
	//verifica si logro ingresar en los 3 intentos o si se bloqueo la cuenta
	Si ingreso=verdadero Entonces
		Escribir "Felicitaciones bienvenido a la Red  " , redUsuario
	SiNo
		Escribir "Error en el ingreso, su cuenta se ha bloqueado"
	Fin Si
	
	
//	Si el nombre de la red (SSID) ingresado no existe, mostrar un
//		mensaje de error.
	
FinAlgoritmo
