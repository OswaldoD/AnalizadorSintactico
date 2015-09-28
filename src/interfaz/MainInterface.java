package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import logic.Scanner;

import javax.swing.JTextPane;

import java.awt.Scrollbar;

public class MainInterface extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnArchivo,mnCargarMatriz;
	private JMenuBar menuBar;
	private JMenuItem mntmAbrirArchivo, mntmSalir, mntmAbrirMTransicion, mntmAbrirMFinales, mntmInicializarScanner;
	private String rutaArchivo, rutaTransiciones, rutaEFinales;
	private Scanner Scanner;
	private JTextPane txtpnOutput;
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
		super("Scanner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		createMenuBar();
		createTextPane();
	}
	private void createMenuBar(){
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmAbrirArchivo = new JMenuItem("Abrir archivo");
		mntmAbrirArchivo.addActionListener(this);
		mnArchivo.add(mntmAbrirArchivo);
		
		mntmInicializarScanner = new JMenuItem("Iniciar Scanner");
		mntmInicializarScanner.addActionListener(this);
		mnArchivo.add(mntmInicializarScanner);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
	
		/*
		mnCargarMatriz = new JMenu("Cargar Automata");
		menuBar.add(mnCargarMatriz);
		
		mntmAbrirMTransicion = new JMenuItem("M Transiciones");
		mntmAbrirMTransicion.addActionListener(this);
	    mnCargarMatriz.add(mntmAbrirMTransicion);
	    
	    mntmAbrirMFinales = new JMenuItem("Estados Finales");
	    mntmAbrirMFinales.addActionListener(this);
	    mnCargarMatriz.add(mntmAbrirMFinales);*/
		
	}
	private void createTextPane(){
		
		txtpnOutput = new JTextPane();
		txtpnOutput.setEditable(false);
		txtpnOutput.setBounds(40, 25, 500, 280);
		contentPane.add(txtpnOutput);
		
		JScrollPane scrollbar = new JScrollPane(txtpnOutput);
		//scrollbar.setVisible(true);
		scrollbar.setBounds(40, 25, 500, 280);
		contentPane.add(scrollbar);
		
		ArrayList<String> p = new ArrayList<String>();
		
		p.add("Hola");
		p.add("Como");
		p.add("Estas");
		for(int i = 0; i<1; i++){
			p.add("0");
		}
		txtpnOutput.setText(showInfoTextPane(p));
		

		
	}
	private String showInfoTextPane(ArrayList<String> lineas){
		String show = "";
		
		for(int i = 0; i< lineas.size(); i++){
			show += lineas.get(i);
			show += "\n";
		}
		
		return show;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == mntmAbrirArchivo){
			
			 // Extension del archivo
			 JFileChooser chooser = new JFileChooser();
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("chirripö files", "chi");
			 chooser.setFileFilter(filter);
			 
             if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                 // carga archivo de codigo
            	 
            	 File file = chooser.getSelectedFile();
            	 rutaArchivo = file.getPath();
            	 
            	 rutaTransiciones = "src/data/mt.txt";
            	 
            	 rutaEFinales = "src/data/finales.txt";

 				if((rutaArchivo!=null)&&(rutaTransiciones!=null)&&(rutaEFinales!=null)){
 					
 	 				 JOptionPane.showMessageDialog(null,"Archivo cargado exitosamente",
 	  						  "Archivo cargado",JOptionPane.WARNING_MESSAGE);
 					Scanner = new Scanner(rutaArchivo, rutaTransiciones, rutaEFinales);
 					
 				} else {
 					JOptionPane.showMessageDialog(null,"Error en el archivo, revise que se hayan cargado correctamente",
 	 						  "Error al cargar el archivo",JOptionPane.ERROR_MESSAGE);
 				}

            	 
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
			

		}
	}
}
