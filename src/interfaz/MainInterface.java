package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import logic.Scanner;

public class MainInterface extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnArchivo,mnCargarMatriz;
	private JMenuBar menuBar;
	private JMenuItem mntmAbrirArchivo, mntmSalir, mntmAbrirMTransicion, mntmAbrirMFinales;
	private String rutaArchivo, rutaTransiciones, rutaEFinales;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainInterface() {
		super("Analizador Sintáctico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		createMenuBar();
	}
	private void createMenuBar(){
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mnCargarMatriz = new JMenu("Cargar Automata");
		menuBar.add(mnCargarMatriz);
		
		mntmAbrirArchivo = new JMenuItem("Abrir archivo");
		mntmAbrirArchivo.addActionListener(this);
		mnArchivo.add(mntmAbrirArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mntmAbrirMTransicion = new JMenuItem("M Transiciones");
		mntmAbrirMTransicion.addActionListener(this);
	    mnCargarMatriz.add(mntmAbrirMTransicion);
	    
	    mntmAbrirMFinales = new JMenuItem("Estados Finales");
	    mntmAbrirMFinales.addActionListener(this);
	    mnCargarMatriz.add(mntmAbrirMFinales);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mntmAbrirArchivo){
			
			 // Extension del archivo
			 JFileChooser chooser = new JFileChooser();
			 FileNameExtensionFilter filter = new FileNameExtensionFilter(
			            "chirripö files", "chi");
			 chooser.setFileFilter(filter);
			 
             if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                 // carga archivo de codigo
            	 
            	 File file = chooser.getSelectedFile();
            	 rutaArchivo = file.getPath();

 				 JOptionPane.showMessageDialog(null,"Archivo cargado exitosamente",
  						  "Archivo cargado",JOptionPane.WARNING_MESSAGE);
            	 
             }
			if((rutaArchivo!=null)&&(rutaTransiciones!=null)&&(rutaEFinales!=null)){
				Scanner scanner = new Scanner(rutaArchivo, rutaTransiciones, rutaEFinales);
			}
			else{
				JOptionPane.showMessageDialog(null,"Error en el archivo, revise que se hayan cargado correctamente",
 						  "Error al cargar el archivo",JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		else if(e.getSource() == mntmSalir){
			dispose();
		}
		
		else if(e.getSource() == mntmAbrirMTransicion){
			//abrir menu para cargar el archivo de transiciones
			/*
			JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                // do something
           	 
           	 
           	 File file = chooser.getSelectedFile();
           	 rutaTransiciones = file.getPath();
           	 
            }*/
			rutaTransiciones = "src/data/mt.txt";
		}
		else if(e.getSource() == mntmAbrirMFinales){
			// abrir menu para cargar el archivo de estados finales
			/*
			JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                // do something
           	 
           	
           	 File file = chooser.getSelectedFile();
           	 rutaEFinales = file.getPath();
           	 
            }*/
			rutaEFinales = "src/data/finales.txt";

		}
	}
}
