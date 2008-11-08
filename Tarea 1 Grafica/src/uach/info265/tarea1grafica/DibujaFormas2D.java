package uach.info265.tarea1grafica;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;

import javax.swing.JFrame;


/**
 * Clase para dibujo de formas en 2D.
 *
 * @author INFO265 - 2008
 */
public class DibujaFormas2D implements InterfazGraficos2D {

    /** Margen de tamaño en y para generar una ventana (marco) de despliegue. */
    private static int margenY = 22;

    /** Ventana de visualización. */
    private JFrame frame;

    /** Imagen a la cual se accede para dibujar. */
    private BufferedImage imagen;

    /** Instancia del lienzo para dibujo. */
    private CanvasPix lienzo;

    /** Color de fondo para imágenes generadas. */
    public Color colorFondo = Color.blue;

    /**
     * @param titulo Título para el marco.
     */
    public DibujaFormas2D(final String titulo) {
        frame = new JFrame(titulo);
        imagen = new BufferedImage(Constantes.tamanoImagenX,
                                   Constantes.tamanoImagenY,
                                   BufferedImage.TYPE_INT_RGB);

        /* Se crea un lienzo con la imagen. */
        lienzo = new CanvasPix(imagen, this.colorFondo);
        frame.add("Center", lienzo);

        frame.add("South", new PanelControles(this));
        frame.setSize(new java.awt.Dimension(Constantes.tamanoImagenX,
                                             Constantes.tamanoImagenY + margenY));

        VentanaCierre vc = new VentanaCierre();
        frame.addWindowListener(vc);

        ManejadorEventosMouse2D ml = new ManejadorEventosMouse2D(this);
        lienzo.addMouseListener(ml);
        frame.setVisible(true);
    }

    /**
     * Refresca la imagen una vez hecho un dibujo sobre ella.
     */
    public void refrescarImagen() {
        lienzo.repaint();
    }

    /**
     * Genera una imagen de color plano con un punto sobre ella.
     *
     * @param posicionX La posición en x (píxeles) del punto a generar.
     * @param posicionY La posición en y (píxeles) del punto a generar.
     */
    public void generarPunto(final int posicionX, final int posicionY) {

        WritableRaster wr = imagen.getRaster();
        int[] coloresRGB = new int[3];
        coloresRGB[0] = 255;
        System.out.println("generarPunto: setPixel en ["
                           + posicionX + "," + posicionY + "]");
        wr.setPixel(posicionX, posicionY, coloresRGB);
        refrescarImagen();
    }

    /**
     * Dibuja un segmento de recta sobre una imagen de color plano como fondo.
     *
     * @param x0 Coordenada inicial en x del segmento.
     * @param y0 Coordenada inicial en y del segmento.
     * @param x1 Coordenada final en x del segmento.
     * @param y1 Coordenada final en y del segmento.
     */
    public void generaSegmentoRecta(final int x0,
                                    final int y0,
                                    final int x1,
                                    final int y1) {

        WritableRaster wr = imagen.getRaster();
        int[] coloresRGB = new int[3];
        coloresRGB[0] = 255;
        // TODO 1 Implemente un algoritmo cualquiera para generación del segmento. Considere todos los casos posibles.
        refrescarImagen();

    }

    /**
     * Dibuja un segmento de recta sobre una imagen de color plano como fondo,
     * utilizando el algoritmo de Bresenham.
     *
     * @param x0 Coordenada inicial en x del segmento.
     * @param y0 Coordenada inicial en y del segmento.
     * @param x1 Coordenada final en x del segmento.
     * @param y1 Coordenada final en y del segmento.
     * @param aplicarAntiAlias Especifica si se aplica antialiasing.
     */
    public void generaSegmentoRectaBresenham(final int x0,
                                             final int y0,
                                             final int x1,
                                             final int y1,
                                             final boolean aplicarAntiAlias) {

        WritableRaster wr = imagen.getRaster();
        int[] coloresRGB = new int[3];
        coloresRGB[0] = 255;
        // TODO 2 Implemente el algoritmo de Bresenham. Considere todos los casos posibles con respecto a pendientes y coordenadas de extremos.

        ArrayList < int[] > listaPuntos = new ArrayList < int[] >();

        // TODO 2.5 Definir y almacenar puntos del segmento en un arreglo.
        int[] puntoInicial = new int[2];
        puntoInicial[0] = -1;
        puntoInicial[1] = -1;
        listaPuntos.add(puntoInicial);

        if (aplicarAntiAlias) {
            aplicarAntialiasSegmento(listaPuntos);
        }
        refrescarImagen();
    }
    
