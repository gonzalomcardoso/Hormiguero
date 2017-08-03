package Ejercicio2.ElHormiguero;


public class Dado {
	private int minimum;
	private int maximum;
	int valor;
	Dado(int minimum, int maximum)
	{
		this.minimum=minimum;
		this.maximum=maximum;
		
	}
	
	public int tirar()
	{
		 this.valor=minimum + (int)(Math.random()*maximum);;
		 return valor;
		
	}
	public String toString()
	{
		return ""+valor;
	}

}
