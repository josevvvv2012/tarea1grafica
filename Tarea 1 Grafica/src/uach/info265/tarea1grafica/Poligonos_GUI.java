package uach.info265.tarea1grafica;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.awt.Color;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Poligonos_GUI implements InterfazGraficos2D{

	private JFrame jFrame = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem cutMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem pasteMenuItem = null;
	private JMenuItem saveMenuItem = null;
	private JDialog aboutDialog = null;  //  @jve:decl-index=0:visual-constraint="11,423"
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JSplitPane jSplitPane = null;  //  @jve:decl-index=0:visual-constraint="8,681"
	private JPanel jPanel = null;

    /** Imagen a la cual se accede para dibujar. */
    private BufferedImage imagen = null;

    /** Instancia del lienzo para dibujo. */
    private CanvasPix lienzo = null;
	private JComboBox jComboBox = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField jTextField = null;
	private JButton jButton = null;
	

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setBounds(new Rectangle(0, 0, 1200, 780));
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setContentPane(getJSplitPane());
			jFrame.setTitle("Tarea 1 Grafica");
		}
		return jFrame;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Archivo");
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Edición");
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Ayuda");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("Acreca de...");
			aboutDialog.setBounds(new Rectangle(0, 0, 200, 200));
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("Cut");
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("Copy");
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("Paste");
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Save");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return saveMenuItem;
	}

	/**
	 * This method initializes imagen	
	 * 	
	 * @return BufferedImage
	 */
	
	private BufferedImage getBufferedImage(){
		if (imagen == null) {
			imagen = new BufferedImage(1200,600,BufferedImage.TYPE_INT_RGB);
		}
		return imagen;
	}
	
	/**
	 * This method initializes lienzo	
	 * 	
	 * @return CanvasPix	
	 */
	
	private CanvasPix getCanvasPix(){
		if (lienzo == null) {
			imagen = getBufferedImage();
			lienzo = new CanvasPix(imagen, Color.WHITE);
			ManejadorEventosMouse2D ml = new ManejadorEventosMouse2D(this);
			lienzo.addMouseListener(ml);
		}
		return lienzo;
	}
	
	
	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setDividerSize(2);
			jSplitPane.setEnabled(false);
			jSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitPane.setTopComponent(getCanvasPix());
			jSplitPane.setBottomComponent(getJPanel());
			jSplitPane.setDividerLocation(600);
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(219, 10, 106, 16));
			jLabel1.setText("Tamaño del Lado");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(10, 10, 197, 16));
			jLabel.setText("Poligonos Regulares Predefinidos");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJComboBox(), null);
			jPanel.add(jLabel, null);
			jPanel.add(jLabel1, null);
			jPanel.add(getJTextField(), null);
			jPanel.add(getJButton(), null);
		}
		return jPanel;
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
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(8, 30, 200, 25));
		}
		return jComboBox;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(220, 32, 105, 25));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(157, 63, 100, 25));
			jButton.setText("Dibujar");
		}
		return jButton;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Poligonos_GUI application = new Poligonos_GUI();
				application.getJFrame().setVisible(true);
			}
		});
	}

}
