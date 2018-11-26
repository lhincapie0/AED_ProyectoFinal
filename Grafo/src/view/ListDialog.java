package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Exception.NodeNotFoundException;

public class ListDialog extends JDialog implements ActionListener{

	public static final String VER = "ver";
	
	private JComboBox<String> busquedaBox;
	private JComboBox<String> ciudadesBox;
	private JComboBox<String> grafoBox;

	private JButton verBut;
	
	private String[] cities;
	private JList<String> citiesList;
	private DefaultListModel<String> listModel;
	
	
	private MainWindow mainWindow;
	
	
	public ListDialog(MainWindow mainWindow) 
	{
		this.mainWindow = mainWindow;
		Font font = new Font("Ink free",Font.BOLD,20);
		this.setSize(1200,600);
		
		this.setLayout(new BorderLayout());
		
		
		busquedaBox = new JComboBox<String>();
		busquedaBox.setFont(font);
		busquedaBox.setBackground(Color.WHITE);
		busquedaBox.addItem("BFS");
		busquedaBox.addItem("DFS");
		grafoBox  = new JComboBox<String>();
		grafoBox.addItem("Lista de Adyacencia");
		grafoBox.addItem("Matriz de Adyacencia");
		grafoBox.setFont(font);
		grafoBox.setBackground(Color.WHITE);
		verBut = new JButton("Ver lista de ciudades");
		verBut.setFont(font);
		verBut.setActionCommand(VER);
		verBut.addActionListener(this);
		ciudadesBox = new JComboBox<String>();
		ciudadesBox.setFont(font);
		ciudadesBox.setBackground(Color.WHITE);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);

		
		cities = mainWindow.getCitiesNames();
		for(int i = 0; i< cities.length;i++)
		{
			ciudadesBox.addItem(cities[i]);
		}
		panel1.setLayout(new GridLayout(1,4,5,5));
		panel1.add(busquedaBox);
		panel1.add(grafoBox);
		panel1.add(ciudadesBox);
		panel1.add(verBut);
		
		
		listModel = new DefaultListModel<String>();
		
		listModel.addElement("");
		citiesList = new JList<String>(listModel);
		citiesList.setFont(font);

		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(citiesList,BorderLayout.CENTER);
		p.add(new JScrollPane(citiesList));
		this.add(panel1,BorderLayout.NORTH);		
		this.add(p,BorderLayout.CENTER);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getActionCommand().equals(VER))
		{
			System.out.println("jajaj");
			
			int busq = busquedaBox.getSelectedIndex();
			int graf = grafoBox.getSelectedIndex(); 
			int city = ciudadesBox.getSelectedIndex();
			String cityh = cities[city];
			
			try {
				listModel.removeAllElements();
				ArrayList<String> c = mainWindow.getList(busq, graf, cityh);
				for(int i = 0; i<c.size();i++)
				{
					listModel.addElement(c.get(i));
				}
			} catch (NodeNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
