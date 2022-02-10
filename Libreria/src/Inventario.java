import java.util.ArrayList;

public class Inventario {
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public void almacenar(Libro libro) {
		libros.add(libro);
	}
	
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) 
		{
			if(l.getIsbn().equals(isbn)) 
			{
				return l;
			}
		}
		return null;
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void ventaLibro(Libro libro, int cantidad) {
		cantidad = libro.getCantidad()-cantidad;
		libro.setCantidad(cantidad);
	}	
}
