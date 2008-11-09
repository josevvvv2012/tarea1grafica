/**
 * 
 */
package uach.info265.tarea1grafica;

import java.util.ArrayList;

/**
 * @author Carlos Blaña
 * @author Maryella Fuentes
 *
 */
public class PoligonosPredefinidos {
	private ArrayList<int[]> listaPuntos;
	private int nLados;
	private double area;
	private double perimetro;
	
	public PoligonosPredefinidos(ArrayList<int[]> listaPuntos){
		this.listaPuntos = listaPuntos;
		this.nLados = this.listaPuntos.size();
		this.area = calculaArea();
		this.perimetro = calculaPerimetro();
	}
	
	private double calculaPerimetro(){
		return perimetro;
	}
	
	private double calculaArea(){
		return area;
	}
}