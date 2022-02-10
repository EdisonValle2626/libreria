import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Inventario inventario = new Inventario();
		
		String isbn="";
		String titulo="";
		int precio = 0;
		int cantidad = 0;
		int op = -1;
		while(op!=0) 
		{
			System.out.println("\n<1> Ingresar Libro");
			System.out.println("<2> Buscar Libro por Isbn");
			System.out.println("<3> Venta de Libro");
			System.out.println("<4> Mostrar los 3 Libros más caros");
			System.out.println("<5> Mostrar todos los Libros");
			System.out.println("<0> Salir");
			ArrayList<Libro> libros = inventario.getLibros();
			System.out.println("Ingrese opción: ");
			op = sc.nextInt();  
			switch (op) 
			{
				case 1:
					// <1> Ingresar libro (verificar que el isbn no sea repetido)
					System.out.println("Ingrese un Isbn para su libro: ");
					isbn = sc.next();
					Libro result = inventario.getLibrobyIsbn(isbn);
					if(result != null) 
					{
						System.out.println("El Isbn es repetido");
					} 
					else 
					{
						System.out.println("Ingrese un Titulo para su libro: ");
						titulo = sc.next();
						System.out.println("Ingrese un precio para su libro: ");
						precio = sc.nextInt();
						System.out.println("Ingrese un cantidad de libros que almacenará: ");
						cantidad = sc.nextInt();
						Libro ll = new Libro(isbn,titulo,precio,cantidad);
						inventario.almacenar(ll);
					}	
					break;
				case 2:
					// <2> Buscar libro por el isnb
					System.out.println("Ingrese el Isbn del libro que desea buscar: ");
					isbn = sc.next();
					Libro result1 = inventario.getLibrobyIsbn(isbn);
					if(result1 != null) 
					{
						System.out.println("\n El libro que busca es:");
						System.out.println(result1);
					}
					else 
					{
						System.out.println("No se encontro el libro con el ISBN "+ isbn);
					}
					break;
				case 3:
					// <3> venta de libro
					System.out.println("¿Qué libro desea comprar? \n");
					for(Libro l: libros) 
					{
						System.out.println(l);
					}
					System.out.println("\n Ingrese el libro por su Isbn: ");
					isbn = sc.next();
					Libro result2 = inventario.getLibrobyIsbn(isbn);
					if(result2 != null) 
					{
						System.out.println("Ingrese cantidad de libros que comprará: ");
						cantidad = sc.nextInt();
						inventario.ventaLibro(result2, cantidad);;
						System.out.println("Su compra se ha realiza con exito, el libro "+isbn);
						System.out.println("Con un precio de: $"+ cantidad*result2.getPrecio());
					}
					else
					{
						System.out.println("El libro con el "+isbn+" no existe");
					}
					break;
				case 4:
					// <4> Mostrar los tres libros mas caros
					System.out.println("\n Los 3 libros más caros son: ");
					Collections.sort(libros);
					for (int i = 0; i <3; i++) {
					Libro l = libros.get(i);
						System.out.println(l);
					}
					break;				
				case 5:
					// <5> Mostrar todos los libros
					for(Libro l: libros) 
					{
						System.out.println(l);
					}
				
					break;
			}
		}	
	}
}	
