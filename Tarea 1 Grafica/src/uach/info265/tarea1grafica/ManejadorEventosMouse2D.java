package uach.info265.tarea1grafica;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ManejadorEventosMouse2D implements MouseListener {

    /**
     * Clase para dibujo de puntos y líneas.
     */
    private InterfazGraficos2D formas;
    
    private int cont = 0;
    private int x0_ant = -1;
    private int y0_ant = -1;

    /**
     * Constructor de la clase.
     *
     * @param formas Clase para dibujo de puntos y líneas.
     */
    public ManejadorEventosMouse2D(InterfazGraficos2D formas) {
        this.formas = formas;
    }

    public void mouseClicked(MouseEvent arg0) {
        /*
        System.out.println("Evento mouseClicked en ["
                           + arg0.getX() + ","
                           + arg0.getY() + "]");
                           */
        //formas.generarPunto(arg0.getX(), arg0.getY());
    	System.out.println("Captura de puntos");
    	System.out.println("x0 anterior: " + x0_ant);
    	System.out.println("y0 anterior: " + y0_ant);
        
    	if(cont == 0 || arg0.getX() == x0_ant){
    		formas.generarPunto(arg0.getX(), arg0.getY());
    	}
    	else{
    		if(cont%2==0){
    			formas.dibujaSegmentoAlgoritmoDos(x0_ant, y0_ant, arg0.getX(), arg0.getY(), false/*aplicarAntiAlias*/);
    		}
    		else{
    			formas.dibujaSegmentoAlgoritmoUno(x0_ant, y0_ant, arg0.getX(), arg0.getY(), false/*aplicarAntiAlias*/);
    		}
    	}
    	x0_ant = arg0.getX();
    	y0_ant = arg0.getY();
    	cont++;
    	
    	
    	System.out.println("x1 nuevo: " + arg0.getX());
    	System.out.println("y1 nuevo: " + arg0.getY());
    	System.out.println("Contador: " + cont);
    	
    	formas.refrescarImagen();
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent arg0) {
        /*
        System.out.println("Evento mousePressed en ["
                           + arg0.getX() + ","
                           + arg0.getY() + "]");
                           */
    }

    public void mouseReleased(MouseEvent arg0) {
        /*
        System.out.println("Evento mouseReleased en ["
                           + arg0.getX() + ","
                           + arg0.getY() + "]");
                           */
    }

}
