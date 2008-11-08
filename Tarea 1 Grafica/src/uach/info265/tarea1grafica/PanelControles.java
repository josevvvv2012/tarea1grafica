package uach.info265.tarea1grafica;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


/**
 * Panel de controles visuales para la aplicación.
 * @author INFO265 - 2008
 *
 */
public class PanelControles extends JPanel {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -3846153888872283803L;

    private JSpinner jspX0;
    private JSpinner jspY0;
    private JSpinner jspX1;
    private JSpinner jspY1;
    private JCheckBox aplicarAntialias;
    private int valorDefecto = 10;

    /**
     * Instancia de objeto para gráficos.
     */
    private InterfazGraficos2D graficos;

    /**
     * Constructor de la clase.
     * @param instancia Instancia de objeto para gráficos.
     */
    public PanelControles(InterfazGraficos2D instancia) {

        graficos = instancia;

        SpinnerModel spinnerModelX0 = new SpinnerNumberModel(valorDefecto,
                                                             1,
                                                             Constantes.tamanoImagenX,
                                                             1);
        SpinnerModel spinnerModelY0 = new SpinnerNumberModel(valorDefecto,
                                                             1,
                                                             Constantes.tamanoImagenX,
                                                             1);
        SpinnerModel spinnerModelX1 = new SpinnerNumberModel(valorDefecto,
                                                             1,
                                                             Constantes.tamanoImagenX,
                                                             1);
        SpinnerModel spinnerModelY1 = new SpinnerNumberModel(valorDefecto,
                                                             1,
                                                             Constantes .tamanoImagenX,
                                                             1);
        jspX0 = new JSpinner(spinnerModelX0);
        jspY0 = new JSpinner(spinnerModelY0);
        jspX1 = new JSpinner(spinnerModelX1);
        jspY1 = new JSpinner(spinnerModelY1);

        JButton boton = new JButton("Generar segmento");
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int x0 = ((Integer)jspX0.getValue()).intValue();
                int y0 = ((Integer)jspY0.getValue()).intValue();
                int x1 = ((Integer)jspX1.getValue()).intValue();
                int y1 = ((Integer)jspY1.getValue()).intValue();
                System.out.println("Generar recta...");
                boolean aplicarAntiAlias = aplicarAntialias.isSelected();
                graficos.dibujaSegmentoAlgoritmoUno(x0, y0, x1, y1, aplicarAntiAlias);
                //graficos.dibujaSegmentoAlgoritmoDos(x0, y0, x1, y1, aplicarAntiAlias);
            }
        });

        add(jspX0);
        add(jspY0);
        add(jspX1);
        add(jspY1);
        add(boton);

        aplicarAntialias = new JCheckBox("Anti alias");
        add(aplicarAntialias);
    }
}
