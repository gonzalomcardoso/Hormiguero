package Ejercicio2.ElHormiguero;


public class Hormiga {
	Integer id;
	String nombre;

public Hormiga(int id, String nombre)
{
	this.id= id;
	this.nombre= nombre;
	
}
public String toString ()
{
	return "La hormiga "+nombre+" esta en el casillero: "+id;
}
public String imprimir()
{
	return "[ H"+id+" ]";
}
}
