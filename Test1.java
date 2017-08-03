package Ejercicio2.ElHormiguero;

public class Test1 {

    public static void main(String[] args) {
        
        Hormiguero m = new Hormiguero(9);  //Instancia; n ==8 
        m.agregarAtajo(1,6);//atajo desde 6 hasta 1
        m.agregarAtajo( 7,3);//atajo desde 3  hasta 7
        while( m.ultimaCasilla()<= 8){
           
            m.jugar();
          
            System.out.println(m.ver());//muestra un resumen del hormiguero
        }
        System.out.println(" "+m.cantJugadas(1)+" veces para llegar al final");/**/
    }
}