    public void dibujaSegmentoAlgoritmoUno(final int x0,
            final int y0,
            final int x1,
            final int y1,
            final boolean aplicarAntiAlias) {
    	
    	//Bresenham
    	System.out.println("generarRectaBresenham: desde ["
                + x0 + "," + y0 + "] hasta [" + x1 + "," + y1 + "]");
    	WritableRaster wr = imagen.getRaster();
        int[] coloresRGB = new int[3];
        coloresRGB[0] = 255;
        ArrayList < int[] > listaPuntos = new ArrayList < int[] >();
        
        int a0 = x0;
        int b0 = y0;
        int a1 = x1;
        int b1 = y1;
        
        boolean steep;
        if(Math.abs(b1 - b0) > Math.abs(a1 - a0))
        	steep = true;
        else
        	steep = false;
        
        if (steep){
        	int temp = a0;
        	a0 = b0;
        	b0 = temp;
        	temp = a1;
        	a1 = b1;
        	b1 = temp;
        }
        if (a0 > a1){
        	int temp = a0;
        	a0 = a1;
        	a1 = temp;
        	temp = b0;
        	a0 = b1;
        	b1 = temp;
        }
        int deltax = a1 - a0;
        int deltay = Math.abs(b1 - b0);
        int error = deltax / 2;
        int ystep;
        int y = b0;
        if (b0 < b1)
        	ystep = 1; 
        else 
        	ystep = -1;
        for (int i=a0;i<a1+1;i++){
            if (steep){
            	wr.setPixel(y, i, coloresRGB);
            	int[] punto = new int[2];
    	        punto[0] = y;
    	        punto[1] = i;
    	        listaPuntos.add(punto);
            }
            else{
            	wr.setPixel(i, y, coloresRGB);
            	int[] punto = new int[2];
    	        punto[0] = i;
    	        punto[1] = y;
    	        listaPuntos.add(punto);
            }
            error = error - deltay;
            if (error < 0){
                y = y + ystep;
                error = error + deltax;
            }
        }
        
        if (aplicarAntiAlias) {
            aplicarAntialiasSegmento(listaPuntos);
        }
        refrescarImagen();	
    }
    
    public void dibujaSegmentoAlgoritmoDos(final int x0,
            								final int y0,
								            final int x1,
								            final int y1,
								            final boolean aplicarAntiAlias) {
    	//DDA
    	System.out.println("generarRectaDDA: desde ["
                + x0 + "," + y0 + "] hasta [" + x1 + "," + y1 + "]");
    	WritableRaster wr = imagen.getRaster();
        int[] coloresRGB = new int[3];
        coloresRGB[0] = 255;
        ArrayList < int[] > listaPuntos = new ArrayList < int[] >();
        
        int i;
        int yi = y0;
        int yf = -(x1-x0);
        int mi = (y1-y0)/(x1-x0);
        int mf = 2*((y1-y0)%(x1-x0));
        int z = -2*(x1-x0);
        for (i=x0;i<=x1;i++){
        	wr.setPixel(i, yi, coloresRGB);
        	int[] punto = new int[2];
	        punto[0] = i;
	        punto[1] = yi;
	        listaPuntos.add(punto);
	        yi = yi + mi;
	        yf = yf + mf;
	        if(yf > 0){
	        	yf += z;
	        	yi++;
	        }
	        	
        }
        
        if (aplicarAntiAlias) {
            aplicarAntialiasSegmento(listaPuntos);
        }
        refrescarImagen();
    	
    }
    
    
    /**
     * Método para aplicar antialias sobre la imagen de la clase, dada una lista
     * de puntos que componen un segmento de recta.
     *
     * @param listaPuntos Lista de puntos que representa al segmento de recta.
     */
    private void aplicarAntialiasSegmento(final ArrayList < int[] > listaPuntos) {
        WritableRaster raster = imagen.getRaster();
        int[] valorRGB;

        System.out.println("Tamaño de la lista de puntos de entrada: "
                           + listaPuntos.size());
        int[][] matrizConvolucion = new int[3][3];
        int ponderacion = 16;
        matrizConvolucion[0][0] = 1;
        matrizConvolucion[0][1] = 2;
        matrizConvolucion[0][2] = 1;
        matrizConvolucion[1][0] = 2;
        matrizConvolucion[1][1] = 4;
        matrizConvolucion[1][2] = 2;
        matrizConvolucion[2][0] = 1;
        matrizConvolucion[2][1] = 2;
        matrizConvolucion[2][2] = 1;

        // TODO 3 Implemente la convolución para aplicar antialias.

        for (int i = 0; i < listaPuntos.size(); i++) {
            int[] punto = listaPuntos.get(i);
            valorRGB = raster.getPixel(punto[0], punto[1], new int[3]);
            System.out.println("\nProcesar píxel ["
                               + punto[0] + "," + punto[1] + "]"
                               + " - Valor RGB: ["
                               + valorRGB[0] + ","
                               + valorRGB[1] + ","
                               + valorRGB[2] + "]");
        }
    }

    /**
     * Método main de la clase.
     * @param args Argumentos. No utilizados actualmente.
     */
    public static void main(final String[] args) {
        new DibujaFormas2D("Ejemplo");
    }

}
