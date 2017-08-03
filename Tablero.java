package Ejercicio2.ElHormiguero;

public class Tablero {
//Variables	
	private int[] atajos; //atajo[desde]= hasta
	private int n=0;
	
public Tablero(int tamano)
{//tamano del tablero. Creo el tablero 
	this.n=tamano;
	this.atajos = new int[n];//Crea atajos del tamaño de todas las casillas 
	for (int i = 0;i<n;i++)
	{
		this.atajos[i]=0;
		
	}
}

public int tamano()
{
	return this.n;
}

public void agregarAtajo(int desde ,int hasta)
{    
  if (!this.hayDesbordamiento(desde)&&!this.hayDesbordamiento(hasta))
	  this.atajos[desde]=hasta;    
}

public int getAtajo(int posicion) {
    return atajos[posicion];
}

public boolean hayAtajo(int posicion){
	
     if(atajos[posicion]!=0)
    	 return true;
     return false;
}

public boolean hayDesbordamiento(int posicion)
{
	if (posicion<1 || posicion>=tamano())	
	return true;
	return false;
}

public String imprimir(int n)
{	
	
	return "[ "+n+" ]";
}
	
}
