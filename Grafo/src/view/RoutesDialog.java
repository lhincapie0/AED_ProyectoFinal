package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RoutesDialog extends JDialog implements ActionListener {
	
	public static final String ROUTES = "routes";
	public static final String CHANGE = "change";
	
	private JButton routes;
	private MainWindow mainWindow;
	private JList<String> cities;
	private DefaultListModel<String>  listModel;

	private JList<String> citiesAdjacents;
	private DefaultListModel<String>  listModel2;
	private JPanel listPanel; 
	private JPanel listAdjacentsPanel;
	
	private JLabel actualGraphLab;
	private JButton changeGraphBut;
	private JTextArea actualGraphTxt;
	
	private int actualIndex;
	private String actualCity;
	private Font fuente = new Font("Ink Free", Font.BOLD, 20);

	
	public RoutesDialog(MainWindow mainWindow)
	{
		 actualCity ="";
		 this.setSize(1400,800);
		 this.mainWindow = mainWindow;
		 setLayout(new BorderLayout());
		 this.setBackground(Color.WHITE);
		
		 Color colorLetra = new Color (30,144,205);
		 
		 JPanel title = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		 title.setBackground(Color.WHITE);
		 title.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		JLabel citiesTitle = new JLabel("Ciudades de destino");
		citiesTitle.setFont(new Font("Calibri", Font.BOLD, 20 ));
		citiesTitle.setForeground(new Color(30, 144, 205));
		citiesTitle.setBackground(Color.WHITE);
			title.add(citiesTitle);
			this.add(BorderLayout.NORTH, title);
			
			
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(1,2));
		listPanel.setBackground(Color.WHITE);
			
		routes = new JButton("Ver rutas directas");
		routes.setActionCommand(ROUTES);
		routes.setBorder(BorderFactory.createBevelBorder(20));
		routes.setForeground(colorLetra);
		routes.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		routes.setFont(fuente);
	
		routes.addActionListener(this);
		
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(1,4));
		options.add(routes);
		actualGraphLab = new JLabel("Grafo representado con: ");
		actualGraphLab.setFont(fuente);
		options.setBackground(Color.WHITE);
		changeGraphBut = new JButton("Cambiar representación del grafo");
		changeGraphBut.setForeground(colorLetra);
		changeGraphBut.setActionCommand(CHANGE);
		changeGraphBut.addActionListener(this);

		changeGraphBut.setBorder(BorderFactory.createBevelBorder(20));
		changeGraphBut.setFont(fuente);
		actualGraphLab.setBackground(Color.WHITE);
		actualGraphTxt = new JTextArea();
		actualGraphTxt.setFont(fuente);
		actualGraphTxt.setOpaque(true);
		actualGraphTxt.setBackground(Color.white);
		
		String actual = mainWindow.getGraphRepresentation();
		actualGraphTxt.setText(actual);
		options.add(routes);
		options.add(actualGraphLab);
		options.add(actualGraphTxt);
		options.add(changeGraphBut);
		this.add(options,BorderLayout.SOUTH);
		
		
		
		String[] citiesNames = mainWindow.getCitiesNames();
		listModel = new DefaultListModel<>();
		if(citiesNames != null)
		{
			for(int i = 0; i<citiesNames.length;i++)
			{
				listModel.addElement(citiesNames[i]);
			}
		}
		
		cities = new JList<String>(listModel);
		cities.setFont(fuente);
		listPanel.add(cities);
		listPanel.add( new JScrollPane(cities));
		cities.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		cities.setFocusable(true);
		
		cities.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
				{
					actualCity = cities.getSelectedValue();
					actualIndex = cities.getSelectedIndex();
					System.out.println(actualCity);  
					System.out.println(actualIndex);
					//ventana.mostrarJugadores(seleccionActual);
				}
			
				
			}
		});
		String[] citiesad = mainWindow.showAdjacents("Amsterdam");
		listModel2 = new DefaultListModel<>();
		if(citiesad != null)
		{
			for(int i = 0; i<citiesad.length;i++)
			{
				listModel2.addElement(citiesad[i]);
		}
	}
		
		citiesAdjacents = new JList<String>(listModel2);
		citiesAdjacents.setFont(fuente);
		listPanel.add(citiesAdjacents);
		
		this.add(listPanel,BorderLayout.CENTER);
	
		
	}

	
	
	
	public void showAdjacents(String[] adj)
	{
		String[] citiesNames = adj;
		if(citiesNames != null)
		{
			for(int i = 0; i<citiesNames.length;i++)
			{
				listModel2.addElement(citiesNames[i]);
			}
		}
	
	}
	@Override
	public void actionPerformed(ActionEvent command) {

		
		if(command.getActionCommand().equals(ROUTES))
		{
			
			listModel2.removeAllElements();
			showAdjacents(mainWindow.showAdjacents(actualCity));
		}
		if(command.getActionCommand().equals(CHANGE))
		{
			mainWindow.changeGraphRepresentation();
			String actual = mainWindow.getGraphRepresentation();
			actualGraphTxt.setText(actual);
			listModel.addElement(actual);
			
		}
		
	}

	
	
	
	
}
