package 
view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MenuPanel extends JPanel implements ActionListener{

	
	public static final String MAPA = "mapa";
	public static final String RUTAS = "rutas";
	public static final String PLANIFICAR = "planificar";
	
	private MainWindow mainWindow;
	private JButton mapaBut;
	private JButton rutasBut;
	private JButton planificarBut;

	
	
	public MenuPanel(MainWindow mainWindow)
	{
		super(true);
		this.setSize(800, 400);
		this.mainWindow = mainWindow;
		this.setBackground(Color.white);

	
		this.setLayout(new GridLayout(1, 3,5,0));
		
		Font fuente = new Font("Ink Free", Font.BOLD, 18);
		Font fuente2 = new Font("Ink Free", Font.PLAIN, 30);
		Color colorLetra = new Color (30,144,205);
	
		TitledBorder border = new TitledBorder("MENU");
	    border.setTitleJustification(TitledBorder.LEFT);
	    border.setTitlePosition(TitledBorder.TOP);
	    border.setTitleFont(new Font("Calibri", Font.BOLD, 18));
	    border.setTitleColor(colorLetra);
	    
	  
	    		


	    mapaBut = new JButton("Ver mapa ferroviario");
	    mapaBut.setActionCommand(MAPA);
	    mapaBut.addActionListener(this);
	    rutasBut = new JButton("Ver rutas directas desde una ciudad");
	    rutasBut.setActionCommand(RUTAS);
	    rutasBut.addActionListener(this);
	    planificarBut = new JButton("Planificar mi viaje en el menor tiempo");
	    planificarBut.setActionCommand(PLANIFICAR);
	    planificarBut.addActionListener(this);
		  
		mapaBut.setFont(fuente2);
		mapaBut.setForeground(colorLetra);
		rutasBut.setFont(fuente2);	
		rutasBut.setForeground(colorLetra);
		planificarBut.setFont(fuente2);
		planificarBut.setForeground(colorLetra);
		mapaBut.setBorder(BorderFactory.createBevelBorder(20));
		rutasBut.setBorder(BorderFactory.createBevelBorder(20));
		planificarBut.setBorder(BorderFactory.createBevelBorder(20));
		
	    this.add(mapaBut);
	    this.add(rutasBut);
	    this.add(planificarBut);
		
	}



	@Override
	public void actionPerformed(ActionEvent command) {
		
		if(command.getActionCommand().equals(MAPA))
		{
	
		}
	
		if(command.getActionCommand().equals(RUTAS))
		{
			mainWindow.showRoutes();
		
		}
		
		if(command.getActionCommand().equals(PLANIFICAR))
		{
			
		}
	}
}
