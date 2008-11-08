package uach.info265.tarea1grafica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Clase para despliegue de gráficos.
 *
 * @author INFO265 - 2008
 */
public class CanvasPix extends Canvas {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1417616277251346625L;

    /**
     * Imagen que se depliega sobre el lienzo.
     */
    private BufferedImage imagen = null;

    /**
     * Color de fondo del lienzo.
     */
    private Color colorFondo = null;

    /**
     * Constructor de la clase.
     *
     * @param imagen La imagen a desplegar.
     * @param color El color de fondo.
     */
    public CanvasPix(final BufferedImage imagen, final Color color) {
        this.imagen = imagen;
        this.colorFondo = color;
    }

    /**
     * Método para rellenar el contenido del lienzo.
     *
     * @param g El objeto de gráficos para desplegar la imagen.
     */
    public void paint(java.awt.Graphics g) {
        boolean result = g.drawImage(imagen, 0, 0, colorFondo, null);
        if (result == false) {
            System.out.println("Error al dibujar la imagen.");
            System.out.println("¿La imagen de entrada es nula? "
                               + (imagen == null));
            System.out.println("¿El color de fondo es nulo? "
                               + (colorFondo == null));
        }
    }
}
