package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainInterface extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnNewMenu;
	private JMenuBar menuBar;
	private JMenuItem mntmAbrirArchivo, mntmSalir;
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
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmAbrirArchivo = new JMenuItem("Abrir archivo");
		mntmAbrirArchivo.addActionListener(this);
		mnNewMenu.add(mntmAbrirArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnNewMenu.add(mntmSalir);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mntmAbrirArchivo){
			
			 JFileChooser chooser = new JFileChooser();
             if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                 // do something
            	 File file = chooser.getSelectedFile();
            	 System.out.println(file.getPath());
            	 
             }
		}
		if(e.getSource() == mntmSalir){
			dispose();
		}
		
	}
}
