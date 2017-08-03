package Ejercicio2.ElHormiguero;
import java.util.Random;

public class Hormiguero {
	//Variables
	private Tablero hormiguero;
	private Hormiga[] jugador;//id nombre
	private int cant_jugadas; //x=id_jugador y=cant_jugadas
	private Tupla[] actual;//x=id_jugador y=posicion actual
	
	Hormiguero(int tamano)//2 jugadores por default
	{
		this.hormiguero= new Tablero(tamano);
		int j=2;//j es el numero de jugadores que por default es 2
		this.cant_jugadas= 0;
        //inicializo actual por default con 2 jugadores
		this.actual= new Tupla[j];
		this.actual[0]=new Tupla(1,0);//1=Jugador 0=posicion actual inicial del jugador
        this.actual[1]=new Tupla(2,0);//2=Jugador 0=posicion actual inicial del jugador
        //inicializo jugador por default son 2
        this.jugador=new Hormiga[j];
        this.jugador[0]= new Hormiga(1,"jugador"+1);//1=Numero del jugador " "=Nombre del jugador
        this.jugador[1]= new Hormiga(2,"jugador"+2);//1=Numero del jugador " "=Nombre del jugador
	}
    Hormiguero(int tamano,int jugadores)//Podes agregar los jugadores que quieras
    {//Inicializo las variables
        this.hormiguero= new Tablero(tamano);
        int j=jugadores;
        this.cant_jugadas= 0;
        this.actual= new Tupla[j];
        this.jugador=new Hormiga[j];
        for(int i=1;i<=j;i++)//por cada jugador se creará una instancia de los siguientes atributos
        {//inicializo x cada jugador
        	this.actual[i-1]=new Tupla(i,0);//1=Jugador 0=posicion actual inicial del jugador
        	this.jugador[i-1]= new Hormiga(i,"jugador"+i);//"Nombre del jugador"+Numero
        }
    }

    public int ultimaCasilla()
    {
    	int aux=0;
    	for (int i=1; i<=actual.length;i++)
    	{
    		if (this.posicionJugador(i)>aux)
    		    	aux=this.posicionJugador(i);
    	}
    	return aux;
    }
    
    public void agregarAtajo(int desde, int hasta )
    {
    	hormiguero.agregarAtajo(desde, hasta);	
    }
    
    public void jugar()
    {
    	Dado dado= new Dado(1, 5);
		this.sumarJugada();
    	for (int j=1;j<=jugador.length;j++)
    	{
    		if(this.hormiguero.hayDesbordamiento(this.posicionJugador(j)+dado.tirar()))
    		{
    			this.gano(j);
    			//System.out.println(this.posicionJugador(j));
    		}//fin if
    		else
    		{//Mueve a la posicion que suma con el dado
    			this.moverJugador(this.posicionJugador(j)+dado.valor, j);
    			//System.out.println(this.posicionJugador(j));
    			//Verifica atajo
    			if(this.hormiguero.hayAtajo(this.posicionJugador(j)))
    			{
    				this.moverJugador(this.hormiguero.getAtajo(this.posicionJugador(j)),j);
    				//System.out.println(this.posicionJugador(j));
    			}//fin if
    			
    		}//fin else
    	}//fin for		
    						
    }


    public String ver(){
    	boolean ganador=false;
        String msj="";
        for(int j=1;j<=jugador.length;j++){
        	for (int i=0;i<hormiguero.tamano();i++)
        	{
                if(this.posicionJugador(j)==i)//Ubica la hormiga en el tablero
                {
                    msj+=jugador[j-1].imprimir();
                }
                else
                {
                    msj+=hormiguero.imprimir(i);                                 
                }
        	}
        	if(this.posicionJugador(j)==hormiguero.tamano())//Se fija si la hormiga gano
        	{
        		if(ganador==false)//Se fija cual de las hormigas llega primero
        		{
        			ganador=true;
        			msj+=jugador[j-1].imprimir()+"GANO!!!";
        		}
        		else
        			msj+=jugador[j-1].imprimir();
        	}
        	else
        		msj+="[META]";
        	msj+="  ";
        }   
      return msj;
    }

    public void gano(int jugador)
    {
    	this.moverJugador(hormiguero.tamano(), jugador);//Muevo al final del hormiguero al jugador
    	
    	
    }
    
    public int cantJugadas(int jugador){	
        return this.cant_jugadas;
    }
    
    public int posicionJugador(int jugador)
    {
    	return this.actual[jugador-1].y;
    }
    public void moverJugador(int posicion, int jugador)
    {
    	this.actual[jugador-1].y=posicion;
    }
    public void sumarJugada()
    {
    	this.cant_jugadas++;
    }
        
    
    
    
    
        
    }
    
