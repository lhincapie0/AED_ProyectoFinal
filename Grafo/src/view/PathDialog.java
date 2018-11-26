package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.scene.layout.Border;

public class PathDialog extends JDialog implements ActionListener {

	
	public static final String CALCULATE = "calculate";
	public static final String CHANGE = "change";
	
	
	
	private JButton calculateBut;
	private MainWindow mainWindow;

	
	private JTextArea distanceTxt;
	
	
	private JComboBox origenBox;
	private JComboBox destinoBox;
	private int origen;
	private int destiny;
	private String[] cities;
	
	private JLabel actualGraphLab;
	private JButton changeGraphBut;
	private JTextArea actualGraphTxt;
	
	private JList<String> path;
	private DefaultListModel<String> listModel;
	
	
	
	public PathDialog(MainWindow mainWindow) {
		
		
		
		Color color = new Color(119,136,153);
		Font font = new Font("Ink free",Font.BOLD,30);
		Font font2 = new Font("Ink free",Font.BOLD,20);
		Font font3 = new Font("Ink free",Font.BOLD,15);


		Color colorLetra = new Color (30,144,205);
	
		this.setSize(1600,800);
		this.setLayout(new GridLayout(1,2));
		this.mainWindow = mainWindow;
		calculateBut = new JButton("Calcular ruta más corta");
		calculateBut.setSize(300, 200);
		calculateBut.setActionCommand(CALCULATE);
		calculateBut.addActionListener(this);
		calculateBut.setBackground(color);
		calculateBut.setForeground(Color.WHITE);
		calculateBut.setFont(font);
		calculateBut.setRolloverEnabled(true);
		calculateBut.setBorderPainted(false);
		calculateBut.setBorder(BorderFactory.createBevelBorder(30));
		this.setBackground(Color.WHITE);
		
		
		cities = mainWindow.getCitiesNames();
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(new BorderLayout());
		
		JPanel panel11 = new JPanel();
		panel11.setLayout(new GridLayout(4,2,10,100));
		panel11.setBackground(Color.WHITE);
		
		JLabel origenLab = new JLabel("    Origen");
		origenLab.setAlignmentX(CENTER_ALIGNMENT);
		origenLab.setFont(font);
		origenLab.setOpaque(true);
		origenLab.setBackground(Color.WHITE);
		
		origenBox = new JComboBox<String>();
		JLabel destinoLab = new JLabel("    Destino");
		origenBox.setFont(font2);
		origenBox.setBackground(Color.WHITE);
		destinoLab.setFont(font);
		destinoLab.setOpaque(true);
		destinoLab.setBackground(Color.WHITE);
		destinoBox = new JComboBox<String>();
		destinoBox.setBackground(Color.WHITE);
		destinoBox.setFont(font2);
		
		JLabel espace = new JLabel("");
		espace.setBackground(Color.WHITE);
		
		panel11.add(espace);
		panel11.add(espace);
		panel11.add(origenLab);
		panel11.add(origenBox);
		panel11.add(destinoLab);
		panel11.add(destinoBox);
		panel11.add(espace);
		panel11.add(espace);
		
		for(int i = 0;i<cities.length;i++)
		{
			origenBox.addItem(cities[i]);
			destinoBox.addItem(cities[i]);

		}

		JLabel distanceLab = new JLabel("Distancia mínima (min): ");
		distanceLab.setForeground(colorLetra);
		distanceLab.setFont(font2);
		distanceLab.setBackground(Color.WHITE);
		
		
		
		JPanel panel21 = new JPanel();
		panel21.setBackground(Color.white);
		panel21.setLayout(new GridLayout(1, 2, 20,20));
		distanceTxt = new JTextArea();
		distanceTxt.setFont(font2);
		distanceTxt.setForeground(Color.LIGHT_GRAY);
		distanceTxt.setBackground(Color.WHITE);
		distanceTxt.setOpaque(true);
		
		

		panel21.add(distanceLab);
		panel21.add(distanceTxt);
		
		
		listModel = new DefaultListModel<String>();
		listModel.addElement("Camino más corto");
		   path = new JList<String>(listModel);
		   path.setFont(font2);
		   path.setEnabled(true);
		panel1.add(calculateBut,BorderLayout.SOUTH);
		panel1.add(panel11,BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBackground(Color.WHITE);
		panel2.add(path, BorderLayout.CENTER);
		panel2.add(panel21,BorderLayout.NORTH);
		
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(1,3));
	
		actualGraphLab = new JLabel("Grafo representado con: ");
		actualGraphLab.setFont(font2);
		options.setBackground(Color.WHITE);
		changeGraphBut = new JButton("Cambiar representación del grafo");
		changeGraphBut.setForeground(colorLetra);
		changeGraphBut.setActionCommand(CHANGE);
		changeGraphBut.addActionListener(this);

		changeGraphBut.setBorder(BorderFactory.createBevelBorder(20));
		changeGraphBut.setFont(font3);
		actualGraphLab.setBackground(Color.WHITE);
		actualGraphTxt = new JTextArea();
		actualGraphTxt.setFont(font3);
		actualGraphTxt.setOpaque(true);
		actualGraphTxt.setBackground(Color.white);
		
		String actual = mainWindow.getGraphRepresentation();
		actualGraphTxt.setText(actual);
		options.add(actualGraphLab);
		options.add(actualGraphTxt);
		options.add(changeGraphBut);
		panel2.add(options,BorderLayout.SOUTH);

		
		this.add(panel1);
		this.add(panel2);
		
	}




	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getActionCommand().equals(CALCULATE))
		{
			try {
				System.out.println("entro");
				listModel.removeAllElements();
				String[] p = mainWindow.calculateShortestPath(cities[origenBox.getSelectedIndex()], cities[destinoBox.getSelectedIndex()]);
				for(int i = 0; i< p.length;i++)
				{
					listModel.addElement(p[i]);
					
				}
				
				distanceTxt.setText(mainWindow.getShortestDistance(cities[origenBox.getSelectedIndex()], cities[destinoBox.getSelectedIndex()]));
			} catch (Exception e) {
					System.out.println("NOT POSSIBLE PATH");
			}
		}
		
		if(event.getActionCommand().equals(CHANGE))
		{
			mainWindow.changeGraphRepresentation();
			String actual = mainWindow.getGraphRepresentation();
			actualGraphTxt.setText(actual);
		
			
		}
	}




}
