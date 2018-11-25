package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame{

	
	
	private MainPanel mainPanel;
	private MainContainer mainContainer;
	
	
	public MainWindow()
	{
		this.setTitle("EURORAIL");
		this.setSize(800, 800);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		mainContainer = new MainContainer(this);
		this.add(BorderLayout.CENTER, mainContainer);
	}
	
	
	public static void main(String[] args)
	{
		MainWindow w = new MainWindow();
		w.setVisible(true);
	}
}
