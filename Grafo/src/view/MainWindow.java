package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Main;

public class MainWindow extends JFrame {
	
	
	
	private ImagePanel imagePanel;
	private MenuPanel menuPanel;
	private Main main;
	
	
	public MainWindow() throws Exception
	{
		
		super("EURAIL");
		setSize(1800,1000);
		main = new Main();

		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		imagePanel = new ImagePanel();
		menuPanel = new MenuPanel(this);
		this.add(imagePanel,BorderLayout.CENTER);
		this.add(menuPanel,BorderLayout.SOUTH);
	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
			}
		});

	}
	
	
	public void showRoutes()
	{
		System.out.println("shit");
		RoutesDialog d = new RoutesDialog(this);
		d.setVisible(true);
		d.setLocationRelativeTo(this);	
	}
	
	
	public void changeGraphRepresentation()
	{
		main.changeGraphRepresentation();
	}
	
	public String getGraphRepresentation() {
		return main.getGraphRepresentation();
	}
	
	public String[] showAdjacents(String city)
	{
		
		//TO DO
		ArrayList<String> adj = main.getAdyacents(city);
		String[] adjacents = new String[adj.size()];

		
		for(int i = 0; i<adj.size();i++)
		{
			adjacents[i] = adj.get(i);
		}
		return adjacents;
	}
	
	
	public String[] getCitiesNames()
	{
		ArrayList<String> names = main.getNodes();
		String[] namesArray = new String[names.size()];
		for(int i = 0; i<names.size();i++)
		{
			namesArray[i] = names.get(i);
		}
		return namesArray;
	}
	public static void main(String[] args) throws Exception
	{
		MainWindow mw = new MainWindow();
		mw.setVisible(true);
	}

}
