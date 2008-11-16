package uach.info265.tarea1grafica;

import java.util.ArrayList;

/**
 * Clase de interfaz para graficar en 2D.
 *
 * @author INFO265 - 2008
 */
public interface InterfazGraficos2D {

    /**
     * Refresca la imagen una vez hecho un dibujo sobre ella.
     */
    void refrescarImagen();

    /**
     * Genera un punto sobre una imagen.
     *
     * @param posicionX La posición en x (píxeles) del punto a generar.
     * @param posicionY La posición en y (píxeles) del punto a generar.
     */
    void generarPunto(final int posicionX, final int posicionY);


    /**
     * Dibuja un segmento de recta sobre una imagen,
     * utilizando el algoritmo de Bresnham.
     *
     * @param x0 Coordenada inicial en x del segmento.
     * @param y0 Coordenada inicial en y del segmento.
     * @param x1 Coordenada final en x del segmento.
     * @param y1 Coordenada final en y del segmento.
     * @param aplicarAntiAlias Especifica si se aplica antialiasing.
     */
    void generaSegmentoRectaBresenham(final int x0,
                                      final int y0,
                                      final int x1,
                                      final int y1,
                                      final boolean aplicarAntiAlias);

    
    /*void dibujaSegmentoAlgoritmoUno(final int x0,
            						final int y0,
            						final int x1,
            						final int y1,
            						final boolean aplicarAntiAlias);
    
    void dibujaSegmentoAlgoritmoDos(final int x0,
            						final int y0,
            						final int x1,
            						final int y1,
            						final boolean aplicarAntiAlias);*/
    
    void dibujaPoligono(int nlados, float tamanoLado);
}
