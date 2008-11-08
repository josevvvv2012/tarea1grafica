package uach.info265.tarea1grafica;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Utilizado para la asignatura
 * INFO265 - Computación Gráfica
 * Universidad Austral de Chile
 * 2008
 *
 * Documentación de la versión original:
 *
 * This class is for enabling the closing of a window.
 *
 * @author Frank Klawonn
 * Last change 07.01.2005
 */
public class VentanaCierre extends WindowAdapter {
    /**
     * Manejador del evento de cierre de ventana.
     *
     * @param e El evento de cierre recibido.
     */
    public void windowClosing(final WindowEvent e) {
        System.exit(0);
    }
}
